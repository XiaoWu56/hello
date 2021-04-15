<template>
    <div class="OptionPicB">
        <div v-for="item in info" :key="item.id" class="OptionPicBdisplay">
            <label :for="''+index+title" class="pic"><img :src="bgsrc" style="width: 2vw; height: 2vw;"/></label>
            <br/>
            <input :id="''+index+title" :name="title" :type="item.type"  @click="change(item)"/>
            
        </div>
    </div>
</template>

<script>
import bgsrc from '../../../../../assets/a4.jpg'
export default {
    name: 'OptionPicB',
    data(){
        return{
            bgsrc: bgsrc
        }
    },
    props: {
        title: 0,
        info: {
                type: Array,
                default() {
                    return []
                }
            }
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
.OptionPicBdisplay{
    display:inline-block;
}
.OptionPicBdisplay .pic{
    /* display: display; */
}
</style>