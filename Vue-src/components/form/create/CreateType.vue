<template>
    <div class="ctype">
        <h3>添加题目</h3>
        <ul v-for="(item, index) in types" :key="index">
            <p>
                {{item.title}}
                <span class="el-icon-question" style="color: rgb(102,102,102)"></span>
            </p>
            <!--代码写法：点击事件传值用循环的变量 clickType(itema.id)-->
            <li v-for="(itema, index) in item.titledetail" :key="index" @click="clickType(itema.id)">
                <p><span :class="['spanp',icons[index%10]]"></span></p><p>{{itema.name}}</p>
            </li>
        </ul>
        
    </div>
</template>
 
<script>
export default {
    name: 'CreateType',
    data(){
        return{
            icons: ['el-icon-sunny','el-icon-cloudy','el-icon-partly-cloudy','el-icon-cloudy-and-sunny','el-icon-moon','el-icon-moon-night','el-icon-dish','el-icon-dish-1','el-icon-food','el-icon-chicken'],
            types: {
                type: Array,
                default(){
                    return []
                }
            }
        }
    },
    methods: {
        clickType(typeId){
            //代码写法：使用store的modules中getters不写模块名
            if(typeId=='A1'||typeId=='A2'||typeId=='A3'||typeId=='A4'
            ||typeId=='A5'||typeId=='A6'||typeId=='A7'||typeId=='B1'){
                this.$store.commit('addFormQuestiona', 
                {   
                    index: this.$store.getters.getFormQuestion.length+1,
                    model: this.$store.state.questionModel.models[typeId]
                }
            )
            }
        }
    },
    mounted(){
        // this.$store.commit('newFormQuestiona');
        this.types = this.$store.getters.getTypes;
    },
    watch: {      
    }
}
</script>

<style scoped>
.ctype{
    width: 97%;
    height: 100%;
    margin-left: 3%;
}
.ctype li, p{
    font-size: 1.2vw;
}
.ctype li{
    width: calc(100% / 2 - 4px - (0.5vh * 2));
    height: 6vh;
    margin-right: 0.5vw ;
    margin-bottom: 0.5vw ;
    float: left;
    
    border: 1px solid gainsboro;
    background: #fff;
}
.ctype div{
    clear: both;
}
.ctype p{
    display: block;
    width: calc( 100% );
    height: 5vh;
    clear: both;
}
.ctype li{
    cursor: pointer;
}

.ctype li p{
    line-height:  6vh;
    text-align: left;
    margin-left: 1vw;
    display: inline;
}
.ctype li .spanp{
    background:rgb(102,102,102);
    color: #fff;
    /* width:1vw;
    height:1vh;     */
    display: inline;
}
/* .ctype li .spanp{
    background: slateblue;
} */
</style>