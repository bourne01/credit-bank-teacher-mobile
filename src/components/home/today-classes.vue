<template>
    <div>
        <div class="header">
            <div class="today-course-txt">今日您有<span style="color:red;">{{todayTotalClasses}}</span>堂课程</div>
            <span to="/course-list" class="all-courses" @click="onClick">{{allCourseText}}
                <img :src="require('../../assets/forward.png')" alt=""></span>
        </div>
        <div :style="classList"></div>
        <div class="class-info" v-if="isShow">
            <div class="class-time-sequence">
                <div class="class-sequence">
                    <span>1</span>
                    <div class="dashed-line"></div>
                </div>
                <div class="class-time">
                    <img :src="require('../../assets/time.png')" alt="">
                    &nbsp;&nbsp;&nbsp;{{todayFirstClass.classTime}}
                </div>                        
            </div>
            <div class="course" @click="goClassAtt(todayFirstClass,classOrders[0])">
                <div class="course-name">{{todayFirstClass.coursename}}</div>
                <div class="class">
                    <img :src="require('../../assets/classmate.png')" alt="">
                    &nbsp;<span class="item-text">班级</span>&nbsp;<span class="classname">{{todayFirstClass.classname}}</span>
                </div>
                <div class="classroom">
                    <img :src="require('../../assets/classroom.png')" alt="">
                    &nbsp;<span class="item-text">教室</span>&nbsp;<span class="classroom-name">{{todayFirstClass.classroom}}</span>
                </div>
                <div class="teacher">
                    <img :src="require('../../assets/teacher.png')" alt="">
                    &nbsp;<span class="item-text">老师</span>&nbsp;<span class="teacher-name">{{teacher.name}}</span>
                </div>
            </div>
            <exception @exception="getException" v-if="isException"></exception>
        </div>
        <div class="class-info" v-else v-for="(todayClass,index) in todayClasses" :key="index">
            <div class="class-time-sequence">
                <div class="class-sequence">
                    <span>{{index+1}}</span>
                    <div class="dashed-line"></div>
                </div>
                <div class="class-time">
                    <img :src="require('../../assets/time.png')" alt="">
                    &nbsp;&nbsp;&nbsp;{{todayClass.classTime}}
                </div>                        
            </div>
            <div class="course" @click="goClassAtt(todayClass,classOrders[index])">
                <div class="course-name">{{todayClass.coursename}}</div>
                <div class="class">
                    <img :src="require('../../assets/classmate.png')" alt="">
                    &nbsp;<span class="item-text">班级</span>&nbsp;<span class="classname">{{todayClass.classname}}</span>
                </div>
                <div class="classroom">
                    <img :src="require('../../assets/classroom.png')" alt="">
                    &nbsp;<span class="item-text">教室</span>&nbsp;<span class="classroom-name">{{todayClass.classroom}}</span>
                </div>
                <div class="teacher">
                    <img :src="require('../../assets/teacher.png')" alt="">
                    &nbsp;<span class="item-text">老师</span>&nbsp;<span class="teacher-name">{{teacher.name}}</span>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import Exception from './exception-popup'
