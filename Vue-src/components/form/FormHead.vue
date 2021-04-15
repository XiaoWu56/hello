<template>
    <div class="formHead">
        <div class="left divfloat">
            <button class=""  @click="togo('/data')"><span><i class="el-icon-arrow-left"></i></span>返回</button>
        </div>
        <div class="center divfloat">
            <!-- 注意事项：用变量改class时，变量代表的css要具体到属于哪个div，因div中有button的设置，关于样式的优先级 -->
            <button :class="[moduleClick1]"  @click="isClick1(); togo('/form')">编辑问卷</button>
            <button :class="[moduleClick2]"  @click="isClick2(); togo('/form/set')">问卷设置</button> 
            <button :class="[moduleClick3]"  @click="isClick3(); togo('/form/send')">发布问卷</button>
        </div>
        <div class="right">
            <button>在线客服 |</button>
            <button class="" @click="showBoard" >预览问卷</button>
            <button class="btnData"  @click="togo('/data')">数据统计</button>
        </div>
    </div>
</template>

<script>
export default {
    name: 'FormHead',
    components: {    
    },
    data(){
        return{
            moduleClick1: "moduleIsClick",
            moduleClick2: "",
            moduleClick3: "",
        }
    },
    methods:{
        btncssclear(){
            this.moduleClick1 = "";
            this.moduleClick2 = "";
            this.moduleClick3 = "";
        },
        isClick1(){
            this.btncssclear();
            this.moduleClick1 = "moduleIsClick";
        },
        isClick2(){
            this.btncssclear();
            this.moduleClick2 = "moduleIsClick";
        },
        isClick3(){
            this.btncssclear();
            this.moduleClick3 = "moduleIsClick";
        },
        togo(path){
            // alert(this.$route.query.id)
            this.$router.push(path+'?id='+this.$route.query.id)
        },
        showBoard(){
            this.$store.commit('changeShowMask1')
        }
    },
    
}
</script>

<style scoped>
.formHead{
    width: 95%;
    height: 100%;
    margin : 0 auto;
    
}
.formHead button{
    border: none;
    background: none;
    color: #fff;
}
.formHead .left{
    width: 37%;
}
.formHead .right{
    width: 21%;
}
.formHead .center{
    width: 26%;
}
.formHead .left,.center,.right{
    height: 60%;
    margin-top: 3vh;
}
.formHead .left button{
    width: 17%;
    display: inline-block;
}
formHead .left button span:hover{
    color: rgb(189, 187, 187);
}
.formHead .left button span:hover{
    color: #fff;
}
.formHead .center button,.right .btnData{
    width: calc(100% / 3 - (1% * 6));
    height: 100%;
    margin: 0 3%;
    border-radius: 5vw;
    color: #fff;
    /* display: inline-block; */
}
.formHead .center button:hover{/*:hover */
    background: gainsboro;
}
.formHead .center .moduleIsClick{
    background: rgb(0, 153, 255);
}
.formHead .center .moduleIsClick:hover{
    background: rgb(0, 153, 255);
}
.formHead .right .btnData{
    background: rgb(0, 153, 255);
    width: calc(100% / 3);
}
.formHead .right {
    float: right;
}
.formHead .right .btnData:hover{
    background: rgb(41, 110, 213);
    color: rgb(234, 234, 234);
}
</style>