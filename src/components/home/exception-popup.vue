<template>
    <div class="exception" @click="onClick">
        网络异常，点击重试。
    </div>
</template>

<script>
export default {
    data(){
        return{

        }
    },
    methods:{
        /**监听点击异常事件 */
        onClick(){
            this.$emit('exception');
        }
    }
}
</script>

<style lang="scss" scoped>
    @function px2rem($px){
        $rem:37.5px;
        @return ($px / $rem) + rem; 
    }
    .exception{
        position: absolute;
        top:0;
        left:0;
        background-color:#f8f8f8;
        text-align: center;
        height:px2rem(302px);
        line-height: px2rem(302px);
        width:100%;
        color:#e1e1e1
    }
</style>

