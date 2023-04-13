<style scoped>
.login-bg {
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  padding: 20px 40px 20px 20px;
  border: 1px solid gray;
  background-color: rgb(255, 255, 255);
  border-radius: 20px;

}

.login-out {
  width: 100%;
  height: 8000px;
  background-color: #2d3a4b;
}

.login-form ::v-deep .el-form-item__label {
  color: aliceblue;
}

.text {
  text-align: center;
  margin: 20px 0;
  font-size: 32px;
  color: black;
}

.login-bg>>>.el-form-item__label {
  color: black;
  width: unset !important;
}
</style>
<template>
  <div class="login-out">
    <div class="login-bg">
      <el-form :model="loginForm" label-width="100px" class="login-form">
        <div class="text">注册</div>
        <el-form-item label="邮箱:">
          <el-input v-model="loginForm.email" />
        </el-form-item>
        <el-form-item label="密码:">
          <el-input v-model="loginForm.password" />
        </el-form-item>
        <el-form>
          <el-button type="success" @click="create">注册</el-button>
        </el-form>
      </el-form>
    </div>
  </div>
</template>

<script lang="ts" setup>
import { reactive } from 'vue';
import { useRouter } from 'vue-router';
import { createUser } from '../api/user';
import { ElNotification } from 'element-plus';

const router = useRouter()

const loginForm = reactive({
  email: '',
  password: ''
})


async function create() {
  const data = await createUser(loginForm)
  if (data) {
    router.push("/login")
    ElNotification.success({
      title: "注册成功",
    })
  } else {
    ElNotification.error({
      title: "注册失败",
      'message': "邮箱可能已被注册"
    })
  }
}
</script>  