<template>
    <div class="MakeFormQuestion">
        <!-- <p>{{titleNum}}</p>
        <p>{{titleModel}}</p> -->
        <div v-if="titleModel!={}">
            <h3>
                <span v-if="showNum==1?true:false">{{titleNum+1}}.</span>
                {{titleModel.name}}
            </h3>    
            <!-- <span>{{titleModel.tip.text}}</span> -->
            <option-b1 v-if="titleModel.type=='A1'" :title="titleModel.id" :info="titleModel.model" />
            <option-b2 v-if="titleModel.type=='A2'" :title="titleModel.id" :info="titleModel.model" />
            <select-b v-if="titleModel.type=='A3'" :title="titleModel.id" :info="titleModel.model"/>
            <selects-b v-if="titleModel.type=='A4'" :title="titleModel.id" :info="titleModel.model"/>
            <option-pic-b1 v-if="titleModel.type=='A5'" :title="titleModel.id" :info="titleModel.model"/>
            <option-pic-b2 v-if="titleModel.type=='A6'" :title="titleModel.id" :info="titleModel.model"/>
            <option-rect-b v-if="titleModel.type=='A7'" :title="titleModel.id" :info="titleModel.model"/>
            <write-b v-if="titleModel.type=='B1'" :title="titleModel.id" :info="titleModel.model"/>
            <!-- 代码写法：可根据提示信息输入组件名 下面会自动导入和声明-->
            <!-- 注意事项：题目'A1'与'A2'用相同组件，可用v-if后写一句。但为方便理解，整齐不这样 -->
                      
            
        </div>

        <!-- 作用div: 一层遮罩，带有按钮 -->
        <div :class="['modelFace', modelFaceNone]" @click="clickModel($event)"><!--modelFaceNone -->
            <div class="modelPos">
                <button @click="modelUp"><i class="el-icon-top"></i></button>
                <br />
                <button @click="modelDown"><i class="el-icon-bottom"></i></button>
            </div>
            <div class="modelOpt">
                <button @click="modelCopy"><i class="el-icon-document-copy"></i></button>

                <button @click="modelDel"><i class="el-icon-delete"></i></button>   
            </div> 
        </div>
    </div>
</template>     

<script>
import OptionB1 from './QuestionModelB/OptionB.vue';
import OptionB2 from './QuestionModelB/OptionB.vue';
import SelectB from './QuestionModelB/SelectB.vue';
import SelectsB from './QuestionModelB/SelectsB.vue';
import OptionPicB1 from './QuestionModelB/OptionPicB.vue';
import OptionPicB2 from './QuestionModelB/OptionPicB.vue';
import OptionRectB from './QuestionModelB/OptionRectB.vue';
import WriteB from './QuestionModelB/WriteB.vue';
export default {
    name: 'MakeFormQuestion',
    components: {
        OptionB1,
        OptionB2,
        SelectB,
        SelectsB,
        OptionPicB1,
        OptionPicB2,
        OptionRectB,
        WriteB
        
    },
    data() {
        return{
            modelUpNum : -1,
            // 因方法为先复制添加后删除
            modelDownNum : 2,
            modelCopyNum : 1,
            modelDelNum : 0,
            
        }
    },
    props: {
        titleNum: "",
        titleModel: {
            type: Object,
            default(){
                return {}
            }
        },

        modelFaceNone: "",
        showNum: {
            type: Number,
            default: 1
        }
    },
    methods: {
        modelUp(){
            //判断：第一题向上移动无效
            if(this.titleNum!=0){
                this.$store.dispatch('getChangeFormQuestion', 
                {titleNum: this.titleNum, 
                titleOpt: this.modelUpNum});
            }
        },
        modelDown(){
            //判断：最后一题向下移动无效
            // alert(this.questionModel.size())
            // if(this.titleNum<this.questionModel.length()){
                this.$store.dispatch('getChangeFormQuestion', 
                {titleNum: this.titleNum, 
                titleOpt: this.modelDownNum});
            // }
            
        },
        modelCopy(){
                this.$store.dispatch('getChangeFormQuestion', 
                    {titleNum: this.titleNum, 
                    titleOpt: this.modelCopyNum}
                );
                
        },
        modelDel(){
            // alert(this.titleModel.id)
            this.$store.dispatch('getChangeFormQuestion', 
            {titleNum: this.titleNum, 
            titleOpt: this.modelDelNum});
        },
        clickModel(event){
            // console.log(event);
            this.$store.commit('changeShowSet', this.titleNum);
        }
    },
    mounted(){
        //注意事项（改改改后）：直接用props的数据，不给本组件data赋值
        //注意事项（）：对于props=data，mounted时，刚开始没数据；computed时没作用吧
        
    },
    computed: {
        
    }
}
</script>

<style scoped>
/*
CreateBoard的数值 
width: 50vw;
height: 20vmax;  */
.MakeFormQuestion{
    /* background: silver; */
    width: 48vw;
    height: 50px;
    margin: 10px auto; 

    position: relative;
    /* 让div内容超过时高度增加 不用采用js方式 */
    display: table;
}
.modelFace{
    position: absolute;
    top: 0;
    left: 0;
    width: 48vw;
    /* 父元素没有定义高度，子元素获取父元素的实际高度。 */
    height: 100%;
    background: rgba(224, 220, 219, 0.322);
    
}

.modelFaceNone{
    display: none;
}
.modelFace .modelPos{
    position: absolute;
    right: 1vw;
    bottom: 1vw;
}
.modelFace .modelOpt{
    position: absolute;
    right: 1vw;
    bottom: -0.5vw;
}
.modelFace button{
    color: darkorange;
    font-size: 1.3vw;
    font-weight: 900;
}
.modelFace button:hover{
    color: rgb(0, 81, 255);
}
</style>