export default {
    props:['schedule','teacher','term-id','is-exception'],
    components:{
        Exception
    },
    data(){
        return{
            todayFirstClass:{classname:'',coursename:'',classroom:''},
            classTimeList:[
                            '08:00-08:40','08:50-09:30','09:40-10:20','10:30-11:10',
                            '13:30-14:10','14:20-15:00','15:10-15:50','16:00-16:40'],
            todayTotalClasses:0,//今日总共多少节课
            firstClassTime:'',//第一节上课时间
            todayClasses:[],//今日课程数
            allCourseText:'查看全部课程',
            classOrders:[],//记录有课的课序号
            classIds:[],//记录本课的授课班级Id
            isShow:true,
            me:null,//当前教师对象
            classList:{maxHeight:'',overflow:'auto'},
            //isException:false
        }
    },
    methods:{
        /**@function 监听查看课程事件 */
        onClick(){
            if(this.isShow == true)
                this.allCourseText = '收缩全部课程';
            else{
                this.allCourseText = '查看全部课程';
            }           
            this.isShow=!this.isShow;                        
        },
        /**@function 获取当前是第几周 */
        getCurWeek(){
            let url = '../credit/term!getCurWeek.action';
            let params = {state:2};
            this.$http(url,{params})
                .then( res => {
                    console.log(res);
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
        /**@function 从课表中获取今日第一节课 
        */
        getTodayClass(){
            //上课时间表
            let date = new Date();
            let today = date.getDay();//今日，值为0~6,0为星期天
            if(today ==0){
                today = 7; 
            }else{
                today = today - 1;
            }
            let isFirstClass = true;//是否今日头节课
            if(!this.schedule.length)return;
            for(let i=0;i<8;i++){//8为一天总共有多少节课
                console.log(this.schedule[i][today]);
                if(this.schedule[i][today][0] && isFirstClass){
                    this.todayFirstClass.classname = this.schedule[i][today][0];
                    this.todayFirstClass.classroom = this.schedule[i][today][2];
                    this.todayFirstClass.coursename = this.schedule[i][today][1];
                    this.todayFirstClass.classTime = this.classTimeList[i];
                    this.todayFirstClass.courseId = this.schedule[i][today][4];
                    this.todayFirstClass.classId = this.schedule[i][today][3];
                    this.todayTotalClasses++;
                    isFirstClass = false;
                    this.todayClasses.push(this.todayFirstClass);
                    this.classOrders.push(i+1);
                }else if(this.schedule[i][today][0]){
                    this.todayTotalClasses++;
                    this.todayClasses.push({
                                            classname:this.schedule[i][today][0],
                                            classTime:this.classTimeList[i],
                                            classroom:this.schedule[i][today][2],
                                            coursename:this.schedule[i][today][1],
                                            courseId:this.schedule[i][today][4],
                                            classId: this.schedule[i][today][3],
                                        });
                    this.classOrders.push(i+1);
                }
            }
        },        
        /**@function 跳转到课堂考勤 */
        goClassAtt(course,classOrder){
            course.section = classOrder;
            course.termId = this.termId;
            course.teacher = this.teacher;
            this.$router.push({path:'/class-att',query:course})
        },
        /**捕获网络异常事件 */
        getException(){
            //this.isException = false;
            this.$emit('exception');
            console.log('Got an exception from network...')
        }
        
    },
    watch:{
            schedule:{
                handler:function(newVal, oldVal){                    
                    this.getTodayClass();
                },
                deep:true,                
            }
        },
    mounted(){
        let htmlHeight = document.documentElement.clientHeight || document.body.clientHeight;
        let htmlWidth = document.documentElement.clientWidth || document.body.clientWidth;
        let classList = htmlHeight - (642*htmlWidth/375) + 'px';       
        this.classList.maxHeight = classList;
        this.getTodayClass();
    }
}
</script>

<style lang="scss" scoped>
    @function px2rem($px){
        $rem:37.5px;
        @return ($px / $rem) + rem; 
    }
    .today-course-txt{
        font-family: 'PingFang-SC-Heavy';
        font-size:px2rem(28px);
        color:rgb(28,38,57);
    }
    .header{
        display:flex;
        justify-content: space-between;
        margin-bottom:px2rem(40px);
    }
    .all-courses{
        font-family: 'PingFang-SC-Medium';
        font-size:px2rem(24px);
        color:rgb(155,158,163);
    }
    .header img{
        width:px2rem(40px);
        vertical-align: px2rem(-10px);
        
    }
    .class-info{
        position: relative;
    }
    .class-time-sequence{
        display:flex;
        justify-content: space-between;
    }
    .class-sequence{
        border-radius: px2rem(36px);
        background-color:#5c9dff;
        width:px2rem(36px);
        height:px2rem(36px);
        text-align: center;
        line-height:px2rem(36px);
        font-size:px2rem(24px);
        position: relative;
        color:#fff;
    }
    .dashed-line{
        width:0;
        height:px2rem(266px);
        border-left:1px dashed #9b9ea3;
        position: absolute;
        left:px2rem(18px);
    }
    .class-time{
        height:px2rem(36px);
        line-height:px2rem(36px);
        font-size:px2rem(24px);
        width:px2rem(594px);
        border-radius: px2rem(36px);
        background-color:rgb(251,245,243);
    }
    .class-time img{
        vertical-align: middle;
        width:px2rem(28px);
        margin-left:px2rem(40px);
    }
    .course{
        margin-left:px2rem(106px);
        height:px2rem(236px);
    }
    .course-name{
        margin-top:px2rem(30px);
        font-size:px2rem(28px);
        font-family: 'PingFang-SC-Heavy';
        color:rgb(28,38,57);
    }
    .course img{
        width:px2rem(30px);
        vertical-align: middle;
    }
    .course .item-text{
        font-size:px2rem(24px);
        font-family: 'PingFang-SC-Medium';
        color:rgb(163,170,185);
    }
    .classname,.classroom-name,.teacher-name{
        font-size:px2rem(24px);
        font-family: 'PingFang-SC-Medium';
        color:rgb(28,38,57);
    }
</style>
