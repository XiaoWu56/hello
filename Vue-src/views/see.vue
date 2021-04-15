<template>
    <div class="btnboard" :style="{'background-image': 'url('+oneForm.coverImage.bg+')'}">
        <div class="nothingboard"></div>
        <div class="cBoard bgcolor0" :newCreateBoard="newCreateBoard"><!-- :newCreateBoard="newCreateBoard"-->
            <div class="top" >
                <img :src="oneForm.coverImage.url"/>
                <h2 v-if="isSubmit">{{oneForm.name}}</h2>
                <input v-if="false" type="text" v-model="oneForm.name" placeholder="请输入表单名" />
                <br/>
                <textarea v-if="false" type="text" v-model="oneForm.content" placeholder="可编辑提示语"></textarea>
            </div>
            <div class="ad" v-if="!isSubmit" >
                <h1>提交成功</h1>
            </div>
            <make-form-question v-for="(item ,index) in formQuestion" :key="index" :titleNum="index" :titleModel="item" :showNum="oneForm.showNum" :modelFaceNone="'modelFaceNone'"/>
            <div class="down" v-if="isSubmit">
                <button :style="{'background': oneForm.btnCss}" disabled>提交</button>
            </div>
        </div>
        <div class="nothingboard2" ></div>
    </div>
</template>

<script>
import MakeFormQuestion from '../components/form/create/common/MakeFormQuestion'
export default {
    name: 'CreateBoard',
    components: {
        MakeFormQuestion
    },
    data(){
        return{
            isSubmit: true,
            oneForm: {},
            formQuestion: {},
        }
    },
    methods: {
        newChange(){
            this.oneForm=this.$store.getters.getOneForm;
            this.formQuestion = this.$store.getters.getFormQuestiona;
        }
    },
    mounted(){
        this.oneForm=this.$store.getters.getOneForm;
        this.formQuestion = this.$store.getters.getFormQuestiona;
    },
    computed: {
        newCreateBoard(){
            this.newChange()
            // this.oneForm=this.$store.getters.getOneForm;
            // this.formQuestion = this.$store.getters.getFormQuestiona;    
        }
    }
}
</script>

<style scoped>
.btnboard{
    position: relative;
    background-color: rgb(255, 255, 255);
    background-repeat: repeat;
    background-size: cover;
    background-position: center top;
    /* background-image: url(https://gd-pub.jinshujufiles.com/bgi/20201126165919_a2f8db); */
}
.nothingboard{
    width:100%;
    height:5vh;
    display: block
}
.nothingboard2{
    width:100%;
    height: 50vh;
    display: block
}
.cBoard{
    width: 53vw;
    margin: 3vh auto;
    border-radius: 5px;
    background: #fff;
    /* 设置padding-bottom 让添加题目时不用改Board的长度*/
    padding-bottom: 3vw;
    overflow: hidden;
}
.cBoard .ad{
    width: 100%;
    height: 40vh;
    margin-top: 4vh;
    
}
.cBoard .ad p{
    margin: auto;
    text-align: center;
    
}
.cBoard .top h2{
    width: calc(50vw - 2vw);
    height: 4vh;
    display: block;
    margin: auto;
}
.cBoard .top img{
    width: 100%;
    height: 7vmin;
    /* 代码写法：有图时与没图时写法,vmin,vmax */
    height: 15vmax;
    background: rgb(112, 108, 104);
}
.cBoard .top input,textarea{
    width: calc(50vw - 2vw);
    height: 4vh;
    display: block;
    margin: auto;

}
.cBoard .top textarea{
    height: 8vh;
}
.cBoard .down button{
    /* 代码写法：可以给calc的计算结果加vmin单位 */
    width: 20vmin;
    /* calc((100% / 4)vmin); */
    height: 5vmin;
    margin: 0 auto; 
    display: block;

    font-size: 1.2vw;
    background: #5946E4;
    border: none;
    border-radius: 3px;
    /* letter-spacing: 1vw; */
    text-align: center;
    
}
.createad {
    width: calc(100% - 10%);
    height: 9vh;
    margin: 2vh auto;
    border-radius: 5px;
    background: gainsboro;
}
.createad p{
    display: inline-block;
    margin-left: calc(50% - 10%);
    margin-top: 2%;
    color: rgb(197, 195, 195);
    
}
.createad button{
    width: 6vw;
    height: 5vh;
    margin-right: 5%;
    margin-top: 2%;
    border-radius: 5vw;
    background: rgb(204, 194, 194);
    color: rgb(241, 238, 238);
    float: right;
}
.twobtn{
    width: 4.5vw;
    height: 20vh; 
    position: absolute;
    top: 6vh;
    right: 0;
}
.twobtn button{
    width: 100%;
    height: calc(100% / 2 - 5%);
    margin-bottom: 20%; 

    border-radius: 3px;
    color: #333;
    background: #fff;
    box-shadow: 0 1px 2px rgba(0,0,0,.3);
    cursor: pointer;
    opacity: .7;
}
.twobtn button span:hover{
    color: #333;
    font-weight: 900;
}

.cBoard .boardli{
    margin: 10px auto;
    width:48vw;
    height: 150px;
    border:3px dashed darkorange;
}
</style>