<template>
    <div class="course" @click="goTo">
        <div class="left">
            <div class="class-name">
                {{course.claName?course.claName:course.outClaNm}}
            </div>
            <div class="course-name">{{course.couName}}</div>
        </div>
        <div class="right"><img :src="require('../../assets/forward.png')" alt=""></div>
    </div>
</template>

<script>
export default {
    props:['course'],
    data(){
        return{

        }
    },
    methods:{
        /**@function 根据课程Id跳转到课程详情页面 */
        goTo(){
            this.$router.push('/record-score');
        }
    },
    watch:{
        course:{
            handler:function(){
                console.log('ddd')
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
    .course{
        display:flex;
        justify-content: space-between;
    }
    .class-name{
        font-size:px2rem(24px);
        color:rgb(28,38,57);
        font-family: 'PingFang-SC-Medium';
    }
    .class-name span{
        display:inline-block;
        width:4em;
    }
    .course-name{
        text-indent:4em;
        font-size:px2rem(28px);
        color:rgb(163,170,185);
        font-family: 'PingFang-SC-Medium';
    }
    .right img{
        width:px2rem(80px);
    }
</style>


