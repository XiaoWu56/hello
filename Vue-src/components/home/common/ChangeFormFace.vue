<template>
    <div id="" class="setFormFace">
        <button>返回</button>
        <ul>
            <li>
                <input type="text" onchange="changefilename(this.value)"/>
            </li>
            <li>
                <button class="bg" @click="changefilebg(this)">df</button>
                <button class="bg1" @click="changefilebg(this)">df</button>
                <button class="bg2" @click="changefilebg(this)">df</button>
            </li>
            <li>
                <img class="icon1" onclick="changefileicon(this)" src="a1.png"/>
                <img class="icon1" onclick="changefileicon(this)" src="a6.jpg"/>
            </li>
            <li>
                <button class="" onclick="changefiletrue()">确定</button>
                <button class="">取消</button>
            </li>
        </ul>
    </div>
</template>

<script>
export default {
    name: 'ChangeFormFace'
}
</script>

<style>
/* 测试用的 */
.bg{background-color: red;}
.bg1{background-color: rgb(196, 224, 33);}
.bg2{background-color: rgb(32, 241, 137);}
.icon1{
    margin: 10px auto;
    /* display: block; */
    width: 20px;
    height: 20px;
}

.setFormFace{
    width: 15vw;
    height: 40vh;
    /* font-size: 1.2vw; */
    /* overflow: hidden; */


}
</style>