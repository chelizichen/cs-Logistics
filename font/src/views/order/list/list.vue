<template>
    <div>
        <div class="top">
            <div class="search">
                <el-input v-model="pagination.keyword" placeholder="用户名搜索"/>
            </div>
            <el-button @click="search" type="primary">搜索</el-button>
            <el-button @click="handle_add" type="success">添加用户</el-button>
        </div>
        <div>
            <el-table :data="state.table" border style="width: 100%">
                <el-table-column align="center" prop="orderId" label="订单ID" width="180" />
                <el-table-column align="center" prop="amount" label="商品总价" width="180" />
                <el-table-column align="center" prop="customerId" label="用户ID" width="180" />
                <el-table-column align="center" prop="orderDate" label="下单日期" />
                <el-table-column align="center" prop="total" label="总价" width="180" />
                <el-table-column align="center" prop="id" label="序号" />
                <el-table-column align="center" label='操作'>
                    <template #default="scope">
                        <el-button @click="update(scope.row)" type="primary" class="update"> 
                            操作
                        </el-button>
                        <el-popconfirm title="确认删除?" @confirm="del(scope.row.id)">
                            <template #reference >
                                <el-button class="del">
                                    删除
                                </el-button>
                            </template>
                          </el-popconfirm>
                    </template>
                </el-table-column>

            </el-table>
            <div class="pagination">
                <el-pagination background layout="prev, pager, next" :total="state.total"  class="pg_el"/>
            </div>
        </div>
    </div>
    <Edit 
    :dialogFormVisible="state.dialogFormVisible"  
    :val="state.dialogVal"
    @close="handle_close"
    @success="handle_success"
    ></Edit>
</template>

<script lang="ts" setup>

import { onMounted, reactive,ref } from 'vue';
import { ElNotification } from 'element-plus';
import Edit from './edit.vue';
import {deleteOrder, getAllOrders} from '../../../api/order';
const state = reactive({
    table:[],
    total:0,
    dialogFormVisible:false,
    dialogVal:<Partial<orders_table>>{}
})


async function search() {
    const data = await getAllOrders(pagination.value)
    state.table = data.data.list;
    state.total = data.data.total
}

async function handle_add() {
    state.dialogVal = {}
    state.dialogFormVisible = true
}

function handle_close() {
  state.dialogFormVisible = false
}


function handle_success(args: any) {
  // Notification
  ElNotification({
    title: "通知",
    message:args
  })
  search()
}


onMounted(async ()=>{
    await search()
})

function update(row:user_table){
    state.dialogFormVisible = true
    state.dialogVal = row
    console.log(row);
}

async function del(id:string){
    const data = await deleteOrder(id)
    // @ts-ignore
    if(data.code==0){
        ElNotification({
            title: "通知",
            message:"删除成功"
        })
        search()
    }
}




const pagination = ref({
    keyword:"",
    page:1,
    size:10
})


</script>

<style scoped>
.top{
    width: 500px;
    margin: 20px;
    display: flex;
}
.search{
    width: 200px;
    margin-right:20px;
}

.del{
    color: red;
}
.pagination{
    width: 100%;
    display: flex;
    align-items: center;
    justify-content: flex-end;
}
.pg_el{
    margin-top: 20px;
    margin-right: 20px;
}
</style>