<template>
    <div id="" class="homeHead">
        <div class="logo floatleft">
            <logo />
        </div>
        <ul id="" class="floatleft">
            <li>表单</li>
            <li>模板中心<span></span></li>
            <li>应用</li>
        </ul>
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
                    <button slot="reference"><el-avatar :src="backImg" style=""></el-avatar></button>
                </el-popover>
            </li>
        </ul>
    </div>
</template>

<script>
import backImg from "../../assets/a7.jpg";
import logo from './common/logo.vue'
export default {
  name: 'HomeHead',
  components: {
      logo,
  },
  data(){
      return{
          visible: false,
          visible1: false,
          backImg: backImg
      }
  }
}
</script>

<style>
.floatleft{ float:left;}
.floatright{ float:right;}

.homeHead{
    width: 100%;
    height: 100%;
}
.homeHead  .logo{
    width: 10vw;
    height: 100%;

}
.homeHead ul{
    /* width: 100%; */
    height: 100%;
}
.homeHead li{
    /* width: 5vw; */
    height: 100%;
    float: left;
    font-family: "宋体";
    
    font-size: 1.2vw;
    overflow: hidden;
    text-overflow:ellipsis;
    text-align: left;
    line-height: 8vh;
    color: black;
    margin-left: 1vw;
}

</style>