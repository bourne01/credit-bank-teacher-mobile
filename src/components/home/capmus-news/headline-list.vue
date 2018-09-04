<template>
  <div>
      <my-header>
            <div slot="left" class="left"></div>
            <div class="center" slot="center">校园头条</div>
            <div slot="right" class="right">
            </div>
        </my-header>
      <div class="content">
          <headline></headline> 
      </div>
  </div>
</template>

<script>
import Headline from './headline';
import MyHeader from '../../base/my-header'
export default {
    components:{
        MyHeader,
        Headline,
    },
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
</style>


