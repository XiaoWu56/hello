<template>
    <div class="changeForm"><!-- isnotform-->
        <change-form-add class="isnotform"/>
        <ul>
            <li @click="makeTop">设置置顶</li>
            <li @click="makeLike">设置收藏</li>
            <li @click="delForm">设置删除</li>
            <!-- <li v-if="true" style="background: rgb(230, 50, 215); height:12vh">
                <input/><br/>
                <div class="el-color-predefine__colors">
                    <div class="el-color-predefine__color-selector" v-for="(color,index) in colorList" :key="index">
                        <div :style="{'background-color': color}" @click="editForm('color', index)"></div>
                    </div>
                </div>
                <div class="el-color-predefine__colors">
                    <div class="el-color-predefine__color-selector" v-for="(color,index) in colorList" :key="index">
                        <div style="background-color: #fff" @click="editForm('color', index)"></div>
                    </div>
                </div>
                
            </li> -->
            <li @click="editForm">编辑</li>
            <li >共享设置</li>
            <li @click="setsign">设置标签</li>
        </ul>
    </div>
</template>

<script>
// inject: ['reload']

// this.reload()
// import qApi from '@/moduleApi/questionApi'
import ChangeFormAdd from './ChangeFormAdd.vue';
export default {
    components: { ChangeFormAdd },
    inject: ['reload'],
    name: 'ChangeForm',
    data(){
        return{
            colorList: ['#FF8C00','#FFD700','#90EE90','#00CED1','#C71585'],
            picList: []
        }
    },
    props: {
        formId: 0
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
        togo(path){
            this.$router.push(path)
        },
        makeTop(){
            // (showNum, isOpen, isTop, isLike, isDelete)
            this.$qApi.getUpdFormToChar({
                formId: this.formId,
                condition: 'isTop'
            }) 
            .then(successResponse =>{ 
                this.successNotice("修改置顶成功")
                this.reload()
            })
        },
        makeLike(){
            this.$qApi.getUpdFormToChar({
                formId: this.formId,
                condition: 'isLike'
            }) 
            .then(successResponse =>{ 
                this.successNotice("修改收藏成功")
                this.reload()  
            })       
        },
        delForm(){
            this.$qApi.getUpdFormToChar({
                formId: this.formId,
                condition: 'isDelete'
            }) 
            .then(successResponse =>{ 
                this.successNotice("删除成功") 
                this.reload()
            })
        },
        editForm(a){
            alert(a)
            // this.$qApi.getUpdFormToCondition({
            // // （填写次数limitTime，表单名字name，表单图标（颜色，图标）icon）
            //     formId: this.formId,
            //     condition: 'name',
            //     conditionNum: 'CCC'
            // }) 
            // .then(successResponse =>{ 
            //     this.successNotice("修改成功")
            // })
            // this.closeMask();
        },
        setsign(){
            // this.closeMask();
        },
    }
}
</script>

<style scoped>

.isnotform{
    display: none;
}
.changeForm ul{
    /* 注意事项：ul不能继承父div宽高，让父div自适应 */
    width: 15vw;
    height: 45vh;
    border-radius: 10px;
}
.changeForm ul li{
    width: 100%;
    height: 5vh;
}
.changeForm ul li:hover{
    color: rgb(50, 113, 230);
}
</style>