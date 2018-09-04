<template>
  <div class="verification-input">
      <input type="text" name="verification-code" class="verification-code" placeholder="验证码">
      <img :src="require('../../assets/envelope.png')" alt="" class="envelope">
      <div class="confirm-code">获取验证码</div>
  </div>
</template>

<script>
export default {
    data(){
        return{

        }
    },
    methods:{

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
    .verification-code{
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
    .verification-input{
        position: relative;
    }
    .envelope{
        width:px2rem(50px);
        position: absolute;
        left:px2rem(30px);
        top:px2rem(19px)
    }
    .confirm-code{
        width:px2rem(200px);
        height:px2rem(88px);
        background-color:rgb(163,170,185);
        color:#fff;
        position: absolute;
        top:0;
        right:px2rem(60px);
        height: px2rem(88px);
        line-height: px2rem(88px);
        border-top-right-radius: px2rem(40px);
        border-bottom-right-radius: px2rem(40px);
        font-size:px2rem(28px);
        text-align:center;
    }
</style>


