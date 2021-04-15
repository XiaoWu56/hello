<template>
    <div class="OptionC">
        <div v-for="(item,index) in info" :key="index">
            <!-- <button style="cursor: move;">移动</button> -->
            <!--radio点击选中，再次点击取消 onclick="if(this.c==1){this.c=0;this.checked=0}else this.c=1" -->
            <!-- 绑定点击事件也可用原来js语句 -->
            <input :type="item.type" name="a" onclick="if(this.c==1){this.c=0;this.checked=0}else this.c=1" @click="change(item)"/>
            <div class="optionSpan">
                <!-- <button>可视</button> -->
                <input placeholder="选项" v-model="item.text"/>
            </div>
            <button @click="delChoose(index)">删除</button>
        </div>
        <button @click="addChoose">添加</button>
    </div>
</template>

<script>
export default {
    name: 'OptionC',
    props: {
        info: {
                type: Array,
                default() {
                    return [
                        {position: 1, isClick: false, isShow: false, text: "正在输入vv", isDel: false},
                        ]
                }
            }
    },
    methods: {
        change(item){
            item.isClick=!item.isClick;
            // this.info.
        },
        addChoose(){
            this.info.push({type: "radio", isClick: false, text: "选项" })
        },
        delChoose(index){
            this.info.splice(index,1) 
        }
    }
}
</script>
<style scoped>
.optionSpan{
    display: inline;
    position: relative;
}
.optionSpan button{
    display: inline;
    position: absolute;
    top: 0px;
    left: 0 px;
}
.optionSpan input{
    /* padding-left: 50px; 具体为可视图标大小 */
    /* padding-left: 50px; */
    width: 5vw;
}

</style>