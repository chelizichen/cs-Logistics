<template>
    <div class="bg">
        <br>
        <el-card style="margin: 5%;">
            <div style="font-size: 18px; font-weight: bold; color: #222;">订单总金额：{{ state.data.amount }}元</div>
            <div style="font-size: 16px; margin-top: 10px; color: #666;">下单日期：{{ state.data.orderDate }}</div>
            <div style="font-size: 16px; margin-top: 10px; color: #666;">订单总数：{{ state.data.total }}件</div>
        </el-card>
        <br>
        <br>
        <el-timeline>
            <el-timeline-item v-for="item, index in state.data.warehouseList" :timestamp="item.logisticsTime" placement="top">
                <el-card shadow="always">
    <div style="font-size: 18px; font-weight: bold; color: #222;">集散地址：{{ item.address }}</div>
        <div style="font-size: 16px; margin-top: 10px; color: #666;">入库时间：{{ item.inTime }}</div>
        <div style="font-size: 16px; margin-top: 10px; color: #666;">出库时间：{{ item.outTime }}</div>
                </el-card>
            </el-timeline-item>
        </el-timeline>
    </div>
</template>

<script setup lang="ts">
import { onMounted, reactive } from 'vue';
import { useRoute,useRouter } from 'vue-router';
import { getOrderById } from '../../api/order';

const [route,router] = [useRoute(),useRouter()];
const state = reactive({
    data:{} as Record<string,any>
})

async function renderList(){
    const {query} = route;
    if(typeof query.id == "string"){
        const data = await getOrderById(query.id)
        state.data = data.data
        state.data.orderDate = new Date(state.data.orderDate).toDateString()
        
    }
}
onMounted(async () => {
    await renderList()
})

</script>

<style scoped>
.bg{
    height: 100vh;
    background-color: #2d3a4b;
}
</style>