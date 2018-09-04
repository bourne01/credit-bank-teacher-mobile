<template>
  <div>
      <my-header class="header">
            <div class="left" slot="left" @click="goBack()">
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
      <ul :style="objCouList">
          <li 
            v-for="(course,index) in courses" 
            :key="index" 
            class="course-item"
            @click="goRecordScore(index)">
              <course :course="course"></course>
          </li>
      </ul>
       
  </div>
</template>

<script>
import MyHeader from '../base/my-header'
import Course from './course'
import { PopupPicker } from 'vux'
export default {
    components:{
        MyHeader,
        Course,
        PopupPicker
    },
    data(){
        return{
            termList:[],
            curTermName:'',
            curTermId:'',
            courses:{},
            teaId:'',//教师Id
            value:[],
            objCouList:{height:'',overflow:'scroll'}
        }
    },
    methods:{
        /**@function 返回上一个页面 */
        goBack(){
            this.$router.push('/home')
        },
        /**@function 获取课程列表
         * @param {学期Id} termId
         * @param {教师Id} teaId
         */
        getCourseList(termId,teaId){
            let url = '../thrCou3!query.action'
            let params = {
                termId,
                teaId,
                page:1
            }
            this.$http(url,{params})
                .then( res => {
                    let objData = res.data;
                    if(objData.success){
                        this.courses = objData.dataList;
                    }else if(objData.message.indexOf('没有权限') != -1){
                        this.$msgbox('未授权登录,正在跳转...','',1000);
                        this.$router.push('/login')
                    }
                })
                .catch(err => {
                    this.reqErrorHandler(err);
                })
        },
        /**@function 获取我的个人信息 
         * @param {学期Id} termId
        */
        getMyInfo(termId){
            let url = '../credit/teacher!getCurrentUserInfo.action';
            let params = {};
            this.$http(url,{params})
                .then( res => {
                    let objData = res.data;
                    if(objData.success){
                        this.teaId = objData.data.autoId;
                        this.getCourseList(termId,objData.data.autoId);
                    }
                })
                .catch(err => {
                    this.reqErrorHandler(err);
                })
        },
        /**@function 获取学期列表 
        */
        getTermList(){
            let url = '../baseWebDat';
            let params = {
                        f:'comboTerm',
                        addType:1
                       };
            this.$http(url,{params})
                .then( res => {
                    this.termList = [];//清空已有的学期列表
                    this.curTermName = res.data[1][1]+' >';
                    this.curTermId = res.data[1][0]
                    this.getMyInfo(this.curTermId);
                    res.data.forEach((elem,idx) => {
                        this.termList.push({name:res.data[idx][1]+' >',value:res.data[idx][0].toString()})
                    });
                    console.log(this.termList)   
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
        /**@function 点击学期列表，获取课程列表 */
        onHide(){
            if(this.value.length == 0)return;//没有选择任何值
            this.curTermId = this.value[0];//设置当前学期
            this.getCourseList(this.value[0],this.teaId);
        },
        /**@function 点击课程进入成绩录入页面 
         * @param {课程对象列表中的下标} index
        */
        goRecordScore(index){
            let course = this.courses[index];
            //console.log(course);
            this.$router.push({
                    path:'/record-score',
                    query:{
                        couName:course.couName,
                        claId:course.classId,
                        couId:course.couId,
                        termId:this.curTermId}
            })
        }
    },
    created(){
        let termList = JSON.parse(sessionStorage.getItem('TermList'));
        /**@function 学期列表为null或为[]*/
        if(!termList || termList.length == 0){
            this.getTermList();
            return;
        }        
        //转换termList的数据格式，适合页面显示{name:,value:}
        termList.forEach( elem => {
            if(elem.cur == '1'){
                this.curTermId = elem.autoId;//当前学期Id
                this.curTermName = elem.name+' >';
            }
            this.termList.push({name:elem.name+' >',value:elem.autoId.toString()})
        })
        //console.log(this.termList);
        this.termList.unshift({name:"无限制 >",value:''});
        console.log(this.termList);
        this.getMyInfo(this.curTermId);
    },
    mounted(){
        /* let selector = document.querySelector('.vux-popup-picker-select');
        selector.style.textAlign = 'center'; */
        let htmlHeight = document.documentElement.clientHeight || document.body.clientHeight;
        let htmlWidth = document.documentElement.clientWidth || document.body.clientWidth;
        let couListHeight = htmlHeight - (50*htmlWidth/375) + 'px';       
        this.objCouList.height = couListHeight;
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
    .header{
        border-bottom:1px solid #f7f8fb!important;
    }
    .course-item{
        padding:px2rem(40px) px2rem(30px) 0 px2rem(40px);
        height:px2rem(108px);
        border-bottom:1px solid #f7f8fb;
    }
    .center{
        position: relative;
    }
</style>


