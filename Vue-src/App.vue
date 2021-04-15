<template> 
  <div id="app">
    <router-view v-if="isRouterAlive"/>
  </div>
</template>   
 
<script>
export default {    
  name: 'app', 
  provide(){
    return{
      reload: this.reload
    }
  },
  data () {
    return{ 
      isRouterAlive: true
    }    
  },
  methods: {
    reload(){
      this.isRouterAlive = false
      this.$nextTick(function(){
        this.isRouterAlive = true;
      })
    }
  }
}    
</script>
<style>
#app {  
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  /* text-align: center; */
  color: #000;
  font-family: "Pingfang SC", "Helvetica Neue", "Microsoft Yahei", Helvetica, Arial, "Hiragino Sans GB", "Microsoft Sans Serif", "WenQuanYi Micro Hei", sans;
} 
body{ 
    margin: 0;
    padding: 0;
    font-family: "宋体";
}
ul{
    list-style: none;
    margin: 0;
    padding: 0;
} 
p{
    margin: 0
} 
span,button,a,h1,h2,h3,h4{
    font-size: 1.2vw;
    overflow: hidden;
}
button{
  outline: none;  
  cursor: pointer;
  border: none;
  background: none;
}
</style> 
