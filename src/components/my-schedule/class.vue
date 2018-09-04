<template>
    <div>
        <div class="class" :style="hasCourseStyle" v-html="classInfo" v-if="isShow" @click="onClick">        
        </div>
        <div class="popup-wrap" v-if="isPopup">
            <div class="detail-popup" >
                <header>
                    <span>{{myClass.name}}</span>
                    <img :src="require('../../assets/close.png')" alt="" @click="isPopup=false">
                </header>
                <div class="class-detail">
                    <div class="class-name">
                        <label for="">
                            <img :src="require('../../assets/classmate.png')" alt="">
                            <span>班级</span>
                        </label>
                        <span>{{curClass.classname}}</span>
                    </div>
                
                    <div class="classroom">
                            <label for="">
                                <img :src="require('../../assets/classroom.png')" alt="">
                                <span>教室</span>
                            </label>
                            <span>{{curClass.classroom}}</span>
                    </div>
                    <div class="current-week">
                            <label for="">
                                <img :src="require('../../assets/week.png')" alt="">
                                <span>周数</span>
                            </label>
                            <span>{{curMonth}}月&nbsp;-&nbsp;第{{curWeek}}周</span>
                    </div>
                    <div class="class-sequence">
                            <label for="">
                                <img :src="require('../../assets/class-sequence.png')" alt="">
                                <span>节数</span>
                             </label>
                            <span>{{weekday}}&nbsp;{{row+1}}&nbsp;~&nbsp;{{(row+courseSpan)+"节"}}</span>
                    </div>
                    <div class="teacher">
                            <label for="">
                                <img :src="require('../../assets/teacher.png')" alt="">
                                <span>教师</span>
                            </label>
                            <span>{{me.name}}</span>
                    </div>
                </div>
                <!-- <div class="class-student">
                    <div class="class-student-txt">课堂学生</div>
                    <div class="check-in">
                        <img :src="require('../../assets/student-avatar.png')" class="avatar1" alt="">
                        <img :src="require('../../assets/student-avatar.png')" class="avatar2" alt="">
                        <span>38人<img :src="require('../../assets/forward.png')" alt="" class="forward"></span>
                    </div>
                </div>
                <div class="checkin-button">学生签到</div> -->
            </div>
        </div>
    </div>
</template>

