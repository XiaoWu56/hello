<template>
    <div class="btnboard" :style="{'background-image': 'url('+oneForm.coverImage.bg+')'}">
        <div class="nothingboard"></div><!-- 注意事项：margin-top作用，因以下直接会直接空白，未解决-->
        <div class="cBoard bgcolor0">
            <div class="top">
                <img :src="oneForm.coverImage.url"/>
                <h2 v-if="isWrite">{{oneForm.name}}</h2>
            </div>
            <div class="ad" v-if="isSubmit" >
                <h1>提交成功</h1>
            </div>
            <div class="ad" v-if="isClose" >
                <h1>问卷被关闭</h1>
            </div>
            <make-form-question v-for="(item ,index) in formQuestion" :key="index" :titleNum="index" :titleModel="item" :showNum="oneForm.showNum" :modelFaceNone="'modelFaceNone'"/>
            <div class="down" v-if="isWrite">
                <button :style="{'background': oneForm.btnCss}" @click="submitAnswer">提交</button>
            </div>
        </div>
        <div class="nothingboard2"></div>
    </div>
</template>

<script>
import MakeFormQuestion from '../components/form/create/common/MakeFormQuestion.vue'
export default {
    name: 'CreateBoard',
    components: {
        MakeFormQuestion
    },
    data(){
        return{
            oneForm: {
                tUser_id: -1,
                publishDate: '',
                endDate: '',
                status: '',
                name: '',
                coverImage: {url:'',bg:''},
                content: '提示语',
                btnCss: '#5946E4',
            },
            formQuestion: {
                type: Array,
                default(){
                    return []
                }
            },
            isClose: false,
            isSubmit: false,
            isWrite:  true,

            write_time: 0,
            write_place: "广东省佛山市"//插件慢
        }
    },
    methods: {
        divIsShow(){
            this.isSubmit = false;
            this.isClose = false;
            this.isWrite = false;
            this.formQuestion = [];
        },
        //后端到前端的转化
        makeRealDetail(){
            for (var tooli=0 ;tooli<this.formQuestion.length;tooli++) {
                this.formQuestion[tooli].model = JSON.parse(this.formQuestion[tooli].model)
            }   
        },
        // getLocation() {
        //     const geolocation = new BMap.Geolocation();
        //     var _this = this;
        //     _this.LocationCity = '正在定位';
        //     geolocation.getCurrentPosition(function getinfo(position){
        //         let city = position.address.city;             //获取城市信息
        //         let province = position.address.province;    //获取省份信息
        //         _this.LocationCity = city;
        //         _this.success = true;
        //         _this.write_place=province+city
        //         // alert(_this.write_place)
        //     }, function(e) {
        //         _this.LocationCity = '定位失败, 请点击重试';
        //         this.success = false;
        //     }, {provider: 'baidu'});
            
        // },
        submitAnswer(){
            //各div的显示
            // this.$store.commit('setAnswerData',{
            //     num: 1,
            //     answer: '我在'
            // })
            // alert(JSON.stringify(this.$store.getters.getAnswerData))
            // alert(JSON.stringify(this.$store.getters.getAnswerData))
            this.$qDApi.getAddData({
                tQuestion_id: this.oneForm.id,
                tQuestionData: JSON.stringify(this.$store.getters.getAnswerData),
                submitter: "",
                write_time: Date.now()-this.write_time,
                write_place: this.write_place,
            }) 
            .then(successResponse =>{ 
                this.divIsShow()
                this.isSubmit = true;
            })   
        },
    },
    mounted(){
        this.write_time=Date.now()
        //地址栏有参数则在数据库查找
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
                //这里改值有效
                if(this.oneForm.isOpen==0){
                    this.divIsShow()
                    this.isClose = true;
                }
            })
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
    width: 50vw;
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
.cBoard .top h2{
    margin-left: 2vh;
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

</style>