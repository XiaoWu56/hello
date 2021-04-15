<template>
    <div class="" :newQuestionChange="newQuestionChange"> 
        <!-- <p>{{showSet}}</p> -->
        <!-- <p>{{questionModel}}</p>  -->
        <!-- 代码写法：数组取最后一个值写法 XXX[XXX.length-1] 错误写法，不是XXX[-1]-->
        <!-- 代码写法：typeMake.A1 A1为对象内部且不为字符串；typeMake[a] a=A1 取值A1为外部变量且为字符串 -->
        <!-- 代码写法：Object.keys(object).length==0或JSON.stringify(evtValue)=='{}' 错误写法（可为字符串判断）：questionModel!={}-->
        <!-- 注意事项：上面的object没效果（报没这方法的错），改用showSet -->
        <h3>编辑题目</h3>
        <div v-if="showSet!=-1">
            <h4>{{nameList[questionModel.type]}}</h4>
            <!-- 注意事项(待改进):传常量数据给子组建props的写法 可将这些数据集中放进vuex等-->
            <input-c :title="'标题'" :tip="'题目说明'" :info="questionModel"/>
            <option-c v-if="questionModel.type=='A1'" :info="questionModel.model"/> 
            <option-c v-if="questionModel.type=='A2'" :info="questionModel.model"/> 
            <option-c v-if="questionModel.type=='A3'" :info="questionModel.model"/> 
            <option-c v-if="questionModel.type=='A4'" :info="questionModel.model"/>
            <option-c v-if="questionModel.type=='A5'" :info="questionModel.model"/> 
            <option-c v-if="questionModel.type=='A6'" :info="questionModel.model"/> 
            <input-c  v-if="questionModel.type=='B1'" :title="'填空'" :tip="'题目说明'" :info="questionModel.name"/>
        </div>
    </div>
</template>

<script>
import InputC from './QuestionModelC/InputC';
import OptionC from './QuestionModelC/OptionC'
export default {
    name: 'QuestionChange',
    components: {
        InputC,
        OptionC
      
    },
    data(){
        return{
            showSet: 0,
            questionModel: {},
            nameList: {
                'A1':'单选题',
                'A2':'多选题',
                'A3':'下拉选择',
                'A4':'多级下拉',
                'A5':'图片单选',
                'A6':'图片多选',
                'A7':'矩阵单选',
                'B1':'填空题',
                }
        }
    },
    props:{
        
    },
    methods: {
        
    },
    mounted(){
        // this.showSet = this.$store.getters.getShowSet;
        this.questionModel = {} 
    },
    watch:{
        
    },
    computed: {
        newQuestionChange(){
            //注意事项：computed同步vuex的store数据更新
            //注意事项：该方法赋予div属性中实现动态更新
            this.questionModel = {};
            this.showSet = this.$store.getters.getShowSet;
            //代码作用：有时题目设置为空（如删除
            
            if(this.showSet!=-1){
                this.questionModel = this.$store.getters.getFormQuestiona[this.showSet];
            }
        }
    }
    

}
</script>

<style>

</style>