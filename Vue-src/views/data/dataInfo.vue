<template>
    <div class="dataInfo">
        <div class="notThing"></div>
        <div class="divSets">
            <set-btn />
        </div>
        <div class="divNums">
            <nums :numList="numLista"/>
        </div>
        <div class="divMap">
            
            <Map :num="numLista[0]"/>
            <!-- <data-table/> -->
        </div>
        <div class="btns">
            <el-button>清空数据</el-button>
            <el-button  @click="delForm">删除表单</el-button>
        </div>
        <!-- <p>ECharts 数据的视觉映射</p> -->

    </div>
</template>

<script>
import Map from '@/components/data/info/map.vue'
import Nums from '@/components/data/info/nums.vue'
import SetBtn from '@/components/form/setsend/SetBtn.vue'
import DataTable from './dataTable.vue'

export default {
    name: 'dataInfo',
    components: {
        SetBtn,
        Nums,
        Map,
        DataTable
    },
    data(){
        return{
            numLista: [1,1,1,1,1],
            oneForm: {
                id: -1,
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
        makeRealDetail(){
            for (var tooli=0 ;tooli<this.formQuestion.length;tooli++) {
                this.formQuestion[tooli].model = JSON.parse(this.formQuestion[tooli].model)
            }   
        },
        selectForm(sendString){
            this.$store.commit('newFormQuestiona');
            this.$qApi.getSelectForm({sendString: sendString}) 
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
                this.makeRealDetail()
                this.$store.commit('setForm',this.oneForm)
                this.$store.commit('setFormQuestiona', this.formQuestion)
                // alert(JSON.stringify(this.oneForm))
                // alert(JSON.stringify(this.formQuestion ))
                this.selectNumList(this.oneForm.id)
            })
        },
        selectNumList(formId){
            this.$qDApi.getSelectNumList({formId: formId}) 
            .then(successResponse =>{  
                this.numLista=successResponse.data
            }) 
        },
        delForm(){
            this.$qApi.getUpdFormToChar({
                formId: this.oneForm.id,
                condition: 'isDelete'
            }) 
            .then(successResponse =>{ 
                this.successNotice("删除成功") 
                this.$router.push('/')
            })
        },
    },
    mounted(){
        this.selectForm(this.$route.query.id)  
    },
}
</script>

<style>
.dataInfo{
    width: 73%;
    height: 100%;
    margin: 0 auto;
}
.dataInfo .notThing{
    width: 100%;
    height: 8%;
}
.dataInfo .divSets,.divNums,.divMap,.btns{
    margin-bottom: 2%;
}
.dataInfo .divSets{
    width: 100%;
    height: 23%;
}
.dataInfo .divNums{
    width: 100%;
    height: 19%;
}
.dataInfo .divMap{
    width: 100%;
    height: 64%;
    background: #fff;
    overflow: auto;
}
.dataInfo .btns{
    width: 100%;
    height: 7%;
}
</style>