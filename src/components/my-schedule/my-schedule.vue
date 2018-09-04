<template>
  <div>
    <my-header class="header">
        <div class="left" slot="left" @click="goBack">
            <img :src="require('../../assets/backward.png')" alt="">
        </div>
        <div class="center" slot="center">
            <popup-picker 
                    :data="termList"
                    :columns="1"
                    v-model="value"                    
                    :placeholder="curTermName" 
                    :show-name="true"
                    @on-hide="onHide"
                    >
            </popup-picker>
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
    <div :style="tbody">
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
import { PopupPicker } from 'vux'
export default {
    components:{
        MyClass,
        MyHeader,
        PopupPicker
    },
    data(){
        return{
            classTable:[],
            isActive:false,
            curWeek:'',
            curWeekday:'',
            curTermName:'',
            curTermId:'',
            numberCn:[
                    '一','二','三','四','五','六','日'
                    ],
            tbody:{height:'',overflow:'scroll'},
        }
    },
    methods:{
        /**@function 返回上一个页面 */
        goBack(){
            history.go(-1);
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
                        this.$msgbox(objData.message);
                    }
                })
                .catch( err => {
                    this.reqErrorHandler(err);
                })
        },
        /**@function 获取学期列表 */
        getTermList(){
            let url = 'api/public/baseWebDat';
            let params = {
                        f:'uxTerm',
                        state:2,
                        simple:0
                       };
            this.$http(url,{params})
                .then( res => {
                    console.log(res.data);
                    this.termList = [];//清空已有的学期列表
                    //sessionStorage.setItem('TermList',JSON.stringify(termList));
                    let termList = res.data.dataList;
                    let curTerm = termList[0];
                    this.curTermName = curTerm.name+' >';
                    this.curTermId = curTerm.id;
                    termList.forEach((elem,idx) => {
                        this.termList.push({name:termList[idx].name+' >',value:termList[idx].id.toString()})
                    });
                    this.termList.unshift({name:"请选择学期 >",value:''});
                    this.getMySchedule(this.curTermId);
                })
                .catch(err => {
                    this.reqErrorHandler(err);
                })
        },
        /**@function 获取教师课程表 
         * @param {学期Id} termId
        */
        getMySchedule(termId){
            let url = 'api/public/thrCou!mySch.action';
            let params = {termId,};
            this.$http(url,{params})
                .then( res => {
                    let objData = res.data
                    if(objData.success){
                        let lineSchedule = [];//一个星期的所有某一节课，如从星期一到星期天
                        let schedule = [];//                       
                        for(let i=0;i<8;i++){
                            objData.lineSched.forEach( (_class,index) => {
                                if(index%8 == i){//按节转化列表中数据
                                    lineSchedule.push(_class)
                                }
                            });
                            schedule.push(lineSchedule);
                            lineSchedule = [];
                        }
                        this.reArrangeSchedule(schedule);
                        //sessionStorage.setItem('Schedule',JSON.stringify(this.schedule))
                    }
                })
                .catch(err => {
                    this.reqErrorHandler(err);
                })
        },
        /**@function 点击学期列表，获取课程列表 */
        onHide(){
            if(this.value.length == 0)return;//没有选择任何值
             this.classTable = [];//初始化课表
            this.getMySchedule(this.value[0]);
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
            console.log(this.classTable);     
        }
        
        
    },
    computed:{
        weekCn:function(){
            return this.numberCn[this.curWeek-1];
        }
    },
    created(){
        /* let schedule = JSON.parse(sessionStorage.getItem('Schedule'));
        //当shedule为null或是空数组，则向服务器发请求获得教师课表信息
        if(!schedule || schedule.length == 0){
            this.getTermList();
            return;
        }
        this.reArrangeSchedule(schedule);
        this.getCurWeek();  */   
        this.getTermList();
        this.getCurWeek(); 
    },
    mounted(){
        let htmlHeight = document.documentElement.clientHeight || document.body.clientHeight;
        let htmlWidth = document.documentElement.clientWidth || document.body.clientWidth;
        let tbodyHeight = htmlHeight - (98*htmlWidth/375) + 'px';       
        this.tbody.height = tbodyHeight;
    }
}
</script>

<style>
    .center .vux-popup-picker-select{
        text-align: center!important;
    }
</style>

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
        height:px2rem(124px);
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
    }
</style>


