<template>
    <!-- 共有弹出框 如何锁定所选表单 设全局变量 //不公用可单个设id，但重复麻烦-->
    <div v-show="showMask" :newSetFormDialog="newSetFormDialog">
        <div id="choose1" @click="noOptClose" class="divSetFormDialog">
            <div  class="ulDialog" :style="{top: `${clientXY[1]}px`, left: `${clientXY[0]}px`}">
                <change-folder :formId="this.clientXY[2].id"/>
                <!-- <change-form-face /> -->
                <!-- <router-view name="changeFolder"></router-view> -->
            </div>
        </div>
    </div>
</template>

<script>
import ChangeFolder from './ChangeFolder.vue';
import ChangeFormFace from './ChangeFormFace.vue';
export default {
    name: 'SetFormDialog',
    components: { 
        ChangeFolder,
        ChangeFormFace
    },
    data(){
        return{
            showMask: "",
            clientXY: [0,0,0]
        }
    },
    props: {

    },
    methods: {
        getShowMask(){
            this.showMask = this.$store.getters.getShowMaskForm; 
            this.clientXY = this.$store.getters.getClientInfo; 
        },
        closeMask(){
            // this.showMask = false;  
            this.$store.commit('changeShowMaskForm')
            this.getShowMask()      
        },
        // makeTop(){
        //     // 调用本身方法写法，加this和括号(一定要加this)
        //     //['makeTop','']
        //     // console.log(this.clientXY[2]['id'])
        //     // console.log(this.clientXY[2]['istop']) 
        //     //数据为一条公式(取后端数据时将公式取消，只有true/false 到制造表单时识别class类【保证数据简单】)
        //     // console.log(this.clientXY[2]['istop']==""?"isnottop":"")
        //     this.clientXY = [this.clientXY[2]['id'], 'istop', this.clientXY[2]['istop']==""?"isnottop":""]; 
        //     //只传数据与名字无关[formid, '变量名：istop', '变量值：this.clientXY[2]['istop']==""?"isnottop":""']
        //     this.$emit('childSend', this.clientXY);
        //     this.closeMask();
        // },
        // makeLike(){
        //     this.clientXY = [this.clientXY[2]['id'], 'islike', this.clientXY[2]['islike']==""?"isnotlike":""]; 
        //     this.$emit('childSend', this.clientXY);
        //     this.closeMask();            
        // },
        // delForm(){
        //     this.clientXY = [this.clientXY[2]['id'], 'status', 'del']; 
        //     this.$emit('childSend', this.clientXY);
        //     this.closeMask();
        // },
        // editForm(){
        //     this.closeMask();
        // },
        // setsign(){
        //     this.closeMask();
        // },
        //监控再次点击时 弹窗外则关闭（整个窗口，或局部监控T）
        //弹窗有两层，一层阴影，一层甚至弹窗
        noOptClose(){
            this.closeMask();
        }
    },
    mounted(){
        this.getShowMask()
    },
    computed:{
        newSetFormDialog(){
            this.getShowMask()
        }
    }
}
</script>

<style scoped>
.ulDialog{
    background: rgba(76, 126, 76, 0.589);
    border: 1px solid rgba(26, 21, 21, 0.534);
    border-radius: 10px;
    /* width: 15vw;
    height: 40vh; */
    /* font-size: 1.2vw; */
    /* overflow: hidden; */
    position: absolute;
    top: 5vh;
    left: 5vw;
}
.divSetFormDialog{
    background: rgba(0,0,0,0.2);
    width: 100%;
    height: 100%;
    /* 注意事项：面罩不能与body长宽自适应 */
    /* overflow:scroll; */
    /* width:auto; 
    height:auto; */
    /* display:inline-block; */
    
    position: absolute;
    top: 0vh;
    left: 0vw;
}
</style>