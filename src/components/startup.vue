<template>
    <div style="position:relative">
        <img class="startup" :src="require('../assets/startup.png')" alt="">
        <div class="count-down" @click="skip">{{countDown}}s&nbsp;跳过</div>
    </div>
</template>

<script>
export default {
    data(){
        return{
            countDown:3,//倒计时初始值3s
        }
    },
    methods:{
        /**@function 监听用户点击跳过事件 */
        skip(){
            this.$router.push('/login');
            clearInterval(this.timer)
        }
    },
    mounted(){
        /**@function 倒计时3秒跳转到登录页面*/
        this.timer = setInterval(()=>{
            this.countDown--;
            if(this.countDown == 0)
                clearInterval(this.timer)
                this.$router.push('/login');
        },1000)
    }
}
</script>

<style lang="scss" scoped>
    @function px2rem($px){
        $rem:37.5px;
        @return ($px / $rem) + rem; 
    }
    img.startup{
        width:px2rem(750px);
    }
    .count-down{
        position: absolute;
        right:px2rem(40px);
        top:px2rem(40px);
        padding:px2rem(10px) px2rem(40px);
        border-radius: px2rem(24px);
        background-color: rgba(0,0,0, 0.2);
        color:#fff;
        font-size:px2rem(24px);
        font-family: 'pingfang sc regular';
    }
</style>

