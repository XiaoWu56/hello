<template>
    <div class="set">
        <p>常用设置</p>
        <div class="setBtns">
            <set-btn />
        </div>
    </div>
</template>

<script>
import SetBtn from '@/components/form/setsend/SetBtn.vue'

export default {
    components: { SetBtn },
    name: 'formSet',
    mounted(){
        // alert(this.$route.query.id)
    }
}
</script>

<style>
.set{
    width: 73%;
    height: 100%;
    margin: auto;
    /* padding-top: 1%; */
}
.set p{
    font-size: 1.6vw;
    font-weight: 900;
    /* 代码写法：line-height属性用相对长度单位vw */
    line-height: 4vw;
}
.setBtns{
    width: 100%;
    /* width: 70vw; */
    height: 22%;
    
    
}
</style>