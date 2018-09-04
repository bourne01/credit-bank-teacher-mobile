<template>
  <div>
        <my-header>
            <div slot="left" class="left">
                <div class="left" slot="left" @click="goBack">
                <img :src="require('../../assets/backward.png')" alt="">
            </div>
            </div>
            <div class="center" slot="center">课堂考勤</div>
            <div slot="right" class="right">
            </div>
        </my-header>
        <div class="main">
            <class-info :class-info="classInfo"></class-info>
            <!-- <student-attendance :class-info="classInfo"></student-attendance> -->
        </div>
        
  </div>
</template>

<script>
import MyHeader from '../base/my-header'
import ClassInfo from './class-info'
import StudentAttendance from './student-att'
export default {
    components:{
        MyHeader,
        ClassInfo,
        StudentAttendance,
    },
    data(){
        return{
            classInfo:null,
        }
    },
    methods:{
        goBack(){
            history.go(-1);
        }
    },   
    created(){
        this.classInfo = this.$route.query;
        //console.log('this.classInfo');
    }
}
</script>

<style lang="scss" scoped>
    @function px2rem($px){
        $rem:37.5px;
        @return ($px / $rem) + rem; 
    }
    .main{
        padding:0 px2rem(40px);
    }
</style>


