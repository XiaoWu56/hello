<template>
    <div class="optionRectB">
        <!-- 矩阵单选：横向选项 纵向题目 -->
        <!-- 选项多时有滚动条 题目固定，分两表悬空T-->
        <div class="tableQuestion">
            <table>
                <tr>
                    <td class="questionLength"> #<button @click="smallQuestion">&</button></td>
                </tr>
                <tr v-for="item in info.questions" :key="item">
                    <td>{{item.text}}</td>
                </tr>
            </table>
        </div>
        <div class="tableOption">
            <table>
                <colgroup><col style="width: 80px;" /><col /></colgroup>
                <tr>
                    <td v-for="item in info.options" :key="item" class="optionLength">{{item.text}}</td>
                </tr>
                <tr v-for="(item, index) in info.questions" :key="item">
                    <td v-for="item in info.options" :key="item"><input type="radio" :name="index"/></td>
                </tr>
            </table>
        </div>
    </div>
</template>

<script>
export default {
    name: 'OptionRectB',
    props: {
        info: {
            type: Object,
            default() {
                // 矩阵单选数据默认形式
                return {
                    questions: [
                        { position: 1, text: "题目1"},
                        { position: 2, text: "题目2"},
                        { position: 3, text: "题目3"},
                        { position: 4, text: "题目4"}
                    ],
                    options: [
                        { position: 1, text: "选项A"},
                        { position: 2, text: "选项B"},
                    ]
                };
            }
        }
    },
    methods: {
        smallQuestion(){
            console.log("aaa");
        }
    }
}
</script>
<style scoped>
.optionRectB{
    position: relative;
}
.optionRectB table{
    /* border: 1px solid #fff; */
    /* 设置table中td格没间隔 */
    border-collapse: collapse;
    /* 表格宽度设置自动或固定table-layout：auto | fixed */
    /* table-layout: fixed; */
}
.optionRectB table td{
    border: 1px solid #fff;
    text-align: center;
    /* td超出文本不换行（断，不断，断）word-break：normal | keep-all | break-all */
    word-break: keep-all;
}
.optionRectB .tableQuestion{
    position: absolute;
    top: 0;
    left: 0;
}
/* 模板width：50vw */

.optionRectB .tableQuestion td{
    width: calc(50vw / 7);
    border: 1px solid gainsboro;
}
.optionRectB .tableOption{
    /* 选项表格出现滚动条 */
    /* overflow对table无效，利用div限制 */
    /* 要规定具体width */
    width: calc(50vw / 8 * 6);
    overflow-x: auto;
    padding-left: 100px;
}
.optionRectB .tableOption td{
    border: 1px solid gainsboro;
}
</style>