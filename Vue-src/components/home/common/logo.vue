<template>
    <div class="logo" @click="togo('/')">
        <img class="floatleft" :src="backImg"/>
        <p class="floatleft">*数据</p>
        <div class="face"></div>
    </div>
</template>

<script>
import backImg from "../../../assets/a7.jpg";
export default {
    name: 'logo',
    data(){
        return{
            backImg: backImg
        }
    },
    methods: {
        togo(path){
            // 没返回上一步的操作 this.$router.replace(path)
            this.$router.push(path)
        }
    }
}
</script>

<style>
.floatleft{
    float: left;
}
.logo{
    width: 100%;
    height: 100%;
    position: relative;
}
.logo img{
    width: 35%;;
    height: 90%;
}
.logo p{
    font-family: "宋体";
    font-size: 1.6vw;
    line-height: 8vh;
    overflow: hidden;
    text-overflow:ellipsis;
}
.logo .face{
    width: 100%;
    height: 100%;
    position: absolute;
    top: 0;
    left: 0;
    cursor: pointer;
}
</style>