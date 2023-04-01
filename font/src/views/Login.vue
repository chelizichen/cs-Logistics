<style scoped>
.login-bg {
    position: fixed;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    padding: 20px;
}
.login-out{
    width: 100%;
    height: 8000px;
    background-color: rgb(82, 77, 97);
}
.login-form ::v-deep .el-form-item__label{
    color:aliceblue;
}
.text{
    text-align: center;
    margin: 20px 0;
    font-size: 32px;
    margin-left: 60px;
    color: aliceblue;
}
</style>
<template>
    <div class="login-out">
    <div class="login-bg">
        <el-form ref="loginForm" :model="loginForm" label-width="100px" class="login-form">
            <div class="text">欢迎登录物流管理平台</div>
            <el-form-item label="邮箱:">
                <el-input v-model="loginForm.email"></el-input>
            </el-form-item>
            <el-form-item label="密码:">
                <el-input v-model="loginForm.password"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="success" @click="login">登录</el-button>
            </el-form-item>
        </el-form>
    </div>
</div>
</template>

<script lang="ts" setup>
import { reactive } from 'vue';

const loginForm = reactive({
    email: '',
    password: ''
})

function login() {
    // login 逻辑
}
</script>  