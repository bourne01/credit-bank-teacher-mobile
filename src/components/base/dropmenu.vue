<template>
    <div @click="isShow = !isShow" class="drop-menu">
        <img :src="require('../../assets/dropdown.png')" alt="">
        <ul v-show="isShow">
            <li 
                v-for="(term,index) in terms" 
                :key="index"><span @click="onClick(term.autoId,term)">{{term.name}}</span>
                <i></i>
                </li>
        </ul>
    </div>
</template>

<script>
export default {
    props:['terms'],
    data(){
        return{
            isShow:false,
        }
    },
    methods:{
        /**@function 展现下拉列表*/
        showList(){
            this.isShow = !this.isShow;
        },
        /**@function 从点击下拉的学期列表中，获取当前学期 */
        onClick(termId,term){
            this.$emit('term',term)
        }
    },
}
</script>

<style lang="scss" scoped>
    @function px2rem($px){
            $rem:37.5px;
            @return ($px / $rem) + rem; 
        }
    .drop-menu{
    }
    img{
        vertical-align: middle;
        width:px2rem(70px);
        cursor: pointer;
    }
    .drop-menu ul{
        position: absolute;
        top:px2rem(100px);
        left:0;
        margin:0;
        padding:0;
        list-style-type: none;
    }
    .drop-menu li{
        height:2.0em;
        line-height:2.0em;
        width:px2rem(500px);
        text-align: center;
    }
    .drop-menu span{
        display:inline-block;
        border-bottom:1px solid #ccc;
        background-color: aliceblue;
        color: #353535;
    }
    .drop-menu span:hover{
        background-color:mintcream;
    }
    .drop-menu li i{
        display:inline-block;
        width:px2rem(64px);
    }
</style>

