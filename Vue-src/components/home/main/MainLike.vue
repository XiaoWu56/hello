<template>
    <div class="mainLike">
        <show-form v-for="(item,index) in formList" :key="index" :oneform="item"/>
    </div>
</template>

<script>
import ShowForm from '../common/ShowForm'
import qApi from '@/moduleApi/questionApi'
export default {
    name: 'MainLike',
    components: {
        ShowForm
    },
    data(){
        return{
            formList: []
            
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
            qApi.getSelectFormsByCondition({
                userId: 20,
                condition: 'isLike'
            }) 
            .then(successResponse =>{ 
                this.formList = successResponse.data;
            })
        },
    },

    mounted(){
        this.selectFormsByCondition();
    }
}
</script>

<style scoped>
.mainLike{
    width: 100%;
    height: 100%;
}
</style>

