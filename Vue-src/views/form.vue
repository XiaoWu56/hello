<template>
    <div class="">
        <div class="formHead">
            <form-head />
        </div>
        <div class="formMain">
            <router-view/> 
        </div>
        <board-show-dialog />
    </div>
</template>

<script>
import BoardShowDialog from '../components/form/create/common/BoardShowDialog.vue'
import FormHead from '../components/form/FormHead.vue'

export default {
    name: 'form',
    components: { 
        FormHead,
        BoardShowDialog
    }
    
}
</script>

<style>
.formHead{
    width: 100vw;
    height: 10vh;
    background: rgb(51, 51, 51);
}
.formMain{
    width: 100vw;
    height: 90vh;
    background: rgb(250, 250, 250);
}
</style>