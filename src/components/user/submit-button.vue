<template>
  <div class="submit-button" :class="{'active':isClicked}" @click="onClick">
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
        onClick(){
            this.isClicked = true;
            this.$emit('submit')
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
    .submit-button{
        border-radius: px2rem(40px);
        height: px2rem(88px);
        line-height: px2rem(88px);
        background-color:rgb(92,157,255);
        font-size:px2rem(36px);
        width:px2rem(628px);
        text-align: center;
        color:#fff;     
    }
    .active{
        border: 1px solid #deb163;
        height: px2rem(84px);
        line-height: px2rem(84px);
         width:px2rem(624px);
    }     
</style>