<script>
export default {
    props:['row','column','my-class','class-table'],
    data(){
        return{
            bgColors:[//课程的背景颜色，分别对应星期一到星期天
                    '',
                    'rgb(194,199,208)',
                    'rgb(126,224,167)',
                    'rgb(252,185,149)',
                    'rgb(211,143,233)',
                    'rgb(145,178,245)',
                    'rgb(111,217,201)',
                    'rgb(174,182,245)'],
            boxShadows:[//课程的边框阴影,分别对应星期一到星期天
                    'none',
                    '0px 0px  0px '+2/37.5+'rem rgb(163,170,185)',
                    '0px 0px  0px '+2/37.5+'rem rgb(72,193,123)',
                    '0px 0px  0px '+2/37.5+'rem rgb(250,128,81)',
                    '0px 0px  0px '+2/37.5+'rem rgb(167,87,192)',
                    '0px 0px  0px '+2/37.5+'rem rgb(99,137,215)',
                    '0px 0px  0px '+2/37.5+'rem rgb(50,181,161)',
                    '0px 0px  0px '+2/37.5+'rem rgb(122,134,226)',
            ],
            heights:[//某一天连续课节数的高度，1节，2节相连，3节相连，4节相连...
                    '',
                    (124-14)/37.5+'rem',
                    (124*2-14)/37.5+'rem',
                    (124*3-14)/37.5+'rem',
                    (124*4-14)/37.5+'rem',
                    (124*5-14)/37.5+'rem',
                    (124*6-14)/37.5+'rem',
                    (124*7-14)/37.5+'rem',
                    (124*8-14)/37.5+'rem',
            ],
            courseSpan:0,//多少节相同的连续课
            classInfo:'',//课程信息
            isShow:true,
            isPopup:false,
            curClass:{},//被点击后课程
            curTerm:{},//当前学期
            curWeek:'',//当前第几周
            curWeekday:'',//当前星期几,
            me:'',//当前教师            
        }
    },
    computed:{
        hasCourseStyle:function(){
            return{
                backgroundColor:this.bgColors[this.column],
                boxShadow:this.boxShadows[this.column],
                height:this.heights[this.courseSpan],
                /** 以下样式只是在第一列起作用 */
                color:this.column == 0?'rgb(163,170,185)':'#fff',
                fontSize:this.column == 0?24/37.5+'rem':'',
                textAlign:this.column == 0?'center':'',
                fontSize:this.column == 0?24/37.5+'rem':'',
                width:this.column == 0?46/37.5+'rem':'',
                height:this.column == 0?110/37.5+'rem':this.heights[this.courseSpan],
                lineHeight:this.column == 0?110/37.5+'rem':'',
            }
        },
        weekday:function(){
            let weekdaysCn = ['周一','周二','周三','周四','周五','周六','周日'];
            return weekdaysCn[this.column-1]; 
        },
        curMonth:function(){
            let dt = new Date();
            return dt.getMonth()+1;
        }
    },
    methods:{
        /**@function 监听点击课程事件，弹窗展示课程详情 */
        onClick(){
            this.isPopup = true;
            /* console.log('Row:'+this.row,'Column:'+this.column);
            console.log(this.classTable[this.row][this.column]) */
            this.curClass = this.classTable[this.row][this.column];
            /**@function 获取教学周信息 */
            this.getCurWeek();
            this.getMyInfo();
            //this.curTeacher = this.$route.params.username;
        },
        /**@function 获取我的个人信息 */
        getMyInfo(){
            let url = 'api/public/thr!myInf.action';
            let params = {};
            this.$http(url,{params})
                .then( res => {
                    let objData = res.data;
                    if(objData.success){
                        this.me = objData.data;
                        //this.getTermList(this.me.autoId)
                    }
                })
                .catch(err => {
                    this.reqErrorHandler(err);
                })
        },
        /**@function 获取当前是第几周 */
        getCurWeek(){
            let url = 'api/public/term!weekN.action';
            let params = {};
            this.$http(url,{params})
                .then( res => {
                    let objData = res.data;
                    if(objData.success){
                        this.curWeek = objData.weekN;
                        let dt = new Date();
                        if(dt.getDay() == 0){
                            this.curWeekday = 7;
                        }else{
                            this.curWeekday = dt.getDay();
                        }
                    }else{
                        console.log(objData);
                        this.$msgbox(objData.message);
                    }
                })
                .catch( err => {
                    this.reqErrorHandler(err);
                })
        },
        /**@function Ajax请求异常处理 
         * @param {出错对象} errObj
        */
        reqErrorHandler(errObj){
            console.log(errObj);
            if(errObj.response){ 
                let errResStatus = errObj.response.status; 
                if(errResStatus == 500 || errResStatus == 504){
                    //this.$msgbox('网络异常','请稍后重试！',2000);
                    this.isException = true;
                }else if(errResStatus == 404){
                    //this.$router.push('/page-not/found');
                }else if(errResStatus == 401){
                    //this.$msgbox('未授权登录,正在跳转...','',500);
                    //location.href = 'http://my.wzzyzz.com/login?service='+location.href
            }}
        },
        /**@function 当字符串的长度大于4个字符时，只截取前4 X 课程连接数（如第1、2节课）个，剩下内容用"..."表示 
         * @param {目标字符串} str
        */
        mySubString(str){
            /* if(str.length > 5){
                let _str = str;
                str = _str.substring(0,5*this.courseSpan);
                if(_str.length > 5*this.courseSpan)
                    str = str + '...';
            }                
            return str; */
            if(str.length > 14){
                let _str = str;
                str = _str.substring(0,14*this.courseSpan);
                if(_str.length > 14*this.courseSpan)
                    str = str + '...';               
            }                
            return str;
        },       
        },
        
    created(){        
        let courseName = this.myClass.name;//本节课程名称
        let _className = this.myClass.classname;//本节授课班级名称
        let classTableLen = this.classTable.length;//课表总长度
        /**@function 找出当天具有连续的相同课程名和教室的课 */
        for(let i=this.row;i<classTableLen;i++){
            let _curClass = this.classTable[i][this.column];
            if(_curClass.name == courseName && _curClass.classname == _className &&
               _curClass.isShow == false){//同列中是否存在连续的同名且同教室的课程，且未被显示
                this.courseSpan++;
                _curClass.isShow = true;//设置课程为显示
            }else{
                break;
            }
        }
        /**@function 本节无课程信息或者同上节相同，则不显示课程信息 */
        if(this.courseSpan == 0 || !courseName){
            this.isShow = false;
        }
        if(this.column == 0){
            this.isShow = true;
            this.classInfo = this.row+1;
        }else{
            this.classInfo ="<span>"+this.mySubString(this.myClass.name)+"</span>"; /* this.mySubString(this.myClass.classname);+'<br>'+
                            this.mySubString(this.myClass.name)+'<br>'+
                            this.mySubString(this.myClass.classroom); */
        }
        /**@function 从本地session中获取当前学期信息 */
        //let termList = JSON.parse(sessionStorage.getItem('TermList'));
        /**@function 学期列表为null或为[]*/
        /* if(!termList || termList.length == 0){
            this.getTermList();
            return;
        } 
        this.curTerm = termList[0]; */
        
    },
    mounted(){
       /*  let me = JSON.parse(sessionStorage.getItem('Me'));
        if(!me){
            this.getMyInfo();
        }else{
            this.me = me;
        } */
    }
}
</script>

