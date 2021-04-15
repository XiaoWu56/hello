<template>
    <div class="send">
        <div class="left ">

        </div>
        <div class="right">
            <send-div />
        </div>
    </div>
</template>

<script>
import SendDiv from '../../components/form/setsend/SendDiv.vue'
export default {
  components: { SendDiv },
    name: 'formSend',
    
}
</script>

<style>
.send{
    width: 73%;
    height: 100%;
    margin: auto;
    /* padding-top: 1%; */
}
.send .left{
    width:23%;
    height: 100%;
    float: left;
}
.send .right{
    width: 75%;
    height: 100%;
    float: right;
}
</style>