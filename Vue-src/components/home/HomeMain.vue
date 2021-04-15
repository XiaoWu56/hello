<template>
    <div id="" class="homeMain cleanboth">
        <!-- <div class="head">
            <main-head />
        </div>
        <div class="main">
            <router-view></router-view>
        </div> -->
        <!-- 创建文件夹弹窗 -->
        <!-- <set-folder-dialog />
        <set-form-dialog /> -->
    </div>
</template> 

<script>
import SetFolderDialog from './common/SetFolderDialog'
import SetFormDialog from './common/SetFormDialog'
import MainHead from './main/mainHead.vue'
export default {
    name: 'HomeMain',
    components: {
        SetFolderDialog,
        SetFormDialog,
        MainHead
    },
    data(){
        return{
        }
    },
    methods: {
    } 
}
</script>

<style scoped>
/* .cleanboth{clear: both;}
.homeMain {
    width: 100%;
    height: 100%;
}
.homeMain .head{
    width: 100%;
    height: 6vh;
    line-height: 6vh;
    border-bottom: 1px solid lightgray;
}
.homeMain .main{
    width: 100%;
    height: calc(100% - 6vh - 3vh);
    margin-top: 3vh;
} */
</style>