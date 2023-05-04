<template>
  <el-dialog v-model="props.dialogFormVisible" title="Shipping address" @closed="close">
    <el-form :model="props.val">

      <el-form-item label="总价" :label-width="formLabelWidth">
        <el-input v-model="props.val.amount" autocomplete="off" />
      </el-form-item>
      <el-form-item label="下单日期" :label-width="formLabelWidth">
        <el-input v-model="props.val.orderDate" autocomplete="off" />
      </el-form-item>
      <el-form-item label="商品总价" :label-width="formLabelWidth">
        <el-input v-model="props.val.total" autocomplete="off" />
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="close">取消</el-button>
        <el-button type="primary" @click="submit">
          修改
        </el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import { reactive, ref, watch } from 'vue'
import { createUser, updateUser } from '../../../api/user';
import { createOrder, getOrderById, updateOrder } from '../../../api/order';

const props = defineProps<{
  dialogFormVisible: boolean,
  val: Partial<orders_table>
}>()


const formLabelWidth = '140px'

async function submit() {
  if(props.val.id){
    const data = await updateOrder(props.val.id, props.val)
    console.log(data);
    
  }else{
    const data = await createOrder(props.val)
    console.log(data);
  }
  // @ts-ignore
  // if (data.code == 0) {
    emit("success", "操作成功")
    emit("close")
  // }
  // console.log(data);

}



const emit = defineEmits(["close", "success"])

function close() {
  emit("close")
}


</script>

<style scoped>

</style>