<style lang="scss" scoped>
    @function px2rem($px){
        $rem:37.5px;
        @return ($px / $rem) + rem; 
    }
    .class{
        width:px2rem(74px);
        border-radius: px2rem(8px);
        //background-color:rgb(194,199,208);
        text-align: left;
        font-size:px2rem(24px);
        height:px2rem(110px);
        position: absolute;
        top:px2rem(2px);
        left:px2rem(2px);
        padding:px2rem(4px) px2rem(8px);
        //border:1px solid rgb(163,170,185);
        //box-shadow:0px 0px  0px px2rem(2px) rgb(163,170,185);
        color:#fff;
        z-index: 10;
        display: flex;
        flex-direction: column;
        justify-content: center;
    }
    .popup-wrap{
        position: fixed;
        height:100%;
        width:100%;
        background-color:rgba($color: #000000, $alpha: 0.4);
        top:0;
        left:0;
        z-index: 100
    }
    .detail-popup{
        position: fixed;
        top:px2rem(263px);
        left:px2rem(84px);
        background-color:#fff;
        //height:px2rem(840px);
        height:px2rem(640px);
        width:px2rem(582px);
        border-radius:px2rem(8px);
        line-height: 1em;
    }
    .detail-popup label img{
        vertical-align: middle;
        width:px2rem(28px);
        margin-right:px2rem(18px);
    }
    .detail-popup label{
        font-size:px2rem(24px);  
        color:rgb(28,38,57);
        display:inline-block;
        margin-right:px2rem(20px); 
    }
    .class-detail span{
        font-size:px2rem(28px);
        font-family: 'PingFang-SC-Medium';
    }
    .class-detail label span{
        color:rgb(163,170,185);
    }
    header{
        height:px2rem(120px);
        border-bottom:1px solid #f7f8fb!important;
        display:flex;
        justify-content: space-between;
    }
    header span{
        margin-top:px2rem(50px);
        margin-left:px2rem(50px);
        font-size:px2rem(36px);
        color:rgb(28,38,57);
        font-family: 'PingFang-SC-Medium';
    }
    header img{
        width:px2rem(48px);
        height:px2rem(48px);
        margin-top:px2rem(40px);
        margin-right:px2rem(30px);
    }
    header img:hover {
        background-color: rgba(0, 0, 0, 0.1);
    }
    .class-name,.classroom,.current-week,.class-sequence,.teacher{
        margin-top:px2rem(30px);
    }
    .class-detail{
        height:px2rem(335px);
        text-align: left;
        padding:0 px2rem(30px) 0 px2rem(30px);
        border-bottom:1px solid #f7f8fb!important;
    }
    .class-detail div:first-child{
        margin-top:px2rem(52px);
    }
    .class-student{
        text-align: left;
        padding:px2rem(40px) px2rem(30px) 0 px2rem(30px);

    }
    .class-student-txt{
        font-size:px2rem(28px);
        color:rgb(28,38,57);
        margin-bottom:px2rem(24px);
    }
    .check-in{
        position: relative;
        text-align: right;
    }
    img.avatar1,img.avatar2{
        position: absolute;
        width:px2rem(80px);
        z-index:102;
        left:0;
    }
    img.avatar2{
        z-index:101;
        left:px2rem(60px);
    }
    .check-in span{
        font-size:px2rem(24px);
        color:rgb(163,170,185);
        font-family: 'PingFang-SC-Medium';
    }
    img.forward{
        width:px2rem(70px);
        vertical-align: middle;
    }
    .checkin-button{
        height:px2rem(68px);
        width: px2rem(484px);
        border-radius:px2rem(34px);
        background-color:rgb(92,157,255);
        line-height:px2rem(68px);
        color:#fff;
        font-size:px2rem(28px);
        font-family: 'PingFang-SC-Medium';
        margin:0 auto;
        margin-top:px2rem(50px);
    }
</style>


