<template>
    <div class="btnboard" :style="{'background-image': 'url('+oneForm.coverImage.bg+')'}">
        <el-button @click="goto('/')">主页</el-button><el-button v-if="!isSubmit" @click="goto('/rerouterwrite')">再填一份</el-button>
        <div class="nothingboard"></div><!-- 注意事项：margin-top作用，因以下直接会直接空白，未解决-->
        <div class="cBoard bgcolor0" :newCreateBoard="newCreateBoard"><!-- :newCreateBoard="newCreateBoard"-->
            <div class="top" >
                <!-- <div class="imgg"></div> -->
                <img :src="oneForm.coverImage.url"/>
                <h2 v-if="isSubmit">{{oneForm.name}}</h2>
                <input v-if="false" type="text" v-model="oneForm.name" placeholder="请输入表单名" />
                <br/>
                <textarea v-if="false" type="text" v-model="oneForm.content" placeholder="可编辑提示语"></textarea>
            </div>
            <div class="ad" v-if="!isSubmit" >
                <h1>提交成功</h1>
            </div>
            <!-- {{formQuestion}} -->
            <!-- 代码写法：循环取数组下标v-for="(arr,index) in arr" 是括号不是花括号-->
            <make-form-question v-for="(item ,index) in formQuestion" :key="index" :titleNum="index" :titleModel="item" :modelFaceNone="'modelFaceNone'"/>

            
            <div class="down" v-if="isSubmit">
                <button :style="{'background': oneForm.btnCss}" @click="submitAnswer">提交</button>
            </div>
        </div>
    
        <div class="nothingboard2" ></div>
    </div>
</template>

<script>
import qApi from '@/moduleApi/questionApi'
import qDApi from '@/moduleApi/questionDataApi'
import MakeFormQuestion from '../components/form/create/common/MakeFormQuestion'
export default {
    name: 'CreateBoard',
    components: {
        MakeFormQuestion
        
    },
    data(){
        return{
            isSubmit: true,
            oneForm: {
                // tUser_id: 20,
                // publishDate: '',
                // endDate: '',
                // status: '',
                // name: '新表单',
                // coverImage: {url:'https://gd-pub.jinshujufiles.com/hi/20191206150603_537ef9@hixlarge',bg:'https://gd-pub.jinshujufiles.com/bgi/20201126165919_a2f8db'},
                // content: '提示语',
                // btnCss: '#5946E4',
            },
            formQuestion: {
                // type: Array,
                // default(){
                //     return []
                // }
            },
            write_time: 0,
            write_place: "定位中",
            //formQuestion是题目数据数组
            //数据位置：store模块formMakeData
            //数据格式：[{...},{...},..] 
            answer: {},
            tooli: 0,
            toolii: 0
        }
    },
    methods: {
        goto(path){
            this.$router.push(path)
        },
        submitAnswer(){
            
            qDApi.getAddData({
            tQuestion_id: this.$store.getters.getOneForm.id,
            tQuestionData: "",//JSON.stringify(this.questionDatainfo.tQuestionData),
            submitter: "",
            write_time: Date.now()-this.write_time,
            write_place: "定位失败",
            }) 
            .then(successResponse =>{ 
                this.isSubmit=false;
                this.formQuestion=[]
            })   
        },
        randomImgBg(){
            // 取 [n,m) 包括n但不包括m的随机整数公式：
            // Math.floor(Math.random() * (m-n)) + n;[1,7)
            this.$store.commit('setFormcoverImage', Math.floor(Math.random() * (7-1)) + 1)
        },
        setFormname(event){
            alert(event.currentTarget.value)
        },
        openMask(){
            this.$store.commit('changeShowMask1')
        },
        makeCoverImage(a){
            
        },
        getLocation() {
            const geolocation = new BMap.Geolocation();
            var _this = this;
            _this.LocationCity = '正在定位';
            geolocation.getCurrentPosition(function getinfo(position){
                let city = position.address.city;             //获取城市信息
                let province = position.address.province;    //获取省份信息
                _this.LocationCity = city;
                _this.success = true;
                alert(province+city)
                // this.write_place=_this.LocationCity;
                // _this.write_place=city
            }, function(e) {
                _this.LocationCity = '定位失败, 请点击重试';
                this.success = false;
            }, {provider: 'baidu'});
            // this.write_place=this.LocationCity
            // alert(_this.write_place);
        }
    },
    mounted(){
        this.write_time=Date.now()
        this.oneForm=this.$store.getters.getOneForm;
        this.formQuestion = this.$store.getters.getFormQuestiona;
        // alert(this.$store.getters.getOneForm.id)
        // if(parseInt(this.$store.getters.getOneForm.id)!=''){
        //     qApi.getSelectForm({formId: parseInt(this.formQuestion = this.$store.getters.getOneForm.id)}) 
        //     .then(successResponse =>{ 
        //         alert(successResponse.data.listQuestionDetailinfo) 
        //         this.oneForm.tUser_id=successResponse.data.tUser_id;
        //         // this.oneForm.publishDate=successResponse.data.publishDate;
        //         // this.oneForm.endDate=successResponse.data.endDate;
        //         // this.oneForm.status=successResponse.data.status;
        //         this.oneForm.name=successResponse.data.name;
        //         // this.oneForm.coverImage=successResponse.data.coverImage;
        //         this.makeCoverImage(JSON.stringify(successResponse.data.coverImage));
        //         // this.oneForm.content=successResponse.data.content;
        //         this.oneForm.btnCss=successResponse.data.btnCss;
        //         this.formQuestion=successResponse.data.listQuestionDetailinfo;
        //     })
        // }
        
        //问卷地址

        //问卷秒数

        //答案：
    },
    computed: {
        newCreateBoard(){
            //注意事项（改改改后）：获取vuex的getFormQuestionA信息失败，但在questionChange板块的computed或取成功
            //注意事项（）：一个变量只被能被一个板块的computed收集？ 目前来看如此
            this.formQuestion = this.$store.getters.getFormQuestiona;
            // this.oneForm = this.$store.getters.getOneForm;
            
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
    width: 53vw;
    margin: 3vh auto;
    border-radius: 5px;
    background: #fff;
    /* 设置padding-bottom 让添加题目时不用改Board的长度*/
    padding-bottom: 3vw;
    overflow: hidden;
}
.cBoard .ad{
    width: 100%;
    height: 40vh;
    margin-top: 4vh;
    
}
.cBoard .ad p{
    margin: auto;
    text-align: center;
    
}
.cBoard .top h2{
    width: calc(50vw - 2vw);
    height: 4vh;
    display: block;
    margin: auto;
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