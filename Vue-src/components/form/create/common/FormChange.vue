<template>
    <div class="formch">
        <h3>问卷样式</h3>
        主题样式系列：
        <br/>
        <el-pagination background layout="pager" :total="60" @current-change="bgchange($event)">
        </el-pagination>
        <br/>
        按钮样式：
        <br/>
        <el-color-picker v-model="color" @change="changecolor" :predefine="predefineColors"  color-format="hex ">
        </el-color-picker>
    </div>
</template>

<script>
export default {
    name: 'FormChange',
    components: {
        
    },
    data() {
      return {
        color: 'rgba(255, 69, 0, 0.68)',
        predefineColors: [
          '#ff4500',
          '#ff8c00',
          '#ffd700',
          '#90ee90',
          '#00ced1',
          '#1e90ff',
          '#c71585',
          'rgb(255, 120, 0)',
          'hsv(51, 100, 98)',
          'hsl(181, 100%, 37%)',
          'rgb(89, 70, 228)'
        ]
      }
    },
    methods: {
        bgchange(a){
            this.$store.commit('setFormcoverImage',a)
        },
        changecolor(){
            this.$store.commit('setFormbtnCss',this.color)
        }
    }
}
</script>
<style>
.el-pagination.is-background .el-pager li.active{
  background-color: #d15e25;   
  color: #fff;
}
.formch .el-color-picker__trigger{
    width: 5vw;
    height: 4vh;
}
</style>