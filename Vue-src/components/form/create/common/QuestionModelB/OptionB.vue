<template>
    <div class="optionB">
        <!-- {{info}} -->
        <div v-for="(item,index) in info" :key="index">
            <!-- 注意事项：设置被选checked="checked" 唯一被选:name="title"用表单题号-->
            <!-- 注意事项：id与for作用：点击文字同步选项被选 -->
            <input :id="''+index+title" :name="title" :type="item.type" :checked='item.isClick' @click="change(item)"/>
            <label :for="''+index+title">{{item.text}}</label>
        </div>
    </div>
</template>

<script>
export default {
    name: 'OptionB',
    props: {
        title: 0,
        info: {
                type: Array,
                default() {
                    return []
                }
                //info是选项数据
                //数据格式：
                // [
                //     { position: 1, type: "radio", isClick: false, isShow: false, text: "" },
                // ...]
            },
            tooli: 0
    },
    methods: {
        change(item){
            // alert(JSON.stringify(item))
            this.$store.commit('setAnswerData',{
                num: this.title,
                answer: item.text
            })
        },
    }
}
</script>
<style scoped>

</style>