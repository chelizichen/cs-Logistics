<template>
    <div class="bg">
        <MakeOrder></MakeOrder>
        <LogisticsList></LogisticsList>
    </div>
</template>

<script setup lang="ts">
// 关于个人的物流信息列表

import LogisticsList from './logisticsList.vue';
import MakeOrder from './makeOrder.vue';

</script>

<style scoped>
.bg{
    height: 100vh;
    background-color: #2d3a4b;
}
</style>