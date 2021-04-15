<template>
    <div>
        <input @change="write($event)"/>
    </div>
</template>

<script>
export default {
    name: 'SelectB',
    props: {
        title: 0,
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
        write(event){
            // console.log(event.target.value);
            this.$store.commit('setAnswerData',{
                num: this.title,
                answer: event.target.value
            })
        }
    }
}
</script>

<style scoped>
</style>