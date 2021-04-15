<template>
    <div class="nums">
        <ul class="numsUl">
            <li><h4 class="blueColor">{{numList[0]}}</h4><br/>问卷总数<span class="el-icon-question"></span></li>
            <li><h4 class="blueColor">{{numList[1]}}</h4><br/>今日新增<span class="el-icon-question"></span></li>
            <li><h4>{{numList[2]/1000}}</h4><br/>平均填写时长（秒）<span class="el-icon-question"></span></li>
            <li><h4>{{numList[3]}}</h4><br/>问卷被浏览<span class="el-icon-question"></span></li>
            <li class="nomargin"><h4>{{numList[4]}}</h4><br/>结果被浏览<span class="el-icon-question"></span></li>
        </ul>
    </div>
</template>

<script>
export default {
    name: 'nums',
    props:{
        numList:{
            type: Array,
            default(){
                return [111,0,0,0,0]
            }
        }
    }
}
</script>

<style scoped>
.nums{
    width: 100%;
    height: 100%;
}
.nums .numsUl{
    width: 100%;
    height: 100%;
}
.nums .numsUl li h4{
    display: inline;
    text-align: center;
    line-height: 10vh;
    font-size: 2vw;
    font-weight: normal;
}
.nums .numsUl li{
    width: calc(100% / 5 - 1.7% - 1px);
    height: 100%;
    border: 1px solid gainsboro;
    float: left;
    background: #fff;
    margin-right:  2%;
    text-align: center;
}
.nums .numsUl .nomargin{
    margin-right: 0;
}
.blueColor{
    color:rgb(0, 119, 255);
}
</style>