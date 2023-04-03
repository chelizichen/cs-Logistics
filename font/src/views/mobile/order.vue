<template>
    <div class="make-order">
        <el-card>
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
                    placeholder="Select date and time"
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

const form = reactive<Partial<orders_table>>({
    'orderDate': '',
    'amount': '',
    'total': '',
    'desc': "",
    'customerId':'2'
})

const onSubmit = async () => {
    const data =await createOrder(form)
    console.log(data);
}
</script>

<style scoped>
.make-order {
    margin: 20px 5%;
    width: 90%;
}
</style>