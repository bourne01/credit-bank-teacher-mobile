<template>
  <div class="news-detail">
      <header>温州市教育局领导视察调研我校</header>
      <div class="content"></div>
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
    header{
        height:px2rem(100px);
        line-height: px2rem(100px);
        border-bottom:1px solid #f7f8fb!important;
        text-align:center;
        font-size:px2rem(36px);
        color:rgb(28,38,57);
        font-family: 'FingFang-SC-Heavy';
    }
</style>


