<template>
  <div @click="submitCredit">
        <my-header class="header">
            <div class="left" slot="left" @click="goBack">
                <img :src="require('../../assets/backward.png')" alt="">
            </div>
            <div class="center" slot="center">{{courseName}}</div>
            <div class="right" slot="right">
                <save-button @edit="getEditAction"></save-button>
            </div>
        </my-header>
        <table>
            <thead>
                <tr>
                    <th class="name">姓名</th>
                    <th class="process-score">平时成绩<!-- <br>学分< --></th>
                    <th class="mid-term-score">期中成绩<!-- <br>学分 --></th>
                    <th class="final-term-score">期末成绩<!-- <br>学分 --></th>
                    <th class="total-score">总评<!-- <br>学分 --></th>
                </tr>
            </thead>
        </table>
        <div class="tbody" :style="tbodyObj">
            <table>
                <tbody>
                    <tr v-for="(result,index) in stuCouResults" :key="index" @click="getStuResult(result)">
                        <td>
                            <div class="td-name">
                                <span>{{index+1}}</span>
                                <span>&nbsp;{{result.stuName}}&nbsp;
                                    <img 
                                        :src="require('../../assets/male.png')" alt="" 
                                        v-if="result.stuSex=='男'">
                                    <img 
                                        :src="require('../../assets/female.png')" alt="" 
                                        v-else>
                                    
                                </span>
                            </div>
                        </td>
                        <td>
                            <input type="text" :placeholder="placeholder" 
                                v-model="result.ordScore" 
                                :disabled="isDisabled"><!-- <br>
                                <span>{{result.ordScore/10}}</span> -->
                        </td>
                        <td>
                            <input type="text" :placeholder="placeholder" 
                                v-model="result.midScore" 
                                :disabled="isDisabled"><!-- <br>
                                <span>{{result.midCredit}}</span> -->
                        </td>
                        <td>
                            <input type="text" :placeholder="placeholder" 
                                v-model="result.finScore" 
                                :disabled="isDisabled"><!-- <br>
                                <span>{{result.finCredit}}</span> -->
                        </td>
                        <td>
                            <input type="text" :placeholder="placeholder" 
                                v-model="result.termScore" 
                                :disabled="isDisabled"><!-- <br>
                                <span>{{result.senCredit}}</span> -->
                        </td>
                    </tr>                
                </tbody>
            </table>
        </div>
  </div>
</template>

