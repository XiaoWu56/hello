<template>
    <div class="" >
        <div class="dataHead">
            <data-head/>
        </div>
        <div class="dataMain formBg">
            <!-- <data-info />
            <data-table />
            <data-pic /> -->
            <router-view/> 
        </div>
    </div>
</template>

<script>
export default {
    name: 'CreateBoard',
    data(){
        return{
        }
    },
    methods: {
    },
    mounted(){
        //不成功显示，本页mounted方法不行
        alert('data')
    },
    computed: {
    }
}
</script>


<script>
import DataHead from '@/components/data/DataHead.vue'
import dataInfo from './data/dataInfo.vue'
import dataTable from './data/dataTable.vue'
import dataPic from './data/dataPic.vue'
export default {
    name: 'data',
    components: {
        DataHead,
        dataInfo,
        dataTable,
        dataPic
    },
    
}
</script>

<style>
.bgcolor0{ background:rgba(235, 86, 223, 0.336);}
.formBg{ background:rgb(244, 244, 244);}
.dataHead{
    width: 100vw;
    height: 14vh;
    background: rgb(42,107,205);
}
.dataMain{
    width: 100vw;
    height: calc(100vh - 14vh);
    overflow-y: scroll;
}
</style>