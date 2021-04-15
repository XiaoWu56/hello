<template>
    <div class="">
        <div class="topMain color3">
            <div class="left floatleft">
                <div id="" class="homeNav">
                    <button class="btnCreate" @click="togo('/form')">+创建</button>
                    <h3>导航</h3>
                    <ul class="listnav">
                        <li v-for="(item, index) in navList" :key="index" @click="togo(item.toRouter), toClick(index)"><!--togo(item.toRouter),-->
                            <i :class="[item.icon]"></i>{{item.text}}
                        </li>
                    </ul>
                </div>
            </div>
            <div class="right floatright homeMain cleanboth">
                <div class="head">
                    <main-head :info="navList[navClick].text"/>
                </div>
                <div class="main">
                    <router-view ></router-view>
                </div>
                <!-- 创建文件夹弹窗 -->
                <set-folder-dialog />
                <set-form-dialog />
            </div>
        </div>
    </div>
</template>

<script>
import HomeNav from '@/components/home/HomeNav'
import HomeMain from '@/components/home/HomeMain'
import MainHead from './main/mainHead.vue'
import SetFolderDialog from './common/SetFolderDialog'
import SetFormDialog from './common/SetFormDialog'
export default{
    name: 'home',
    components:{
        HomeNav, 
        HomeMain,
        MainHead,
        SetFolderDialog,
        SetFormDialog
    },
    data(){
        return{
            navClick: 0,
            navList:[
                {
                    toRouter: '/',
                    icon: "el-icon-setting",
                    text: "我的表单",
                    toMethod: ""
                },
                {
                    toRouter: '/',
                    icon: "el-icon-setting",
                    text: "与我共享"
                },
                {
                    toRouter: '/MainLike',
                    icon: "el-icon-setting",
                    text: "我的收藏"
                },
                {
                    toRouter: '/',
                    icon: "el-icon-setting",
                    text: "我为别人填的表单"
                },
                {
                    toRouter: '/',
                    icon: "el-icon-setting",
                    text: "到期受影响的表单"
                },
                {
                    toRouter: '/mainDel',
                    icon: "el-icon-setting",
                    text: "回收站"
                }
            ],
            formList: []
        }
    },
    methods: {
        togo(path){
            this.$router.push(path)
        },
        toClick(num){
            this.navClick = num
            this.getFormList(num)
        },
        getFormList(num){
            switch(num){
                case 0:
                    this.$qApi.getSelectForms({ userId: 20}) 
                    .then(successResponse =>{ 
                        this.formList = successResponse.data;
                    })
                    break;
                case 2:
                    this.$qApi.getSelectFormsByCondition({
                        userId: 20,
                        condition: 'isLike'
                    }) 
                    .then(successResponse =>{ 
                        this.formList = successResponse.data;
                    })
                    break;
                case 5:
                    this.$qApi.getSelectFormsByCondition({
                        userId: 20,
                        condition: 'isDelete'
                    }) 
                    .then(successResponse =>{
                        this.formList = successResponse.data;
                    })
                    break;
                default:
                    this.$qApi.getSelectForms({ userId: 20}) 
                    .then(successResponse =>{ 
                        this.formList = successResponse.data;
                    })
                    break;
            }
        }

    },
    mounted(){
        this.getFormList(this.navClick)
    }
}
</script>


<style>
.topMain .left{
    width: calc(100% / 10 * 1.7);
    height: 100%;
}
.topMain .right{
    width: calc(100% / 10 * 8);
    height: 100%;
}
/* nav */
.homeNav{
    width: 100%;
    height: 100%;
    
}
.homeNav .btnCreate,h3,li,a{
    color: #000;
    font-size: 1.2vw;
    overflow: hidden;
}
.homeNav .btnCreate{
    width: 100%;
    height: 6vh;
    text-align: center;
    line-height: 6vh;
    border-radius: 2px;
    background: #2875e8;
    color: #fff;
    border: none;
}
.homeNav h3{
    font-weight: lighter;
    text-align: left;
    color: #666;
}
.listnav li{
    width: 100%;
    height: 6vh;
    color: #666;
}
.listnav li a{
    text-decoration: none;
}
.listnav li:hover{
    color: #2875e8;
}
.listnav li a:hover{
    color: #2875e8;
}

/* mainHead */
.homeMain .head{
    width: 100%;
    height: 6vh;
    line-height: 6vh;
    border-bottom: 1px solid lightgray;
}
.homeMain .head img{
    width: 5vh;
    height: 5vh;
}
.homeMain .head button{
    width: 19vh;
    height: 5vh;
}
.head li{
    float: left;
    height: 40px;
    /* width: 30px;
    text-align: center;
    line-height: 40px; */
}
.head li button{
   border: none;
   background: none;
   padding: 0;
   width: 10px;
   height: 10px;
}
</style>