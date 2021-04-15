<template>
    <div>
        <!-- <form action="#" class=""> -->
            <label>用户名：</label>
            <input type="text"/>
            <br/>
            <label>密码：</label>
            <input type="password" />
            <button @click="toHome('/')">登录</button>
        <!-- </form> -->
    </div>
</template>

<script>
export default {
    name: 'login',
    methods: {
        toHome(){
            this.$router.push(path);
        }
    }
    
}
</script>

<style>

</style>