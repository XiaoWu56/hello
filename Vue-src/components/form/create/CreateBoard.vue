<template>
    <div class="btnboard" :style="{'background-image': 'url('+oneForm.coverImage.bg+')'}">
        <div class="nothingboard"></div><!-- 注意事项：margin-top作用，因以下直接会直接空白，未解决-->
        <div class="cBoard bgcolor0" :newCreateBoard="newCreateBoard">
            <div class="top">
                <img :src="oneForm.coverImage.url"/>
                <input type="text" v-model="oneForm.name" placeholder="请输入表单名" />
                <br/>
                <textarea type="text" v-model="oneForm.content" placeholder="可编辑提示语"></textarea>
            </div>
            <!-- {{formQuestion}} -->
            <make-form-question v-for="(item ,index) in formQuestion" :key="index" :titleNum="index" :titleModel="item" :modelFaceNone="''"/>
            <div class="down">
                <button :style="{'background': oneForm.btnCss}">提交</button>
            </div>
        </div>
        
        <div class="createad">
            <p>金数据表单底部广告</p>
            <button>X 去广告</button>
        </div>
        <div class="twobtn">
            <button @click="randomImgBg"><span class="el-icon-edit" style="font-size:2vw"></span><br/>换主题</button>
            <button @click="openMask"><span class="el-icon-data-analysis" style="font-size:2vw"></span><br/>预览</button>
        </div>
        <div class="nothingboard2"></div>
    </div>
</template>

<script>
import MakeFormQuestion from './common/MakeFormQuestion.vue'

export default {
    name: 'CreateBoard',
    components: {
        MakeFormQuestion
        
    },
    data(){
        return{
            oneForm: {
                tUser_id: 20,
                publishDate: '',
                endDate: '',
                status: '',
                name: '新表单',
                coverImage: {url:'https://gd-pub.jinshujufiles.com/hi/20190429172922_332985@hixlarge',bg:'https://gd-pub.jinshujufiles.com/bgi/20201126165919_a2f8db'},
                content: '提示语',
                btnCss: '#5946E4',
            },
            formQuestion: {
                type: Array,
                default(){
                    return []
                }
            }
            //formQuestion是题目数据数组
            //数据位置：store模块formMakeData
            //数据格式：[{...},{...},..] 
        }
    },
    methods: {
        randomImgBg(){
            // 取 [n,m) 包括n但不包括m的随机整数公式：
            // Math.floor(Math.random() * (m-n)) + n;[1,7)
            this.$store.commit('setFormcoverImage', Math.floor(Math.random() * (7-1)) + 1)
        },
        openMask(){
            this.$store.commit('changeShowMask1')
        },
        //后端到前端的转化
        makeRealDetail(){
            for (var tooli=0 ;tooli<this.formQuestion.length;tooli++) {
                this.formQuestion[tooli].model = JSON.parse(this.formQuestion[tooli].model)
            }   
        },
    },
    mounted(){
        //清vuex表单明细内容
        this.$store.commit('newFormQuestiona');
        //地址栏有参数则在数据库查找
        // alert(this.$route.query.id!=null?'T':'F')
        if(this.$route.query.id!=null){
            this.$qApi.getSelectForm({sendString: this.$route.query.id}) 
            .then(successResponse =>{ 
                this.oneForm.id = successResponse.data.id,
                this.oneForm.name = successResponse.data.name,
                this.oneForm.coverImage = JSON.parse(successResponse.data.coverImage),
                this.oneForm.content = successResponse.data.content,
                this.oneForm.btnCss = successResponse.data.btnCss,
                this.oneForm.sendString = successResponse.data.sendString,
                this.oneForm.showNum = successResponse.data.showNum,
                this.oneForm.isOpen = successResponse.data.isOpen,
                this.formQuestion = successResponse.data.listQuestionDetailinfo
                //将对象或数组字符串转对象
                this.makeRealDetail()
                //更新明细，在内部才同步
                // this.$store.commit('setForm',this.oneForm)
                this.$store.commit('setFormQuestiona', this.formQuestion)
            })
        }
        this.$store.commit('setForm',this.oneForm)
        // this.$store.commit('setFormQuestiona', this.formQuestion)
    },
    
    watch:{

    },
    computed: {
        newCreateBoard(){
            this.formQuestion = this.$store.getters.getFormQuestiona;
            // this.$store.commit('setForm',this.oneForm)            
        }
    }
}
</script>

<style scoped>
.btnboard{
    position: relative;
    background-color: rgb(255, 255, 255);
    background-repeat: repeat;
    background-size: cover;
    background-position: center top;
    /* background-image: url(https://gd-pub.jinshujufiles.com/bgi/20201126165919_a2f8db); */
}
.nothingboard{
    width:100%;
    height:5vh;
    display: block
}
.nothingboard2{
    width:100%;
    height: 20vh;
    display: block
}
.cBoard{
    width: calc(100% - 10%);
    margin: 3vh auto;
    border-radius: 5px;
    background: #fff;
    /* 设置padding-bottom 让添加题目时不用改Board的长度*/
    padding-bottom: 3vw;
    overflow: hidden;
}
.cBoard .top img{
    width: 100%;
    height: 7vmin;
    /* 代码写法：有图时与没图时写法,vmin,vmax */
    height: 15vmax;
    background: rgb(112, 108, 104);
}
.cBoard .top input,textarea{
    width: calc(50vw - 2vw);
    height: 4vh;
    display: block;
    margin: auto;

}
.cBoard .top textarea{
    height: 8vh;
}
.cBoard .down button{
    /* 代码写法：可以给calc的计算结果加vmin单位 */
    width: 20vmin;
    /* calc((100% / 4)vmin); */
    height: 5vmin;
    margin: 0 auto; 
    display: block;

    font-size: 1.2vw;
    background: #5946E4;
    border: none;
    border-radius: 3px;
    /* letter-spacing: 1vw; */
    text-align: center;
    
}
.createad {
    width: calc(100% - 10%);
    height: 9vh;
    margin: 2vh auto;
    border-radius: 5px;
    background: gainsboro;
}
.createad p{
    display: inline-block;
    margin-left: calc(50% - 10%);
    margin-top: 2%;
    color: rgb(197, 195, 195);
    
}
.createad button{
    width: 6vw;
    height: 5vh;
    margin-right: 5%;
    margin-top: 2%;
    border-radius: 5vw;
    background: rgb(204, 194, 194);
    color: rgb(241, 238, 238);
    float: right;
}
.twobtn{
    width: 4.5vw;
    height: 20vh; 
    position: absolute;
    top: 6vh;
    right: 0;
}
.twobtn button{
    width: 100%;
    height: calc(100% / 2 - 5%);
    margin-bottom: 20%; 

    border-radius: 3px;
    color: #333;
    background: #fff;
    box-shadow: 0 1px 2px rgba(0,0,0,.3);
    cursor: pointer;
    opacity: .7;
}
.twobtn button span:hover{
    color: #333;
    font-weight: 900;
}

.cBoard .boardli{
    margin: 10px auto;
    width:48vw;
    height: 150px;
    border:3px dashed darkorange;
}
</style>