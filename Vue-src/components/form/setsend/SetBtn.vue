<template>
    <div>
        <div class="sBtns">
            <ul class="setbtn setFloatL">
                <li>显示题目序号
                    <button @click="isNum"><el-switch
                        v-model="value1"
                        active-color="#13ce66"
                        inactive-color="#ff4949">
                        </el-switch></button></li>
                <li>问卷填写时自动保存
                    <button><el-switch
                    active-color="#fff"
                    inactive-color="">
                    </el-switch></button></li>
                <li>收集填写者微信信息
                    <button><el-switch
                    active-color="#fff"
                    inactive-color="">
                    </el-switch></button></li>
            </ul>
            <ul class="setbtn setFloatR">
                <li>填写次数限制
                    <button>修改</button>
                    <span class="setFloatR">所有人可以填写</span></li>
                <li>新数据微信提醒
                    <button><el-switch
                    active-color="#fff"
                    inactive-color="">
                    </el-switch></button></li>
                <li>问卷开启/停止
                    <button @click="isOpen"><el-switch
                        v-model="value2"
                        active-color="#13ce66"
                        inactive-color="#ff4949">
                        </el-switch></button>
                    <span :class="[close,'spanClose', 'setFloatR']">已手动停止收集</span>
                    <span :class="[open, 'spanOpen', 'setFloatR']">已开启，正在收集...</span></li>
            </ul>
        </div>
    </div>
</template>

<script>
export default {
    name: 'SetBtn',
    data(){
        return{
            value1: true,
            value2: true,
            open: '',
            close: 'divDisplay',
        }
    },
    methods: {
        successNotice(mess) {
        this.$message({
          message: mess,
          type: 'success',
          center: true,
          duration: 1000
        });
      },
        isNum(){
            // (showNum, isOpen, isTop, isLike, isDelete)
            this.$store.commit('setFormshowNum')
            this.$qApi.getUpdFormToChar({
                formId: parseInt(this.$store.getters.getOneForm.id),
                condition: 'showNum'
            }) 
            .then(successResponse =>{ 
                this.successNotice("修改成功")  
            }) 
        },
        isOpen(){
            this.$store.commit('setFormisOpen')
            this.$qApi.getUpdFormToChar({
                formId: parseInt(this.$store.getters.getOneForm.id),
                condition: 'isOpen'
            }) 
            .then(successResponse =>{ 
                this.successNotice("修改成功")  
            }) 
            this.open= this.open==''?'divDisplay':'';
            this.close= this.close=='divDisplay'?'':'divDisplay';
        }
    },
    mounted(){
        this.value1 = this.$store.getters.getOneForm.showNum==1?true:false;
        this.value2 = this.$store.getters.getOneForm.isOpen==1?true:false;
    }
}
</script>

<style>

.setFloatL{
    float: left;
}
.setFloatR{
    float: right;
}
.sBtns{
    width: 100%;
    height: 100%;
    background: rgb(230, 131, 131);
}
.sBtns .setbtn{
    width: calc(100% / 2 - 1% - 2px); 
    border: 1px solid gainsboro;
    background: #fff;
    padding-top: 1%;
}
.sBtns .setbtn li,.sBtns .setbtn button,.sBtns .setbtn span{
    font-size: 1vw;
}
.sBtns .setbtn li{
    /* 注意事项：因左右padding减十calc(100% - 10%); */
    width: calc(100% - (5% * 2));
    height: 6.5vh;
    padding: 0 5% ;
}
.sBtns .setbtn li button{
    float: right;
}
.sBtns .setbtn li .spanClose{
   
}
.sBtns .setbtn li .spanOpen{
    border-bottom: 1px dashed #000;
   

}
.divDisplay{
    display: none;
}
</style>