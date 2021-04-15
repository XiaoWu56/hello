<template>
    <div class="mainDel">
        <el-button @click="delForms">清空回收站</el-button>
        <el-table :data="formList" stripe style="width: 100%">
            <el-table-column prop="publishDate" label="日期编号" width="180">
            </el-table-column>
            <el-table-column prop="name" label="姓名" width="180">
            </el-table-column>
            <el-table-column prop="id" label="操作" width="180">
              <template slot-scope="scope">
                  <el-button @click="delForm(scope.row)">恢复</el-button>
              </template>
            </el-table-column>
        </el-table>
    </div>
</template>
<script>
import moment from 'moment'
export default {
    inject: ['reload'],
    name: 'MainDel',
    data() {
      return {
        formList: [],
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
        selectFormsByCondition(){
            this.$qApi.getSelectFormsByCondition({
                userId: 20,
                condition: 'isDelete'
            }) 
            .then(successResponse =>{
                this.formList = successResponse.data;
            })
        },
        delForm(num){
            this.$qApi.getUpdFormToChar({
                formId: num.id,
                condition: 'isDelete'
            }) 
            .then(successResponse =>{ 
                this.successNotice("恢复成功");
                this.reload()
            })
        },
        delForms(){
            this.$qApi.getDelForms({userId: 20}) 
            .then(successResponse =>{ 
                this.successNotice("清空回收站成功") 
                this.reload()
            })
        }
    },
    mounted(){
        this.selectFormsByCondition();
    }
}
</script>

<style scoped>
.mainDel{
    width: 100%;
    height: 100%;
}
</style>


