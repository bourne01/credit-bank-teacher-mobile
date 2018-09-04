<template>
  <div class="register-button" :class="{'active':isClicked}" @click="onClick">
      <slot></slot>
  </div>
</template>

<script>
export default {
    data(){
        return{
            isClicked:false,
        }
    },
    methods:{
        /**@function 监听点击事件 跳转到注册页面 */
        onClick(){
            this.isClicked = !this.isClicked;
            this.$router.push('/register');
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
    .register-button{
        border-radius: px2rem(40px);
        height: px2rem(84px);
        line-height: px2rem(84px);
        border: 1px solid rgb(92,157,255);
        font-size:px2rem(36px);
        width:px2rem(624px);
        text-align: center;
        color:rgb(92,157,255);
        background-color:#fff;
        font-family: 'HiraginoSansGB-W3';  
    }
    .active{
        border: 1px solid rgb(92,92,92);
    }    
</style>


