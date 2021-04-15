<template>
    <div class="divdialog" v-show="showMask" :newBoardShowDialog="newBoardShowDialog">
        <see />
        <el-button @click="closeMask" class="closeBtn">关闭预览</el-button>
    </div>
</template>

<script>
import See from '../../../../views/see.vue';
import CreateBoard from '../CreateBoard.vue';
export default {
  components: { CreateBoard, See },
    name: 'BoardShowDialog',
    data(){
        return{
            showMask: ""
        }
    },
    methods: {
        getShowMask(){
            this.showMask = this.$store.getters.getShowMask1;  
        },
        closeMask(){
            this.$store.commit('changeShowMask1')
            this.getShowMask()
        }
        
    },
    mounted(){
        this.getShowMask()
    },
    computed:{
        newBoardShowDialog(){
            this.getShowMask()
        }
    }
}
</script>

<style scoped>
.divdialog{
    background: rgba(240, 239, 238, 0.959);
    border: 1px solid rgba(228, 8, 8, 0.534);

    width: 100%;
    height: 100%;
    /* border-radius: 10px; */

    position: absolute;
    top: 0vh;
    left: 0vw;
}
.divdialog .closeBtn{
    position: absolute;
    top: 0vh;
    right: 0vw;
}
</style>