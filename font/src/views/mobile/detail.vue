<template>
    <div>
        <el-card >
            <h4>{{ state.data.amount }}</h4>
            <h4>{{ state.data.orderDate }}</h4>
            <h4>{{ state.data.total }}</h4>
        </el-card>

        <el-timeline>
            <el-timeline-item v-for="item, index in state.data.warehouseList" :timestamp="item.logisticsTime" placement="top">
                <el-card >
                    <h4>{{ item.address }}</h4>
                    <h4>{{ item.inTime }}</h4>
                    <h4>{{ item.outTime }}</h4>
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
        console.log("data",data);
        
    }
}
onMounted(async () => {
    await renderList()
})

</script>

<style scoped>

</style>