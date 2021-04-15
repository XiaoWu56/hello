<template>
    <div class="changeForm">
        <ul>
            <li>复制</li>
            <li>设置</li>
            <li>复制</li>
            <li>设置</li>
            <li>复制</li>
            <li>设置</li>
        </ul>
    </div>
</template>

<script>
export default {
    name: 'ChangeForm',
    methods: {
        
    }
}
</script>

<style scoped>
.changeForm ul{
    /* 注意事项：ul不能继承父div宽高，让父div自适应 */
    width: 15vw;
    height: 35vh;
    border-bottom: 1px solid gainsboro;
    /* border-radius: 10px;
    background: darkcyan; */
}
.changeForm ul li{
    width: 100%;
    height: calc(100% / 6);
}
.changeForm ul li:hover{
    color: rgb(50, 113, 230);
}
</style>