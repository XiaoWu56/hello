<template>
    <div class="">
        <div class="createType divfloat">
            <create-type />
        </div>
        <div class="createBoard divfloat">
            <create-board />
        </div>
        <div class="createSet divfloat">
            <div class="top">
                <!-- 代码写法：@click两个方法时，用分号;分隔，并且两个方法名都加括号才能执行。一个方法时括号可加或不加 -->
                <button :class="['btn1', btnclick1]" @click="btnchange1();"><i class="el-icon-discount"></i>编辑题目</button><!--togo('/form');-->
                <button :class="['btn2', btnclick2]" @click="btnchange2();" ><i class="el-icon-place"></i>问卷样式</button><!--togo('/form/formChange')-->
            </div>
            <div class="middle">
                <div class="setInfo">
                    <question-change v-if="btnvalue1"/>
                    <form-change v-if="btnvalue2"/>
                    <!-- <router-view></router-view> -->
                </div>
            </div>
            <div class="down">
                <button  @click="addForm">保存问卷</button>
            </div>
        </div>
        
    </div>
</template>

<script>
import CreateType from '@/components/form/create/CreateType'
import CreateBoard from '@/components/form/create/CreateBoard'
import QuestionChange from '../../components/form/create/common/QuestionChange.vue'
import FormChange from '../../components/form/create/common/FormChange.vue'

// import aaa from '@/components/formCreate/thing/BoardShowDialog.vue'
export default {
    inject: ['reload'],
    name: 'formCreate',
    components: {
        CreateType,
        CreateBoard,
        QuestionChange,
        FormChange,

        // ,aaa
    },
    data(){
        return{
            btnclick1: "beclick",
            btnclick2: "",
            btnvalue1: true,
            btnvalue2: false,

            sendVal: false,
            typeId : "",    //来自type板块
            typeModel: {},   //来自change板块

            realForm: {},
            realDetail: [],
        }
    },
    methods: {
        successNotice(mess) {
        this.$message({
            message: mess,
            type: 'success',
            center: true,
            duration: 1000
            });
        },
        addForm(){
            this.realForm = this.$store.getters.getOneForm;
            this.realDetail = this.$store.getters.getFormQuestiona;
            this.$qApi.getAddForm({
                    tUser_id: this.realForm.tUser_id, 
                    name: this.realForm.name, 
                    coverImage: JSON.stringify(this.realForm.coverImage), 
                    content: this.realForm.content, 
                    btnCss: this.realForm.btnCss, 
                    icon: JSON.stringify(this.realDetail)
            }) 
            .then(successResponse =>{ 
                    this.successNotice("添加问卷成功") 
                    this.togo('/form'+'?id='+successResponse.data)
                    this.reload()
            }) 
        },
        togo(path){
            this.$router.push(path)
        },
        btnchange1(){
            //注意事项：因不传值判断按哪个键，使用两个按钮方法分开写
            this.btnclick1 = "beclick";
            this.btnclick2 = "";
            this.btnvalue1 = true;
            this.btnvalue2 = false;
        },
        btnchange2(){
            this.btnclick1 = "";
            this.btnclick2 = "beclick";
            this.btnvalue1 = false;
            this.btnvalue2 = true;
        },
        openMask(){
            this.sendVal = true;
            console.log(this.CreateBoard)
        },
        getChildType(a){//从CreateType子组建获得题目id
            this.typeId = a;
        },
        typeIdMakeNull(a){
            this.typeId = a;
            console.log(this.typeId);
            console.log("++++++++++++")
        },
        boardToChange(a){
            this.typeModel = a;
        },
        formChangeBoardShow(a){////从QuestionChange子组建获得题目id
            this.typeModel = a;
        }
    }
}
</script>

<style>
body, ul, p, h5, h6{
    margin: 0;
    padding: 0;
}
ul{
    list-style: none;
}

.divfloat{
    float: left;
}
.createType, .createSet{
    width: 21vw;
    height: calc(100vh - 10vh);
}
.createBoard{
    width: 58vw;
    height: calc(100vh - 10vh);
}
.createType, .createBoard{
    /* 注意事项：auto错误，滚动条作用对象为body */
    overflow-y: scroll; 
}
.createSet .top,.middle{
    width: 100%;
}
.createSet .top{
    height: 5.8vh;
    border-bottom: 0.2vh solid rgb(235, 235, 235); 
    position: relative;
}
.createSet .middle{
    height: calc(100% - 6vh - 10vh);
    overflow-y: scroll;
}
.createSet .down{
    width: calc(100% - 2px);
    height: calc(10vh - 2px);
    background: #fff;
    border: 1px solid #ebebeb;
}
.createSet .setInfo{
    width: calc(100% - 1.5vw);
    height: 100%;
    margin: auto;
}
.createSet .top button{
    /* display: inline-block; */
    width: calc(100% / 2 - (1% * 4));
    height: 80%;
    margin: 0 2%;
    background: rgb(235, 235, 235);
    border-radius: 3px;
    border: 0.2vh solid rgb(235, 235, 235);
    border-bottom: none;
    outline: none;
    position: absolute;
    bottom: -0.3vh; 
}
.createSet .top .btn1{
    left: 0;
}
.createSet .top .btn2{
    right: 0;
}
.createSet .top button:hover{
    color: rgb(41, 113, 223);
}
.createSet .top .beclick{
    color: rgb(41, 113, 223);
    background: #fff;
}
.createSet .down button{
    display: inline-block;
    width: 90%;
    height: 60%;
    margin: 2vh 1vw;
    background: rgb(41, 113, 223);
    border: none;
    border-radius: 5px;
    color: #fff;
    /* 代码写法：可设置字与字的间隔 */
    /* letter-spacing: 45px; */
}
</style>