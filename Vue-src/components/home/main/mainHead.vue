<template>
    <div id="" class="">
        <div class="head">
            <span>{{info}}</span>
            <ul class="floatright">
                <li>
                    <button @click="openMask">创建文件夹</button>
                </li>
                <li>| 
                    <el-tooltip class="item" effect="dark" content="排序规则" placement="bottom">
                        <span class="el-icon-finished"></span>
                    </el-tooltip>
                </li> 
                <li>| 
                    <el-tooltip class="item" effect="dark" content="切换视图" placement="bottom">
                        <span class="el-icon-menu"></span>
                    </el-tooltip>
                </li>
            </ul>
        </div>
    </div>
</template> 

<script>
export default {
    name: 'mainHead',
    components: {
    },
    props: {
        info: {
            default: "我的表单"
        }
    },
    methods: {
        openMask(){
            this.$store.commit('changeShowMask')
        },
    } 
}
</script>

<style scoped>
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