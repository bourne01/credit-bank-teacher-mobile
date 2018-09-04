<template>
  <div>
        <my-header>
            <div slot="left" class="left"></div>
            <div class="center" slot="center">技师学院教务系统</div>
            <div slot="right" class="right">
                <img :src="require('../../assets/me.png')" alt="" @click="isCallMe=!isCallMe">
            </div>
        </my-header>
        <div class="main">
            <div class="banner">
                <div class="banner-left"></div>
                <div class="banner-center"></div>
                <div class="banner-right"></div>                
            </div>
            <div class="tools">
                <router-link :to="'/my-schedule'" class="view-schedule">
                    <img :src="require('../../assets/schedule.png')" alt="">
                    <span>查课表</span>
                </router-link>
                <router-link to='/course-list' class="record-score">
                    <img :src="require('../../assets/score.png')" alt="">
                    <span>录成绩</span>
                </router-link>
            </div>
            <div class="isolation-strip"></div>
            <div :style="objHeight">
                <div class="today-course">
                <today-class 
                    :schedule='schedule' 
                    :teacher="me"
                    :term-id="curTerm.autoId"
                    @exception="getException"
                    :is-exception="isException"></today-class>
                </div>
                <!-- <div class="isolation-strip"></div> -->
                <!-- <div class="campus-news">
                    <headline></headline>                
                </div> -->
            </div>
        </div>
        <div class="me-popup" v-if="isCallMe"><me  @close="closeMe" :me="me"></me></div> 
  </div>
</template>

<script>
import MyHeader from '../base/my-header'
import Headline from '../home/capmus-news/headline'
import TodayClass from './today-classes'
import Me from './me'
export default {
    components:{
        TodayClass,
        MyHeader,
        Headline,
        Me,
    },
    data(){
        return{
            isCallMe:false,
            curTerm:{},//当前学期
            schedule:[],
            todayFirstClass:{classname:'',coursename:'',classroom:''},
            todayTotalClasses:0,//今日总共多少节课
            firstClassTime:'',//第一节上课时间
            me:{},//当前教师对象
            isException:false,
            objHeight:{maxHeight:'',overflow:'auto'},
            isComCached:false,//组件是否是缓存着的，默认不是
        }
    },
    methods:{
        /**@function 监听me子组件的关闭事件，然后关闭隐藏me组件 */
        closeMe(){
            this.isCallMe = false;
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
                    //console.log(res.data);
                    let termList = res.data.dataList;
                    sessionStorage.setItem('TermList',JSON.stringify(termList));
                    this.getMySchedule(termList[0].id);
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
                    }else if(res.data.message.indexOf('权限错误') != -1){
                        this.$msgbox('权限错误,正在跳转...','',1000);
                        //location.href = 'http://my.wzzyzz.com/login?service='+location.href
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
                    this.$msgbox('未授权登录,正在跳转...','',500);
                    //location.href = 'http://my.wzzyzz.com/login?service='+location.href
            }}
        },
        /**捕获网络异常事件,然后重新发出Ajax请求 */
        getException(){
            this.isException = false;
            //this.$emit('exception');
            console.log('Got an exception from network...')
            this.getTermList();
        }
    },
    created(){
        this.getTermList();
    },
    mounted(){
        //this.getTermList();
        let htmlHeight = document.documentElement.clientHeight || document.body.clientHeight;
        let htmlWidth = document.documentElement.clientWidth || document.body.clientWidth;
        let tbodyHeight = htmlHeight - (286*htmlWidth/375) + 'px';       
        this.objHeight.maxHeight = tbodyHeight
    }
}
</script>

<style lang="scss" scoped>
    @function px2rem($px){
        $rem:37.5px;
        @return ($px / $rem) + rem; 
    }
    .right{
        text-align: center;
    }    
    .banner{
        display:flex;
        justify-content: space-between;
        padding:px2rem(10px) 0;
        background-color:#f2f3f9;
    }
    .banner-left{
        height:px2rem(252px);
        width:px2rem(29px);
        background-color:#5c9dff;
        border-top-right-radius: px2rem(5px);
        border-bottom-right-radius: px2rem(5px);
        margin-top:px2rem(10px)
    }
    .banner-center{
        background-image: url('../../assets/banner-center.png');
        width:px2rem(670px);
        height:px2rem(272px);
        background-size:contain;
    }
    .banner-right{
        width:px2rem(29px);
        height:px2rem(252px);
        background-image:url('../../assets/banner-right.jpg');
        background-size:contain;
        margin-top:px2rem(10px);
        border-top-left-radius: px2rem(5px);
        border-bottom-left-radius: px2rem(5px);
    }
    .tools{
        display:flex;
        justify-content: space-around;
        height:px2rem(130px);
        padding-top:px2rem(30px);
        margin-bottom:px2rem(20px);
    }
    .tools img{
        height:px2rem(80px);
    }
    .tools a{
        display:block;
        text-align: center;
    }
    .view-schedule img{
        position: relative;
        left:px2rem(4px)
    }
    .view-schedule,.record-score,.attendance{
        width:px2rem(100px);
        font-size:px2rem(24px);
        color:rgb(155,158,163);
        text-align:center;
    }
    .isolation-strip{
        height:px2rem(20px);
        background-color:#f2f3f9;
    }
    .today-course{
        padding:px2rem(36px) px2rem(40px) 0 px2rem(40px);
    }
    .campus-news{
        padding:px2rem(36px) px2rem(40px) 0 px2rem(40px);
    }
    .me-popup{
        width:100%;
        height:100%;
        position: fixed;
        background-color:rgba($color: #000000, $alpha: 0.2);
        top:0;
        left:0;
    }
</style>


