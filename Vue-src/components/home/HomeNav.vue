<template>
    <div id="" class="homeNav">
        <!-- <button class="btnCreate" @click="togo('/form')">+创建</button>
        <h3>导航</h3>
        <ul class="listnav">
            <li @click="togo('/')">
                <i class="el-icon-setting"></i>我的表单
            </li>
            <li>
                <i class="el-icon-setting"></i>与我共享
            </li>
            <li @click="togo('/mainLike')">
                <i class="el-icon-setting"></i> 我的收藏
            </li>
            <li>
                <i class="el-icon-setting"></i>我为别人填的表单
                </li>
            <li>
                <i class="el-icon-setting"></i>到期受影响的表单
                </li>
            <li @click="togo('/mainDel')">
                <i class="el-icon-setting"></i>回收站
            </li>
        </ul> -->
    </div>
</template>

<script>
export default{
    name: "HomeNav",
    data(){
        return{}
    },
    methods:{
        togo(path){
            this.$router.push(path)
        }
    }
}

</script>

<style>
/* .homeNav{
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
} */
</style>
