<template>
    <div>
        <select-b v-for="item in info" :key="item.id" :info="item" class="selectsdisplay"/>
        
    </div>
</template>

<script>
import SelectB from './SelectB.vue'
export default {
  components: { SelectB },
    name: 'SelectsB',
    props: {
        info: {
            type: Array,
            default(){
                return []
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
.selectsdisplay{
    display: inline;
}

</style>