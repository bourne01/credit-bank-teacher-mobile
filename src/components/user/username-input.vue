<template>
  <div class="user-input">
      <input type="text" name="username" v-model="username" class="username" placeholder="手机号 / 用户名 / 邮箱">
      <img :src="require('../../assets/login.png')" alt="" class="login">
  </div>
</template>

<script>
export default {
    data(){
        return{
            username:'',
        }
    },
    methods:{

    },
    watch:{
        username:function(){
            this.$emit('username',this.username);
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
    .username{
        border-radius: px2rem(40px);
        height: px2rem(88px);
        line-height: px2rem(88px);
        background-color:#f7f8fb;
        font-size:px2rem(28px);
        border:none;
        width:px2rem(518px);
        padding-left:px2rem(110px);
        outline:none;
    }
    .user-input{
        position: relative;
    }
    .login{
        width:px2rem(50px);
        position: absolute;
        left:px2rem(30px);
        top:px2rem(19px)
    }
</style>


