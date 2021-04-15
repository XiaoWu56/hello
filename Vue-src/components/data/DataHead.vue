<template>
    <div class="dataHead">
        <div class="noneThing"></div><!--为了top的文字有line-height效果(还没较好的办法) -->
        <div class="top">
            <div class="left divfloatL">
                <button  @click="togo('/')"><i class="el-icon-arrow-left"></i>返回</button>
            </div>
            <div class="center divfloatL">
                <p><span>#</span>
                {{name}}</p>
                <button>*</button>
                
            </div>
            <ul class="floatright">
                <li>
                    <el-popover placement="top" v-model="visible">
                        <div>
                            <el-button type="primary" size="mini" @click="visible = false">普通套餐</el-button>
                            <el-button type="primary" size="mini" @click="visible = false">个人套餐</el-button>
                        </div>
                        <button slot="reference">套餐升级</button>
                    </el-popover>
                </li>
                <li>
                    <el-popover placement="top" v-model="visible1">
                        <p style="font-weight:700">用户名</p>
                        <span style="">当前套餐: <br/>普通套餐</span>
                        <div>
                            <el-button type="primary" size="mini" @click="visible1 = false">退出</el-button>
                        </div>
                        <button slot="reference"><el-avatar size="small" :src="backImg" style=""></el-avatar></button>
                    </el-popover>
                </li>
        </ul>
        </div>
        <div class="noneThing"></div>
        <div class="down">
            <ul class="divfloatL">
                <el-row>
                <li><el-button size="medium " autofocus="true" @click="togo('/data')">问卷概述</el-button></li>
                <li><el-button size="medium " class=""  @click="togo('/data/dataTable')">问卷数据</el-button></li>
                <li><el-button size="medium " class=""  @click="togo('/data/dataPic')">问卷报表</el-button></li> 
                <li><el-button size="medium " class="" >高级报表</el-button></li>
                </el-row>

            </ul>
            <ul class="divfloatR">
                <li><el-button size="mini" type="primary" round  @click="togo('/form')">编辑</el-button></li>
                <li><el-button size="mini" type="primary" round  @click="togo('/form/set')">设置</el-button></li>
                <li><el-button size="mini" type="primary" round  @click="togo('/form/send')"><i class="el-icon-s-promotion"></i>发布</el-button></li>
            </ul>    
        </div>   
    </div>
</template>

<script>
import backImg from "../../assets/a7.jpg";
export default {
    name: 'DataHead',
    data(){
        return{
            backImg: backImg,
            visible: false,
            visible1: false,
            name: ''
        }
    },
    methods:{
        togo(path){
            // 没返回上一步的操作 this.$router.replace(path)
            this.$router.push(path+'?id='+this.$route.query.id)
        }   
    },
    mounted(){
        // alert('datahead')
        this.name = this.$store.getters.getOneForm.name
    }
}
</script>

<style scoped>
.divfloatL{float:left}
.divfloatR{float:right}
.dataHead{
    width: 98%;
    height: 100%;
    margin: 0 auto;
}
.dataHead li{
    float: left;
}
.dataHead .noneThing{
    width: 100%;
    height: 10%;
}
.dataHead .top{
    width: 100%;
    height: calc(55% - (10% * 2));
    margin: 0  auto;

}
.dataHead .top .left{
    width: 36%;
    height: 100%;
    margin: 0 auto;
}
.dataHead .top .left button,.center{
    color: #fff;
}
.dataHead .top .center{
    width: 27.5%;
    height: 100%;
    /* background: rgb(190, 207, 32); */
    text-overflow: ellipsis;
    overflow: hidden;
}
.dataHead .top .center p {
    width: 95%;
    height: 95%;
    text-align: center;
    font-size: 1.3vw;
    overflow: hidden;
    text-overflow: ellipsis;
    
}
.dataHead .top .right{
    width: 95%;
    height: 100%;
    text-align: center;
    font-size: 1.3vw;
    overflow: hidden;
    text-overflow: ellipsis;
    
}
.dataHead .down{
    width: 100%;
    height: 45%;
    margin: 0 auto;
}
.dataHead .down li{
    line-height: 100%;

}
.el-button{
    background: rgb(42,107,205);
    border: none;
    color: #fff;
}

</style>