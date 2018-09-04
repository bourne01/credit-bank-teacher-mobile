<template>
  <div class="me">
        <div class="close" @click="onClick">
            <img :src="require('../../assets/close.png')" alt="">
        </div>
        <div class="header">
            <img :src="require('../../assets/avatar.png')" alt="" class="avatar">
            <span>{{me.name}}</span>
            <img 
                :src="me.sex=='女'?require('../../assets/female.png'):require('../../assets/male.png')" 
                alt="" class="gender">
        </div>
        <div class="isolation-strip"></div>
        <div class="basic-info">
            <div class="name">
                <label>姓名</label>
                <span>{{me.name}}</span>
            </div>
            <div class="gender-txt">
                <label>性别</label>
                <span>{{me.sex}}</span>
            </div>
            <div class="mobile">
                <label>手机</label>
                <span>{{me.mobile}}</span>
            </div>
            <div class="birth-place">
                <label>籍贯</label>
                <span>{{me.origin}}</span>
            </div>
            <div class="join-date">
                <label>入职日期</label>
                <span>{{me.joinDate}}</span>
            </div>          
        </div>
        <div class="isolation-strip"></div>
        <div class="other-info">
            <div class="id">
                <label>身份证号</label>
                <span>{{me.iDcard}}</span>
            </div> 
            <div class="address">
                <label>家庭住址</label>
                <span>{{me.address}}</span>
            </div> 
        </div>
    </div>
</template>

<script>
export default {
    props:['me'],
    data(){
        return{
        }
    },
    methods:{
        /**@function 监听关闭按钮事件，然后向父组件传递关闭信息 */
        onClick(){
            this.$emit('close');
        },        
    },
    created(){
        //this.getMyInfo();
    }
}
</script>

<style lang="scss" scoped>
    @function px2rem($px){
        $rem:37.5px;
        @return ($px / $rem) + rem; 
    }
    .me{
        position: fixed;
        right:0;
        top:0;
        width:80%;
        height:100%;
        background-color:#fff;
        z-index: 2;
    }
    .close{        
        text-align:right;
    }
    .close img{
        width:px2rem(70px);
        margin-right:px2rem(28px);
    }
    .header{
        margin-left:px2rem(42px);
        margin-bottom:px2rem(78px);
    }
    .header img{
        vertical-align: middle;
    }
    .avatar{
        width:px2rem(112px);
        margin-right:px2rem(38px);
    }
    .gender{
        width:px2rem(30px);
    }
    .isolation-strip{
        height:px2rem(20px);
        background-color:#f2f3f9;
    }
    label{
        width:px2rem(112px);
        font-size:px2rem(28px);
        font-family: 'PingFang-SC-Medium';
        color:rgb(163,170,185);
        display:inline-block;
        text-align: justify;
        text-align-last: justify;
        margin-right:px2rem(40px);
    }
    .basic-info,.other-info{
        margin-left:px2rem(42px);
        margin-top:px2rem(60px);
        margin-bottom:px2rem(60px);
        font-size:px2rem(28px);
        font-family: 'PingFang-SC-Medium';
        color:rgb(28,38,57);
    }
    .name,.gender-txt,.mobile,.birth-place,.id{
        margin-bottom:px2rem(50px);
    }    
</style>


