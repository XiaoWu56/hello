<template>
    <div :newSetFolderDialog="newSetFolderDialog">
        <div class="divdialog" v-show="showMask">
            文件名：
            <el-input v-model="folderName" placeholder="请输入内容"></el-input>

            <br/>
            图案：<input type="text" v-model="folderIcon"/>
            <br/>
            颜色：<input type="text" v-model="folderColor"/>
            <br/>
            <button @click="createFolder">确定</button>
            <button @click="closeMask">取消</button>
        </div>
        
    </div>
</template>

<script>
export default {
    name: 'SetFolderDialog',
    data(){
        return{
            showMask: "",
            folderName: "",
            folderIcon: "",
            folderColor: ""
        }
    },
    methods: {
        getShowMask(){
            this.showMask = this.$store.getters.getShowMask;  
        },
        closeMask(){
            this.$store.commit('changeShowMask')
            this.getShowMask()
        },
        createFolder(){
            // console.log(this.folderName +","+ this.folderIcon +","+ this.folderColor)
            this.showMask = {
                id: '', //存入数据库时返回
                istop: true==true?'':'isnottop', 
                    islike: true==true?'':'isnotlike', 
                    isnew: true==true?'':'isnotnew', 
                    name: this.folderName, 
                    icon: '',
                    iconbg: this.folderColor, //"'"+this.folderColor+"'",不自加引号后面有加
                    formdata: 0
            }
            this.$emit('childSend', this.showMask)//子传给的值是相互已经绑定的
            this.folderName = "";
            this.folderIcon = "";
            this.folderColor = "";
            this.closeMask();

            // {  
            //         istop: true==true?'':'isnottop', 
            //         islike: true==true?'':'isnotlike', 
            //         isnew: true==true?'':'isnotnew', 
            //         name: '人人人人人人', 
            //         icon: '',
            //         iconbg: '22,67,90',
            //         formdata: 80
            //     }
        }
    },
    mounted(){
        this.getShowMask()
    },
    computed:{
        newSetFolderDialog(){
            this.getShowMask()
        }
    }
}
</script>

<style scoped>
.divdialog{
    background: rgba(109, 97, 74, 0.884);
    border: 1px solid rgba(26, 21, 21, 0.534);

    width: 40vw;
    height: 50vh;
    border-radius: 10px;

    position: absolute;
    top: 25vh;
    left: 25vw;
}
</style>