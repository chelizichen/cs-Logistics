<template>
    <div class="make-order">
        <el-card>
            <template #header>
                <div class="center">物流下单界面</div>
            </template>
            <el-form :model="form" label-width="120px">
                <el-form-item label="总数">
                    <el-input v-model="form.total" />
                </el-form-item>
                <el-form-item label="总金额">
                    <el-input v-model="form.amount" />
                </el-form-item>
                <el-form-item label="下单日期">
                    <el-date-picker
                    v-model="form.orderDate"
                    type="datetime"
                    placeholder="选择下单时间"
                  />
                </el-form-item>

                <el-form-item label="备注">
                    <el-input v-model="form.desc" type="textarea" />
                </el-form-item>

                <el-form-item>
                    <el-button type="primary" @click="onSubmit">提交</el-button>
                    <el-button>取消</el-button>
                </el-form-item>
            </el-form>
        </el-card>

    </div>
</template>
  
<script lang="ts" setup>
import { reactive } from 'vue'
import { createOrder } from '../../api/order';
import { ElNotification } from 'element-plus';

const form = reactive<Partial<orders_table>>({
    'orderDate': '',
    'amount': '',
    'total': '',
    'desc': "",
    'customerId':'2'
})

const onSubmit = async () => {
    await createOrder(form)
    ElNotification.success({
        title:"下单成功",
    })
}
</script>

<style scoped>
.make-order {
    margin: 20px 5%;
    width: 90%;
}
.make-order>>>.el-form-item__label {
    color: black;
    width: 70px !important;
  }
  .center{
    display: flex;
    align-items: center;
    justify-content: center;
    font-family:'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
  }
</style>