<template>
    <span @click="onClick" class="edit">
        {{editorName}}
    </span>
</template>

<script>
export default {
    data(){
        return{
            editorName:'编辑',
        }
    },
    methods:{
        /**@function 监听点击事件，且切换编辑状态
         * （如果当前是保存，则切换为编辑，反之亦然） */
        onClick(){
            if(this.editorName == '保存'){
                this.editorName = '编辑';
                this.$emit('edit','save');
            }else{
                this.editorName = '保存';
                this.$emit('edit','edit')
            }
        }
    }
}
</script>

<style lang="scss" scoped>
    @function px2rem($px){
            $rem:37.5px;
            @return ($px / $rem) + rem; 
        }
    .edit{
        font-size:px2rem(28px);
        color:rgb(92,157,255);
        font-family: 'PingFang-SC-Medium';
    }
</style>