<script>
import MyHeader from '../../components/base/my-header'
import SaveButton from './save-button'
export default {
    components:{
        MyHeader,
        SaveButton,
    },
    data(){
        return{
            isDisabled:true,//默认不可编辑
            stuCouResults:[],//学生课程结果
            tbodyObj:{height:'',overflow:'scroll'},//表格内容高度及滚动样式
            placeholder:'',
            courseName:'',//课程名称
            /**以下四个为当前正在编辑的学生学分初始数据 */
            stuId:'19700101',//学生编号
            midScore:null,//期中成绩
            finScore:null,//期末成绩
            ordScore:null,//平时成绩
            stuResult:{
                midScore:null,//期中成绩
                finScore:null,//期末成绩
                ordScore:null,//平时成绩
            }
        }
    },
    methods:{
        /**@function 返回上一个页面 */
        goBack(){
            this.$router.push('/course-list');
        },
        /**@function 捕获编辑/保存按钮子组件的动作，切换成绩是否处于可录入 */
        getEditAction(eidtAction){
            if(eidtAction == 'edit'){
                this.isDisabled = false;//可编辑
                this.placeholder = '请录入';
            }else{
                this.isDisabled = true;//不可编辑
                this.placeholder = '';
                this.$msgbox('保存成功！','',500);
            }
        },
        /**@function 获取学生课程结果信息 */
        getCourseResult(queryParams){
            let url = 'api/stuCouRst!queryOneCou.action';
            let params = {
                        termId:queryParams.termId,
                        claId:queryParams.claId,
                        couId:queryParams.couId,
                    }
            this.$http(url,{params})
                .then( res => {
                    let objData = res.data;
                    if(objData.success){
                        this.stuCouResults = objData.dataList;
                    }
                })
                .catch( err => {
                    this.reqErrorHandler(err);
                })
        },
        /**@function 点击学生成绩的行，获取学生编号stuId */
        getStuResult(result){
            this.stuResult = result; 
            this.stuId = result.stuId;
        },
        /**@function 提交当前正在编辑的学分数据 */
        submitCredit(){
            setTimeout(() => {
                let finScore = null;//期末分数
                let midScore = null;//期中分数
                let ordScore = null;//平时分数
                let finCredit = null;//期末分数对应的学分
                let midCredit = null;//期中分数对应的学分
                let ordCredit = null;//平时分数对应的学分
                 //防止乱点事件产生提交
                if(this.stuId == '19700101')
                    return;
                if(this.stuId != this.stuResult){

                }
                /**判断期末成绩是否已经更改，更改则记录要提交的分数和相应的学分 */
                if(this.finScore != this.stuResult.finScore){
                    finScore = this.stuResult.finScore;
                    finCredit = this.stuResult.finCredit;
                    this.finScore = this.stuResult.finScore;
                    this.finCredit = this.stuResult.finCredit;
                }
                /**判断期中成绩是否已经更改，更改则记录要提交的分数和相应的学分 */
                if(this.midScore != this.stuResult.midScore){
                    midScore = this.stuResult.midScore;
                    midCredit = this.stuResult.midCredit;
                    this.midScore = this.stuResult.midScore;
                    this.midCredit = this.stuResult.midCredit
                }
                /**判断平时成绩是否已经更改，更改则记录要提交的分数和相应的学分 */
                if(this.ordScore != this.stuResult.ordScore){
                    ordScore = this.stuResult.ordScore;
                    ordCredit = this.stuResult.Credit;
                    this.ordScore = this.stuResult.ordScore;
                    this.ordCredit = this.stuResult.ordCredit;
                }
                /**如果期末、期中和平时成绩都没有更改，则返回 */
                if(!finScore && !midScore && !ordScore)
                    return;
                let url = 'api/stuCouRst!save.action.action';
                let params = {
                            finScore,
                            midScore,
                            ordScore,
                            termId:this.stuResult.termId,
                            couId:this.stuResult.courseId,
                            stuId:this.stuResult.stuId,
                            autoId:this.stuResult.autoId
                }
                this.$http(url,{params})
                    .then( res => {
                        console.log(res)
                    })
                    .catch( err => {
                        this.reqErrorHandler(err);
                        
                    })
            }, 1000);
           
        },
        /**@function Ajax请求异常处理 
         * @param {出错对象} errObj
        */
        reqErrorHandler(errObj){
            console.log(errObj);
            let errResStatus = errObj.response.status; 
            if(errResStatus == 500 || errResStatus == 504){
                //this.$msgbox('网络异常','请稍后重试！',2000);
                this.isException = true;
            }else if(errResStatus == 404){
                //this.$router.push('/page-not/found');
            }else if(errResStatus == 401){
                this.$msgbox('未授权登录,正在跳转...','',500);
                location.href = 'http://my.wzzyzz.com/login?service='+location.href
            } 
        }, 
    },   
       
    created(){
        console.log(this.$route.query);
        let params = this.$route.query;
        this.courseName = this.$route.query.couName;
        this.getCourseResult(this.$route.query)
    },
    mounted(){
        let htmlHeight = document.documentElement.clientHeight || document.body.clientHeight;
        let tbodyHeight = (htmlHeight - 50 -38)*2/37.5+'rem'; 
        this.tbodyObj.height = tbodyHeight;
    }
}
</script>

<style lang="scss" scoped>
    @function px2rem($px){
        $rem:37.5px;
        @return ($px / $rem) + rem; 
    }
    .save-txt{
        font-size:px2rem(28px);
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
    th{
        font-size:px2rem(24px);
        color:rgb(163,178,185);
        width:px2rem(136px);
        height:px2rem(76px);
        border-right:1px solid #f2f3f9;
    }
    th:last-child{
        border-right:none
    }
    .td-name{
        display:flex;
        justify-content: space-between;        
    }    
    .name{
        width:px2rem(202px);
    }
    tbody tr{
        border-bottom:1px solid #f2f3f9;
    }
    tbody td{
        padding:px2rem(10px) 0;
        font-size:px2rem(28px);
        font-family: 'PingFang-SC-Medium';
        color:rgb(28,38,57);
        text-align:center;
        border-right:1px solid #f2f3f9;
        width:px2rem(138px);
    }
    td>span{
        color:#a3b2b9;
        font-size:px2rem(24px);
    }
    tbody td:first-child{
        padding-left:px2rem(4px);
        padding-right:px2rem(4px); 
        width:px2rem(194px);
    }
    tbody td:last-child{
        border-right:none
    }
    .td-name img{
        width:px2rem(30px);
        height:px2rem(30px);
        vertical-align: middle;
    }
    tbody td input{
        border:none;
        outline: none;
        width:100%;
        text-align:center;
    }
    input[type="text"]:disabled{
        background-color:#fff;
    }    
</style>


