<template>
    <div class="InputC">
        <p>{{title}}<span class="el-icon-question"></span></p>
        <input placeholder="请输入" v-model="info.name"/>
    </div>
</template>

<script>
export default {
    name: 'InputC',
    props: {
        title: "",
        tip: "",
        info: {
            type:String,
            default: ""
        }
    }
}
</script>
<style scoped>

.inputA{
    /* background: antiquewhite; */
    /* CreateChange为20vw 
        QuestionChange为calc(20vw - 2vw);*/
    width: calc(20vw - 2vw - 0.5vw);
    height: 8vh;
    margin: 0 auto;
}
.inputA input{
    width: calc(20vw - 2vw - 0.5vw - 2vw);
    height: 3vh;
}
</style>