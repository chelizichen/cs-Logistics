<template>
    <div class="logisitics">
        <el-timeline>
            <el-timeline-item v-for="item, index in state.data" :timestamp="item.logisticsTime" placement="top">
                <el-card @click="to(item.id)" >
                    <h4>{{ item.logisticsCompany }}</h4>
                    <p>{{ getStatus(item.logisticsStatus) }}</p>
                </el-card>
            </el-timeline-item>
        </el-timeline>
    </div>
</template>

<script setup lang="ts">
// 关于个人的物流信息列表

import { onMounted, reactive } from 'vue';
import { getLogisticsByUserId } from '../../api/logistics';
import { useRoute,useRouter } from 'vue-router';

const [route,router] = [useRoute(),useRouter()];

const userId = localStorage.getItem("userId") || "1"

const state = reactive({
    data: [] as any[]
})

function to(id:string){
    router.push("/detail/logisitics?id="+id)
}

function getStatus(status: string) {
    if (status == "1") {
        return "待发货"
    }
    if (status == "2") {
        return "待收货"
    }
    if (status == "3") {
        return "已收货"
    }
    if (status == "0") {
        return "已退货"
    }
}
// 
onMounted(async () => {
    const data = await getLogisticsByUserId({ 'id': "2", "page": "1", "size": "10" })
    state.data = data.data.list
})
</script>

<style scoped>
.logisitics{
    width: 90%;
    margin: 0 5%;
}
</style>