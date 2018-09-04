<template>
    <div>
        <div class="stu-list-txt">学生列表</div>
        <ul class="stu-list">
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
</template>

<script>
export default {
    props:['class-info'],
    data(){
        return{
            teachDate:{},
            stuList:[]
        }
    },
    methods:{
        /**@function 监听更改考勤状态事件，更改相应的样式 
         * @param {学生列表中的序号} index
         * @param {考勤类型值} value
        */
        activateStyle(index,value){
            this.stuList[index].attType = value;
            this.submitAtt(this.stuList[index],value)
        },
        /**@function 向服务器提交考勤数据
         * @param {考勤的学生对象} stu
        */
        submitAtt(stu,attType){
            let url = 'attence!changeAttenced.action';
            let param = {
                    "termId":		this.classInfo.termId,
                    "classId":		this.classInfo.classId,
                    "teacherId":	this.classInfo.teacherId,
                    "courseId":		this.classInfo.courseId,
                    "week":			this.teachDate.week,
                    "weekDay":		this.teachDate.weekday,
                    "section":		this.classInfo.section,
                    "studentId":    stu.stuId,
                    "attence":      attType
                }
            this.$http(url,{param})
                .then( res=>{
                    console.log(res)
                })
                .catch(err=>{
                    console.log(err);
                })
        }

    }, 
    created(){
        /**@function 监听来自组件class-info中的teach-date事件，获取教学周和星期几 */
        this.$root.bus.$on('teach-date',(teachDate)=>{
            this.teachDate = teachDate;
        })
        /**@function 监听来自组件class-info中的请假列表载入完毕事件 */
        this.$root.bus.$on('leave-list',(leaveList)=>{
            if(!leaveList.length){
                for(let stu of this.stuList){
                    stu.leaveStatus = 0;
                }
            }else{
                for(let leave of leaveList)
                {}
            }
        })
        /**@function 监听来自组件class-info中的考勤列表载入完毕事件 */
        this.$root.bus.$on('attendance-list',(attList)=>{
            if(!attList.length){
                for(let stu of this.stuList){
                    stu.attType = 1;
                }
            }else{
                for(let leave of leaveList){}
            }
        })
        /**@function 监听来自组件class-info中的学生列表载入完毕事件 */
        this.$root.bus.$on('student-list',(stuList)=>{
            for(let stu of stuList){
                this.stuList.push({name:stu.stuName,classId:stu.classId,stuId:stu.studentId});
            }
        })
    },
    mounted(){
        this.curTeacher = this.$route.params.username;        
    }
}
</script>

<style lang="scss" scoped>
    @function px2rem($px){
        $rem:37.5px;
        @return ($px / $rem) + rem; 
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

