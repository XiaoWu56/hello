<template>
    <div class="home">
        <div class="homeTop">
            <div class="top">
                <home-head />
            </div>
        </div>
        <div class="homeDown">
            <div class="down">
                <home-down />
            </div>
        </div>
        <div class="topMain color3">
            <div class="left floatleft">
                <home-nav />
            </div>
            <div class="right floatright">
                <home-main />
            </div>
        </div>
    </div>
</template>

<script>
import HomeHead from '@/components/home/HomeHead'
import HomeDown from '@/components/home/HomeDown'

import HomeNav from '@/components/home/HomeNav'
import HomeMain from '@/components/home/HomeMain'

export default{
    name: 'home',
    components:{
        HomeHead,
        HomeDown,
        HomeNav, 
        HomeMain
    },
    methods: {
        toLogin(){
            //方法作用：对登录成功的查证
            // this.$router.push("/login");
        }
    },
    mounted(){
        this.toLogin()
    }
}
</script>


<style>
.floatleft{ float:left;}
.floatright{ float:right;}
.color1{ background:rgb(198, 236, 29);}
.color2{ background:darkorange;}
.color3{ background:rgb(244, 244, 244);}
.home{
    background:rgb(244, 244, 244);
}
.homeTop{
    width: 100%;
    height: 8vh;
    background:#fff;
    box-shadow: 0 1px 2px 0 rgba(0,0,0,0.1);
}
.homeTop .top{
    width: 72vw;
    height: 100%;
    margin: auto; 
}
.homeDown{
    margin: auto;
    margin-top: 5vh;
    width: 72vw;
    height: calc(100vh - 8vh);

    background: darkblue;
}
.topMain{
    margin: auto;
    margin-top: 5vh;
    width: 72vw;
    height: calc(100vh - 8vh);
}
.topMain .left{
    width: calc(100% / 10 * 1.7);
    height: 100%;
}
.topMain .right{
    width: calc(100% / 10 * 8);
    height: 100%;
}
</style>