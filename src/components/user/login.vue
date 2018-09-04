<template>
  <div>
      <my-header class="header">
          <div class="left" slot="left" @click="goBack()">
              <img :src="require('../../assets/backward.png')" alt="">
          </div>
          <div class="center" slot="center">登录</div>
          <div class="right" slot="right"></div>
      </my-header>
      <div class="main">
            <username-input @username="getUsername"></username-input>
            <password-input @password="getPassword"></password-input>
            <submit-button @submit="submit">登录</submit-button>
      </div>
      
  </div>
</template>

<script>
import MyHeader from '../base/my-header'
import UsernameInput from './username-input'
import PasswordInput from './password-input'
import SubmitButton from './submit-button'
//import RegisterButton from './register-button'
export default {
    components:{
        MyHeader,
        UsernameInput,
        PasswordInput,
        SubmitButton,
        //RegisterButton
    },
    data(){
        return{
            username:'',
            password:'',
        }
    },
    methods:{
        /**@function 返回上一个页面 */
        goBack(){
            history.go(-1);
        },
        /**@function 从子组件中获取用户名 */
        getUsername(username){
            this.username = username;
        },
        /**@function 从子组件中获取用户密码 */
        getPassword(password){
            this.password = password;
        },
        /**@function 向服务器提交用户名和密码进行登录验证 */
        submit(){
            this.$http.defaults.withCredentials=true;
            this.$http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
            let url = 'api/public/thr!login.action';
            let params = {account:this.username,password:this.password};
            this.$http.post(
                    url,
                    require('qs').stringify(params),)
                .then( res => {
                    if(res.data.success){
                        let username = res.data.message;
                        sessionStorage.setItem('IsFromLogin','True');
                        this.$router.push('/home/');
                    }else if(res.data.message.indexOf('账号不能为空') != -1){
                            this.$msgbox('登录失败','账号不能为空',2000)
                    }else if(res.data.message.indexOf('账号或密码错误') != -1){
                            this.$msgbox('登录失败','账号或密码错误',2000)
                    }
                })
                .catch(err => {
                    console.log(err);
                    if(err.response){
                        let errResStatus = err.response.status;
                        if(errResStatus == 500){
                        this.$msgbox('网络异常','请稍后重试！','',2000);
                        }else if(errResStatus == 404){
                            this.$router.push('/page-not/found');
                        }else if(errResStatus == 401){
                            this.$msgbox('未授权登录');
                            this.$router.push('/login')
                        }
                    }
                })
        }
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
        margin-top:px2rem(58px);
    }
    .submit-button{
        margin-top:px2rem(160px);
    }
    .register-button{
        margin-top:px2rem(100px);
    }
</style>


