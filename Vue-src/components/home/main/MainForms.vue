<template>
    <div class="mainForms">
        <show-form v-for="(item,index) in formList" :key="index" :oneform="item"/>
    </div>
</template>

<script>
import ShowForm from '../common/ShowForm'
export default {
    inject: ['reload'],
    name: 'MainForms',
    components: {
        ShowForm
    },
    data(){
        return{
            formList: []
        }
    },
    // props: {
    //     formList: {
    //         type: Array,
    //         default(){
    //             return []
    //         }
    //     }
    // },
    methods: {
        selectForms(){
            this.$qApi.getSelectForms({ userId: 20}) 
            .then(successResponse =>{ 
                this.formList = successResponse.data;
            })
        }
    },
    mounted(){
        this.selectForms();
    }
}
</script>

<style scoped>
.mainForms{
    width: 100%;
    height: 100%;
}
</style>

