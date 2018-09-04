<template>
    <div>
        <my-header class="header">
            <div class="left" slot="left" @click="goBack()">
                <img :src="require('../../assets/backward.png')" alt="">
            </div>
            <div class="center" slot="center">注册</div>
            <div class="right" slot="right"></div>
        </my-header>
        <div class="main">
            <username-input></username-input>
            <verification-input></verification-input>
            <password-input my-placeholder='输入新密码'></password-input>            
            <submit-button>注册</submit-button>
      </div>  
  </div>
</template>

<script>
import MyHeader from '../base/my-header'
import UsernameInput from './username-input'
import PasswordInput from './password-input'
import SubmitButton from './submit-button'
import VerificationInput from './verification-input'
export default {
    components:{
        MyHeader,
        UsernameInput,
        PasswordInput,
        SubmitButton,
        VerificationInput
    },
    data(){
        return{

        }
    },
    methods:{
        /**@function 返回上一个页面 */
        goBack(){
            history.go(-1);
        },

    },
    created(){

    }
}
</script>

<style lang="scss" scoped>
    @function px2rem($px){
        $rem:37.5px;
        @return ($px / $rem) + rem; 
    }
    .header{
        border-bottom:1px solid #f7f8fb!important;
    }    
    .main{
        padding-left:px2rem(60px);
    }
    .user-input{
        margin-top:px2rem(122px);
    }
    .password-input{
        margin-top:px2rem(50px);
    }
    .submit-button{
        margin-top:px2rem(140px);
    }
    .verification-input{
        margin-top:px2rem(50px);
    }
</style>


