<template>
    <div>
        下单界面
    </div>
</template>

<script setup lang="ts">
// 关于个人的物流信息列表
// 

import { reactive } from 'vue';
import { createOrder } from '../../api/order';

const state = reactive({
    
})

function makeOrder() {
    createOrder
}

</script>

<style scoped>

</style>