<template>
    <div>
        <div class="class-info-wrap">
        <div class="class-info-txt">
            当前课堂信息:
        </div>
        <div class="class-info">
            <span>第{{teachDate.week}}周&nbsp;|&nbsp;</span>
            <span>星期{{teachDate.weekday}}&nbsp;|&nbsp;</span>
            <span>第{{classInfo.section}}节&nbsp;|&nbsp;</span>
            <span>{{classInfo.classroom}}&nbsp;|&nbsp;</span>
            <span>{{classInfo.courseName}}</span>
        </div>
        <div class="statics">
            <span>班级总人数：<span style="color:#3dc894;">{{stuList.length}}</span></span>&nbsp;&nbsp;
            <span>已请假人数：<span style="color:#f91b1b;">{{leavedStus.length}}</span></span>
        </div>
        <div class="btn-wrap">
            <button class="no-absence" @click="fullyAttend">全勤</button>
            <button class="return" @click="goBack">确认返回</button>
        </div>
    </div>
    <div>
        <div class="stu-list-txt">学生列表</div>
        <ul class="stu-list" :style="{height:ulHeight}">
            <li v-for="(stu,index) in stuList" :key="index">
                <div class="stu">
                    <img :src="require('../../assets/stu-avatar.gif')" alt="">
                    <div class="stu-txt">
                        <span class="stu-name">{{stu.name}}</span>
                        <span class="leave-status">{{stu.leaveStatus?'已请假':'未请假'}}</span>
                    </div>
                </div>
                <div class="attendance">
                    <div class="normal circle" 
                        :class="{normalActive:stu.attType==1}"
                        @click="activateStyle(index,1)">
                        正常
                    </div>
                    <div class="late circle" 
                        :class="{lateActive:stu.attType==2}"
                        @click="activateStyle(index,2)">
                        迟到
                    </div>
                    <div class="early-leave circle" 
                        :class="{earlyLeaveActive:stu.attType==3}"
                        @click="activateStyle(index,3)">
                        早退
                    </div>
                    <div class="skip-class circle" 
                        :class="{skipClassActive:stu.attType==4}"
                        @click="activateStyle(index,4)">
                        旷课
                    </div>
                </div>
            </li>
        </ul>
    </div>
    </div>
    
</template>

