<template>
    <div class="sendDiv">
        <h1>问卷地址</h1>
        <p>将问卷地址粘贴到微信公众号，或者直接发给填表者！</p>
        <input v-model="formUrl" readOnly="true"/>
        <br />
        <!-- 注意事项：复制要用插件 -->
        <el-button type="primary" @click="copyUrl" class="urlread" :data-clipboard-text="formUrl">复制网址</el-button>
        <el-button type="primary" @click="openUrl">直接打开</el-button>
    </div>
</template>

<script>
import Clipboard from 'clipboard';
export default {
    name: 'SendDiv',
    data(){
        return{
            formUrl: '###/write?id='
        }
    },
    mounted(){
        this.formUrl=this.formUrl + this.$route.query.id;
    },
    methods: {
        copyUrl(){
            var clipboard = new Clipboard('.urlread');
            clipboard.on('success', e => {
                alert("复制成功")
                clipboard.destroy()
            })
            clipboard.on('error', e => {
                clipboard.destroy()
            })
        },
//         <!-- this.$router.push('./details?id=' + id + '&pwd=' + pwd)
// this.$router.push(`./details?id=${id}&pwd=${pwd}`) -->
        openUrl(){
            let routeData = this.$router.resolve({ path: '/write?id='+this.$route.query.id});
            window.open(routeData.href, '_blank');
        }
    }
}
</script>

<style scoped>
.sendDiv{
    width: calc(100% - 1.5vw - 1px);
    height: 20vw;
    background: #fff;
    margin-top: 3vh;
    padding-left: 1.5vw;
    border: 1px solid gainsboro;

}
.sendDiv h1{
    font-size:1.6vw;
}
.sendDiv p{
    font-size: 1vw;
    color: gray;
}
.sendDiv input{
    width: calc(100% / 3 * 2);
    height: 5vh;
    padding-left: 0.5vw;
    margin: 1.5vh 0;
    background: rgb(235, 235, 235);
    border: 1px solid gainsboro;
    border-radius: 3px;
    cursor: no-drop;
    font-size: 1.2vw;
}
</style>