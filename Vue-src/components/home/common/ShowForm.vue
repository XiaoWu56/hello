<template>
    <div id="divform1" class="showForm floatLeft" @mousemove="btnShow" @mouseout="btnNotShow">
        <!-- 代码写法：改样式的class要有v-bind绑定和中括号 :class="['icontop', oneform.istop]"-->
        <!-- 代码写法(style样式的带单位)：1传变量只能有值单位另加:style="{'--iconbg': '#'+oneform.iconbg}"-->
        <!-- 代码写法：2用表达式:style="{background: `#${size}`  注意是反引号不是单引号-->
        <span :class="['icontop', oneform.isTop]" style="font-size: 2vw; color:red;"><i class="el-icon-setting"></i></span>
        <span :class="['iconlike', oneform.isLike]" style="font-size: 2vw; color:orange;"><i class="el-tooltip el-icon-menu item"></i></span>        
        
        <p class="name">
            <span :class="[oneform.status]">[新]</span>
            <span id="formname1">{{oneform.name}}{{oneform.icon['color']}}</span>
        </p>                                                 <!--  'rgb('+one+')'   -->
        <span  @click="gotoform" :class="['icon', oneform.icon[1]]" :style="{'font-size': '4.5vw','color': oneform.icon[0]}" ></span>
        
        <p class="data">
            <span class="num">{{formdata}}</span>
            <span>数据</span>
            <button :class="[isbtn]" @click="clickFormInfo($event)">...</button>
        </p>
    </div>
</template>

<script>
export default {
    name: 'ShowForm',
    components: {
    },
    data(){
        return{
            isbtn: 'isnotbtn',
            formdata: 0
        }
    },
    props: {
        oneform: {
            type: Object,
            default: {
                id: 0,
                tUser_id: 0,
                status: 'isnotnew',
                name: "",
                isTop: 0,
                isLike: 0,
                sendString: '',
                icon: ['',''],
            }
        }
    },
    methods: {
        // 作用：省略号显示
        gotoform(){
            // this.$store.commit('setSendNum',this.oneform.id)
            this.$router.push("/data?id="+this.oneform.sendString)
        },
        btnShow(){
            this.isbtn = ""
        },
        btnNotShow(){
            this.isbtn = "isnotbtn"
        },
        //  togo(path){
        //     // 没返回上一步的操作 this.$router.replace(path)
        //     this.$router.push(path)
        // }@click="togo('/mainLike')"
        clickFormInfo(event){
            // 代码写法：传本身元素事件XXX($event),
            // event.target.value获取标签value值，这里没用到
            // this.testa = [event.clientX, event.clientY, this.oneform];
            this.$store.commit('changeShowMaskForm')
            this.$store.commit('addClientInfo', [event.clientX, event.clientY, this.oneform])

            // this.$router.push('/changeFolder')
        },
        makeIcon(a){
            this.oneform.icon=this.oneform.icon.split(':');
            if(this.oneform.icon.length!=0){
                this.oneform.icon[0]=this.oneform.icon[1].split(',')[0];
                this.oneform.icon[1]=this.oneform.icon[2].split('}')[0];
            }
        }
    },
    
    mounted(){
        this.oneform.status= this.oneform.status==0?'isnotnew':'';
        this.oneform.isTop= this.oneform.isTop==0?'isnottop':'';
        this.oneform.isLike= this.oneform.isLike==0?'isnotlike':'';
        
        this.makeIcon(this.oneform.icon)

        this.$qDApi.getSelectDatas({formId: this.oneform.id}) 
        .then(successResponse =>{  
            this.formdata=successResponse.data.length;
        })
    }
}
</script>

<style>
.floatLeft{
    /* 注意事项： 各表单并列*/
    float: left;
}
.isnottop, .isnotlike, .isnotnew, .isnotbtn{
    display: none;
}
.showForm{
    border: 1px solid gainsboro;
    background: #fff;
    /* - 2% - 2px margin border */
    width: calc(100% / 4 - 2% - 2px);
    height: 35vh;
    margin: 0 1%;
    margin-top: 5vh;
    position: relative;
}
.showForm .iconlike,.icontop{
    width: calc(100% / 6);
    height: calc(100% / 7);
}
.showForm .iconlike{
    position: absolute;
    top: -2px;
    left: calc(100% / 6);
}
.showForm .icontop{
    position: absolute;
    top: calc(100% / 7 * (-0.5));
    left: calc(100% / 6 * 2.5);
}
.showForm .name{
    width: 100%;
    height: calc(100% / 7);
    text-align: center;
    /* margin-top为收藏图标下 */
    margin-top: calc(100% / 7);
}
.showForm .icon{
    width: calc(100% / 3);
    height: calc(100% / 4);

    margin: calc(100% / 7) auto;
    /* margin-top: calc(100% / 7); */
    display: block;
    
}
.showForm .data{
    width: calc(100% - 10%);
    height: calc(100% / 4);
    margin: 0 auto;
    margin-top: calc(100% / 7 * 1.5) ;
}
.showForm .data .num{
    font-size: 2vw;
}
.showForm .data button{
    font-size: 2vw;
    float: right;
    border: none;
    background: none;
    outline-style: none;
}
.showForm .data button:hover{
    color: rgba(17, 106, 240, 0.788);
}
</style>