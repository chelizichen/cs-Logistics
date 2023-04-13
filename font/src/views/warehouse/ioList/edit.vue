<template>
  <el-dialog v-model="props.dialogFormVisible" title="更新物流" @closed="close">
    <el-form :model="props.val">
      <el-form-item label="地址" :label-width="formLabelWidth">
        <el-input v-model="props.val.address" autocomplete="off" />
      </el-form-item>
      <el-form-item v-if="isAdd" label="入库时间" :label-width="formLabelWidth">
        <el-input v-model="props.val.inTime" autocomplete="off" />
      </el-form-item>
      <el-form-item v-if="!isAdd" label="出库时间" :label-width="formLabelWidth">
        <el-input v-model="props.val.outTime" autocomplete="off" />
      </el-form-item>
      <el-form-item label="订单ID" :label-width="formLabelWidth">
        <el-input v-model="props.val.orderId" autocomplete="off" />
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
import { computed, reactive, ref, watch } from 'vue'
import { createUser, updateUser } from '../../../api/user';
import { createWarehouse, updateWarehouse } from '../../../api/warehouse';

const props = defineProps<{
  dialogFormVisible: boolean,
  val: Partial<warehouse_table>
}>()


const formLabelWidth = '140px'

async function submit() {
  if(props.val.id){
    const data = await updateWarehouse(props.val.id, props.val)
    console.log(data);
    
  }else{
    const data = await createWarehouse(props.val)
    console.log(data);
  }
  // @ts-ignore
  // if (data.code == 0) {
    emit("success", "操作成功")
    emit("close")
  // }
  // console.log(data);

}

const isAdd = computed(()=>props.val.id?false:true)

const emit = defineEmits(["close", "success"])

function close() {
  emit("close")
}


</script>

<style scoped>

</style>