<script>
export default {
    props:['class-info'],
    data(){
        return{
            classStus:[],//班级学生列表
            teachDate:{},//教学时间信息
            leavedStus:[],//请假学生列表
            attStus:[],//考勤学生列表,
            ulHeight:'',
            teachDate:{},
            stuList:[],//班级学生列表
        }
    },
    methods:{
        /**@function 获取当前是第几周 */
        getCurWeek(){
            let url = '../credit/term!getCurWeek.action';
            let params = {state:2};
            this.$http(url,{params})
                .then( res => {
                    let objData = res.data;
                    if(objData.success){
                        console.log(this.classInfo);
                        this.teachDate = objData;
                        //this.$root.bus.$emit('teach-date',this.teachDate)
                        console.log(objData.weekday);
                        this.getLeavedStus(
                                    this.classInfo.termId,
                                    this.classInfo.classId,
                                    this.classInfo.teacher.autoId,
                                    this.classInfo.courseId,
                                    objData.week,
                                    objData.weekday,
                                    this.classInfo.section);
                        this.getAttendance(
                                    this.classInfo.termId,
                                    this.classInfo.classId,
                                    this.classInfo.teacher.autoId,
                                    this.classInfo.courseId,
                                    objData.week,
                                    objData.weekday,
                                    this.classInfo.section);
                    }else{
                        this.$msgbox(objData.message);
                    }
                })
                .catch( err => {
                    this.reqErrorHandler(err);
                })
        
        },        
        /**@function 从服务器获取当前课堂请假人数 
         * @param {当前学期Id} termId
         * @param {班级Id} classId
         * @param {授课教师Id} teacherId
         * @param {当前课程Id} courseId
         * @param {当前教学周} week,
         * @param {星期几} weekDay
         * @param {今天第几节课} section
        */
        getLeavedStus(termId,classId,teacherId,courseId,week,weekDay,section){
            let url = '../leave!getleaveList.action';            
            let params = {
                        termId,
                        classId,
                        teacherId,
                        courseId,
                        week,
                        weekDay,
                        section
                    }
            console.log('Leave...')
            this.$http(url,{params})
                .then( res => {
                    let objData = res.data;
                    console.log(objData);
                    if(objData.success){
                        if(!objData.dataList.length){
                            for(let stu of this.stuList){
                                
                            }
                        }else{
                            for(let leave of objData.dataList)
                            {}
                        }
                        //this.$root.bus.$emit('leave-list',this.leavedStus)
                    }else{
                        this.$msgbox(objData.message);
                    }
                })
                .catch( err => {
                    this.reqErrorHandler(err);
                })
        },
        /**@function 获取考勤信息 
         * @param {当前学期Id} termId
         * @param {班级Id} classId
         * @param {授课教师Id} teacherId
         * @param {当前课程Id} courseId
         * @param {当前教学周} week,
         * @param {星期几} weekDay
         * @param {今天第几节课} section
        */
        getAttendance(termId,classId,teacherId,courseId,week,weekDay,section){
            let url = '../attence!getAttenceD.action';
            let params = {
                        termId,
                        classId,
                        teacherId,
                        courseId,
                        week,
                        weekDay,
                        section
                    }
            console.log('Attendance...');
            this.$http(url,{params})
                .then( res => {
                    let objData = res.data;
                    console.log(objData);
                    if(objData.success){
                        if(!objData.dataList.length){
                            for(let stu of this.stuList){
                                stu.attType = 1;
                            }
                        }else{
                            for(let att of objData.dataList){
                                console.log(att);
                                for(let stu of this.stuList){
                                    let i = 0;
                                    if(stu.stuId == att.TStudent){
                                        console.log(stu);
                                        if(att.FAttence == 3 || att.FAttence == 2)
                                            stu.attType = 2;
                                        else if(att.FAttence == 5){
                                            stu.attType = 4;
                                        }else if(att.FAttence == 4){
                                            stu.attType = 3;
                                        }else{
                                            stu.attType = att.FAttence;
                                        }
                                        //this.$set(this.stuList,i,stu);
                                        break;
                                    }
                                    i++;
                                }
                                    
                                    
                            }
                            console.log(this.stuList);
                        }
                        //this.$root.bus.$emit('attendance-list',this.attStus)
                    }else{
                        this.$msgbox(objData.message);
                    }
                })
                .catch( err => {
                    this.reqErrorHandler(err);
                })
        },
        /**@function 获取班级学生列表 
         * @param {当前班级Id} classId
        */
        getClassStus(classId){
            let url = '../claStu2!query.action';
            let params = {
                        classId,
                    }
            this.$http(url,{params})
                .then( res => {
                    let objData = res.data;
                    this.stuList = [];
                    if(objData.success){
                        for(let stu of objData.dataList){
                            this.stuList.push({name:stu.stuName,classId:stu.classId,stuId:stu.studentId,attType:1});
                        }
                        //this.$root.bus.$emit('student-list',this.classStus);
                        this.getCurWeek();
                    }else{
                        this.$msgbox(objData.message);
                    }
                })
                .catch( err => {
                    this.reqErrorHandler(err);
                })
        },
        /**@function 监听全勤按钮事件，提交全勤操作 
        */
        fullyAttend(){
            let url = '../attence!allAttence.action';
            let params = {
                        "termId":		this.classInfo.termId,
                        "classId":		this.classInfo.classId,
                        "teacherId":	this.classInfo.teacher.autoId,
                        "courseId":		this.classInfo.courseId,
                        "week":			this.teachDate.week,
                        "weekDay":		this.teachDate.weekday,
                        "section":		this.classInfo.section,
                    }
            this.$http(url,{params})
                .then( res => {
                    console.log(res)
                    if(res.data.success){
                        for(let stu of this.stuList){
                            stu.attType = 1;
                        }
                    }
                })
                .catch( err => {
                    console.log(err);
                    this.reqErrorHandler(err);
                })
        },
        /**@function 返回 */
        goBack(){
            history.go(-1);
        },
        /**@function 监听更改考勤状态事件，更改相应的样式 
         * @param {学生列表中的序号} index
         * @param {考勤类型值} value
        */
        activateStyle(index,value){
            this.stuList[index].attType = value;
            this.$set(this.stuList,index,this.stuList[index]);
            console.log(this.stuList[index]);
            this.submitAtt(this.stuList[index],value)
        },
        /**@function 向服务器提交考勤数据
         * @param {考勤的学生对象} stu
        */
        submitAtt(stu,attType){
            let _attType;
            if(attType == 3)
                _attType = 4;
            else if(attType == 4)
                _attType = 5;
            else{
                _attType = attType;
            }
            let url = '../attence!changeAttenced.action';
            let params = {
                    "termId":		this.classInfo.termId,
                    "classId":		this.classInfo.classId,
                    "teacherId":	this.classInfo.teacher.autoId,
                    "courseId":		this.classInfo.courseId,
                    "week":			this.teachDate.week,
                    "weekDay":		this.teachDate.weekday,
                    "section":		this.classInfo.section,
                    "studentId":    stu.stuId,
                    "attence":      _attType.toString()
                }
            this.$http(url,{params})
                .then( res=>{
                    console.log(res)
                })
                .catch(err=>{
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
    },  
    created(){
        if(this.classInfo.classId){
            this.getClassStus(this.classInfo.classId);
        }else{
            this.$msgbox('获取课堂信息出错','',1500);
        }
            
    },
    mounted(){
        let htmlHeight = document.documentElement.clientHeight || document.body.clientHeight;
        let htmlWidth = document.documentElement.clientWidth || document.body.clientWidth;
        let tbodyHeight = htmlHeight - (222*htmlWidth/375) + 'px';
        this.ulHeight = tbodyHeight
    }
}
</script>

<style lang="scss" scoped>
    @function px2rem($px){
        $rem:37.5px;
        @return ($px / $rem) + rem; 
    }
    .class-info-wrap{
        height:px2rem(232px);
    }
    .class-info-txt{
        font-size:px2rem(32px);
        font-family: 'PingFang-SC-Medium';
        margin-bottom:px2rem(10px);
    }
    .class-info{
        font-size:px2rem(24px);
        line-height:1.2em;
        text-indent:2em;
    }
    .statics{
        font-size:px2rem(32px);        
    }
    .btn-wrap{
        margin-top:px2rem(10px);
        padding-bottom:px2rem(20px);
        border-bottom: 1px solid #d6d8de;
    }
    .no-absence{
        background-color:#3dc894;
        font-size:px2rem(32px);
        text-align:center;
        padding:px2rem(10px) px2rem(40px);
        border-radius:px2rem(10px);
        border:none;
        color:#fff;
        box-shadow:0px px2rem(2px) 0px px2rem(2px) #1e976a;
        margin-right:px2rem(50px);
    }
    .return{
        font-size:px2rem(32px);
        text-align:center;
        padding:px2rem(10px) px2rem(20px);
        border-radius:px2rem(10px);
        border:none;
        color:#909090;
        background-color:#fff;
        box-shadow:0px 0px  0px px2rem(2px) #909090;
    }
    .stu-list-txt{
        font-size:px2rem(32px);
        font-family: 'PingFang-SC-Medium';
        margin-bottom:px2rem(20px);
        padding-bottom:px2rem(20px);
        padding-top:px2rem(20px);
        border-bottom: 1px solid #d6d8de; 
        height:px2rem(50px);
    }
    .stu-list{
        padding:0 px2rem(10px);        
        overflow-y: auto;
    }
    .stu-list li{
        display:flex;
        justify-content: space-between;
        padding:px2rem(4px) 0; 
        border-bottom: 1px solid #e9ecf7;
    }
    .stu{
        display:flex;
        width:px2rem(260px);        
    }
    .stu-name{
        font-weight: 600;
    }
    .leave-status{
        color:#650000
    }
    .stu img{
        width:px2rem(96px);
        height:px2rem(96px);
        margin-right:px2rem(4px);
    }
    .stu-txt{
        display:flex;
        flex-direction:column;
        align-items: center;
        justify-content: space-between;
        font-size:px2rem(28px);
    }
    .attendance{
        width:px2rem(400px);
        font-size:px2rem(32px);
        display:flex;
        justify-content: space-around;
        align-items: center;
    }
    .circle{
        width:px2rem(80px);
        height:px2rem(80px);
        border-radius:px2rem(40px);        
        line-height: px2rem(80px);
        text-align: center;
    }
    .normal{
        border:1px solid #3dc894;
        color:#3dc894;
    }
    .normalActive{
        background-color:#3dc894;
        color:#fff;
    }
    .late{
        border:1px solid #ffb751;
        color:#ffb751;
    }
    .lateActive{
        background-color:#ffb751;
        color:#fff;
    }
    .early-leave{
        border:1px solid #da37a6;
        color:#da37a6;
    }
    .earlyLeaveActive{
        background-color:#da37a6;
        color:#fff;
    }
    .skip-class{
        margin-top:px2rem(10px);
        border:1px solid #f91b1b;
        color:#f91b1b;
    }
    .skipClassActive{
        background-color:#f91b1b;
        color:#fff;
    }
</style>

