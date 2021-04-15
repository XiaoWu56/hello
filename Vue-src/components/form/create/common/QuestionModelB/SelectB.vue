<template>
    <div>
        <select @change="change()" v-model="selected"> 
        <!-- <select v-for="item in info" :key="item.id"> -->
            <option v-for="item in info" :key="item.id">{{item.text}}</option>
            <!-- <option v-for="itema in item" :key="itema.id">{{itema.text}}</option> -->

        </select>
    </div>
</template>

<script>
export default {
    name: 'SelectB',
    props: {
        title: 0,
        selected: '',
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
        change(){
            // alert(JSON.stringify(item))
            this.$store.commit('setAnswerData',{
                num: this.title,
                answer: this.selected
            })
        },
    }
}
</script>

<style scoped>


</style>