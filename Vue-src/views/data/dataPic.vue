<template>
    <div class="dataPic">
        <p>当前问卷还没有统计数据，或没有可以用来统计的题目。例：数字、单选、多选、下拉框或者地理位置等题目。</p>
        

    </div>
</template>

<script>
export default {
    name: 'dataPic',
    components: {
        
    },
    methods: {
        
    }
}
</script>

<style>
.dataPic{
    width: 70%;
    height: 100%;
    margin: 0 auto;
    /* overflow-y: scroll; auto不行，滚动条作用对象为body */
    background: rgb(50, 135, 205);
}

</style>