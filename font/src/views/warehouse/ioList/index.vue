<template>
  <div>
    <div class="top">
      <div class="search">
        <el-input v-model="pagination.keyword" placeholder="用户名搜索" />
      </div>
      <el-button @click="search" type="primary">搜索</el-button>
      <el-button @click="handle_add" type="success">添加物流</el-button>
    </div>
    <div>
      <el-table :data="state.table" border style="width: 100%">
        <el-table-column align="center" prop="inTime" label="入库时间" width="180" />
        <el-table-column align="center" prop="outTime" label="出库时间" width="180" />
        <el-table-column align="center" prop="orderId" label="订单ID" width="180" />
        <el-table-column align="center" prop="operId" label="操作者ID" width="180" />
        <el-table-column align="center" prop="address" label="地址" />
        <el-table-column align="center" prop="houseId" label="仓库ID" width="180" />
        <el-table-column align="center" prop="house.location" label="具体地址" width="180" />
        <el-table-column align="center" prop="house.phone" label="电话" />
        <el-table-column align="center" label="操作" fixed="right">
          <template #default="scope">
            <el-button @click="update(scope.row)" type="primary" class="update">
              操作
            </el-button>
            <el-button @click="register(scope.row)" type="success" class="update"> 
              更新
          </el-button>
            <el-popconfirm title="确认删除?" @confirm="del(scope.row.id)">
              <template #reference>
                <el-button class="del"> 删除 </el-button>
              </template>
            </el-popconfirm>
          </template>
        </el-table-column>
      </el-table>
      <div class="pagination">
        <el-pagination
          background
          layout="prev, pager, next"
          :total="state.total"
          class="pg_el"
        />
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
import { onMounted, reactive, ref } from "vue";
import { ElNotification } from "element-plus";
import Edit from "./edit.vue";
import { deleteWarehouse, getAllWarehouses, registerWareHouse } from "../../../api/warehouse";
const state = reactive({
  table: [],
  total: 0,
  dialogFormVisible: false,
  dialogVal: <Partial<warehouse_table>>{},
});

async function search() {
  const data = await getAllWarehouses(pagination.value);
  state.table = data.data.list;
  state.total = data.data.total;
}

async function handle_add() {
  state.dialogVal = {};
  state.dialogFormVisible = true;
}

function handle_close() {
  state.dialogFormVisible = false;
}

function handle_success(args: any) {
  // Notification
  ElNotification({
    title: "通知",
    message: args,
  });
  search();
}

onMounted(async () => {
  await search();
});

function update(row: warehouse_table) {
  state.dialogFormVisible = true;
  state.dialogVal = row;
  console.log(row);
}

async function del(id: string) {
  const data = await deleteWarehouse(id);
  // @ts-ignore
  if (data.code == 0) {
    ElNotification({
      title: "通知",
      message: "删除成功",
    });
    search();
  }
}

async function register(row:house_table){
    const data = await registerWareHouse(row)
    if(data.data){
      ElNotification({
              title: "通知",
              message:"更新成功"
          })
      search()
    }
}

const pagination = ref({
  keyword: "",
  page: 1,
  size: 10,
});
</script>

<style scoped>
.top {
  width: 500px;
  margin: 20px;
  display: flex;
}
.search {
  width: 200px;
  margin-right: 20px;
}

.del {
  color: red;
}
.pagination {
  width: 100%;
  display: flex;
  align-items: center;
  justify-content: flex-end;
}
.pg_el {
  margin-top: 20px;
  margin-right: 20px;
}
</style>
