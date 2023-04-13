<template>
    <div class="make-order">
        <div class="make">欢迎来到物流下单界面</div>
        <el-card >
            <el-button type="primary"  @click="to()">点击下单</el-button>
            <p class="yh">目前下单可享优惠</p>
        </el-card>
    </div>
</template>

<script setup lang="ts">
// 关于个人的物流信息列表
// 

import { reactive } from 'vue';
import { createOrder } from '../../api/order';
import { useRouter } from 'vue-router';

const state = reactive({
    
})

const router = useRouter()

function to(){
    router.push("/make/order")
}

function makeOrder() {
    createOrder
}

</script>

<style scoped>
.make-order{
    width: 90%;
    padding: 20px 5% 0 5%;
}
.yh{
    color: red;
}
.make{
    text-align: center;
    padding: 20px 0;
    color: white;
}
</style>