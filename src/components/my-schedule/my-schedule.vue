<template>
  <div>
    <my-header class="header">
        <div class="left" slot="left" @click="goBack">
            <img :src="require('../../assets/backward.png')" alt="">
        </div>
        <div class="center" slot="center">
            {{dt.getFullYear()}}年{{dt.getMonth()+1}}月
        </div>            
        <div class="right" slot="right"></div>
    </my-header>
    <table>
        <thead>
        <tr>
            <th>第<br>{{curWeek}}<br>周</th>
            <th 
                v-for="(numCn,index) in numberCn"
                :class="{ thActive: (index+1)==curWeekday }" 
                :key="index">
                周{{numCn}}<!-- <br>{{index}}日 -->
            </th>
        </tr>
        </thead>
    </table>
    <div :style="objTbody">
        <table>
            <tbody>
                <tr v-for="(classes,row) in classTable" :key="row">
                    <td v-for="(_class,column) in classes" 
                        :class="{ tdActive: column==curWeekday&& column!=0 }" 
                        :key="column"
                        >   
                        <my-class
                            :row="row" 
                            :column="column" 
                            :my-class="_class"
                            :class-table="classTable">
                        </my-class>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</div>
</template>

<script>
import MyHeader from '../base/my-header'
import MyClass from './class'
export default {
    components:{
        MyClass,
        MyHeader,
    },
    data(){
        return{
            classTable:[],
            isActive:false,
            curWeek:'',
            curWeekday:'',
            dt:new Date(),
            numberCn:[
                    '一','二','三','四','五','六','日'
                    ],
            objTbody:{height:'',overflow:'scroll'},
        }
    },
    methods:{
        /**@function 返回上一个页面 */
        goBack(){
            history.go(-1);
            },
        /**@function 获取当前是第几周 */
        getCurWeek(){
            let url = '../credit/term!getCurWeek.action';
            let params = {state:2};
            this.$http(url,{params})
                .then( res => {
                    let objData = res.data;
                    if(objData.success){
                        this.curWeek = objData.week;
                        this.curWeekday = objData.weekday;
                    }else{
                        this.$msgbox(objData.message);
                    }
                })
                .catch( err => {

                })
        },
        /**@function 获取我的个人信息 */
        getMyInfo(){
            let url = '../credit/teacher!getCurrentUserInfo.action';
            let params = {};
            this.$http(url,{params})
                .then( res => {
                    let objData = res.data;
                    if(objData.success){
                        this.me = objData.data;
                        this.getTermList(this.me.autoId)
                    }
                })
                .catch(err => {
                    this.reqErrorHandler(err);
                })
        },
        /**@function 获取学期列表 
         * @param {教师Id} teaId
        */
        getTermList(teaId){
            let url = '../credit/term!getTermList.action';
            let params = {
                    state:2,
                       };
            this.$http(url,{params})
                .then( res => {
                    if(res.data.success){
                        let termList = res.data.dataList;
                        sessionStorage.setItem('TermList',JSON.stringify(termList));
                        for(let term of termList){
                            if(term.cur == 1){//当前学期值为1
                                this.curTerm = term;
                                this.getTeacherSchedule(teaId,term.autoId,2);
                                break;
                            }
                        }
                    }
                    
                })
                .catch(err => {
                    this.reqErrorHandler(err);
                })
        },
        /**@function 获取教师课程表 
         * @param {教师Id} teaId
         * @param {学期Id} termId
         * @param {查询角度--教师角度} angle=2 
        */
        getTeacherSchedule(teaId,termId,angle){
            let url = '../thrCou2!querySch2.action';
            let params = {
                        thrId:teaId,
                        termId,
                        angle};
            this.$http(url,{params})
                .then( res => {
                    let objData = res.data
                    if(objData.success){
                        let lineSchedule = [];//一个星期的所有某一节课，如从星期一到星期天
                        for(let i=0;i<8;i++){
                            objData.lineSched.forEach( (_class,index) => {
                                if(index%8 == i){//按节转化列表中数据
                                    lineSchedule.push(_class)
                                }
                            });
                            this.schedule.push(lineSchedule);
                            lineSchedule = [];
                        }
                        sessionStorage.setItem('Schedule',JSON.stringify(this.schedule))
                        this.reArrangeSchedule(this.schedule);
                        this.getCurWeek(); 
                    }
                })
                .catch(err => {
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
                    this.$msgbox('未授权登录,正在跳转...','',1000);
                    this.$router.push('/login')
                }
            }
            
        },
        /**@function 重新整理课表，以便向界面输出 
         * @param {课表} schedule
        */
        reArrangeSchedule(schedule){
            for(let i=0;i<schedule.length;i++){
            let lineSchedule = [];
            for(let j=0;j<7;j++){
                lineSchedule.push({
                            name:schedule[i][j][1],
                            classroom:schedule[i][j][2],
                            classname:schedule[i][j][0],
                            isShow:false})
            }
            lineSchedule.unshift(i);//向数组头部添加课序
            this.classTable.push(lineSchedule);
            }        
        }        
    },
    computed:{
        weekCn:function(){
            return this.numberCn[this.curWeek-1];
        }
    },
    created(){
        let schedule = JSON.parse(sessionStorage.getItem('Schedule'));
        //当shedule为null或是空数组，则向服务器发请求获得教师课表信息
        if(!schedule || schedule.length == 0){
            this.getMyInfo();
            return;
        }
        this.reArrangeSchedule(schedule);
        this.getCurWeek();    
    },
    mounted(){
        let htmlHeight = document.documentElement.clientHeight || document.body.clientHeight;
        let htmlWidth = document.documentElement.clientWidth || document.body.clientWidth;
        let tbodyHeight = htmlHeight - (98*htmlWidth/375) + 'px';       
        this.objTbody.height = tbodyHeight;
    }
}
</script>

<style lang="scss" scoped>
    @function px2rem($px){
        $rem:37.5px;
        @return ($px / $rem) + rem; 
    }
    table{
        border:0;
        margin:0;
        border-collapse:collapse;
        border-spacing:0;
        }
    thead tr{
        background-color:#f6f9f9;        
    }
    thead th{
        padding:0;
        width:px2rem(98px);
        font-size:px2rem(24px);
        height:px2rem(98px);
        line-height: 1.1em;
    }
    thead th:first-child{
        width: px2rem(64px);
        font-size:px2rem(24px);
    }
    tbody td{
        text-align: center;
        height:px2rem(208px);
        width:px2rem(98px);
        position: relative;
    }
    tbody td:first-child{
        width:px2rem(64px);
    }
    .tdActive{
        background-color:rgb(233,240,251);
    }
    .thActive{
        background-color:rgb(73,120,195);
        font-family: 'PingFang-SC-Bold';
        font-size:px2rem(28px);
        color:#f6f9f9
    }
</style>


