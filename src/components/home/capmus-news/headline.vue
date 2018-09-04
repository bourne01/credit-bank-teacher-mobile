<template>
  <div>
        <div class="header">
            <div class="campus-headline-text">校园头条</div>
            <div class="view-more">查看更多
                <img :src="require('../../../assets/forward.png')" alt="">
            </div>
        </div>
        <div class="news-content">
            <ul>
                <li>
                    <router-link to='/news-detail' class="news-item">
                        <span>职专师生受邀助力市职职专师生受邀助力市职职专师生受邀助力市职</span>
                        <img :src="require('../../../assets/news-pic.png')" alt="">
                    </router-link>
                </li>
                <li>
                    <router-link to='/news-detail' class="news-item">
                        <span>职专师生受邀助力市职职专师生受邀助力市职职专师生受邀助力市职</span>
                        <img :src="require('../../../assets/news-pic.png')" alt="">
                    </router-link>
                </li>
                <li>
                    <router-link to='/news-detail' class="news-item">
                        <span>职专师生受邀助力市职职专师生受邀助力市职职专师生受邀助力市职</span>
                        <img :src="require('../../../assets/news-pic.png')" alt="">
                    </router-link>
                </li>
                <li>
                    <router-link to='/news-detail' class="news-item">
                        <span>职专师生受邀助力市职职专师生受邀助力市职职专师生受邀助力市职</span>
                        <img :src="require('../../../assets/news-pic.png')" alt="">
                    </router-link>
                </li>
            </ul>
        </div>
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
    .campus-headline-text{
        font-family: 'PingFang-SC-Heavy';
        font-size:px2rem(28px);
        color:rgb(28,38,57);
    }
    .header{
        display:flex;
        justify-content: space-between;
    }
    .view-more{
        font-family: 'PingFang-SC-Medium';
        font-size:px2rem(24px);
        color:rgb(155,158,163);
    }
    .header img{
        width:px2rem(40px);
        vertical-align: px2rem(-10px);
        
    }
    .news-content li{
        height:px2rem(132px);
        //line-height:px2rem(158px);
        list-style-type: none;
    }
    .news-content li:first-child{

        margin-top:px2rem(22px);
    }
    .news-item{
        display:flex;
        justify-content: space-between;
        font-size:px2rem(24px);
    }
    .news-item span{
        width:px2rem(500px);
        //white-space: nowrap;
        align-self:center;
    }
    .news-item img{
        width:px2rem(112px);
        height:px2rem(112px);
        vertical-align: middle
    }
</style>


