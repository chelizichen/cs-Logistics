<template>
  <el-dialog v-model="props.dialogFormVisible" title="更新物流" @closed="close">
    <el-form :model="props.val">

      <el-form-item label="物流公司" :label-width="formLabelWidth">
        <el-input v-model="props.val.logisticsCompany" autocomplete="off" />
      </el-form-item>
      <el-form-item label="物流状态" :label-width="formLabelWidth">
        <el-select v-model="props.val.logisticsStatus" class="m-2" placeholder="选择物流状态" size="large">
          <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="物流更新时间" :label-width="formLabelWidth" >
        <el-input v-model="props.val.logisticsTime" autocomplete="off" :disabled="true"/>
      </el-form-item>

      <el-form-item label="订单ID" :label-width="formLabelWidth">
        <el-input v-model="props.val.orderId" autocomplete="off" :disabled="true" />
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
import { createLogistics, updateLogistics } from '../../api/logistics';

const options = [

  {
    label:"待发货",
    value:"1"
  },
  {
    label:"运输中",
    value:"2"
  },
  {
    label:"运输完成",
    value:"3"
  },
  
]

const props = defineProps<{
  dialogFormVisible: boolean,
  val: Partial<logistics_table>
}>()


const formLabelWidth = '140px'

async function submit() {
  if(props.val.id){
    const data = await updateLogistics(props.val.id, props.val)
    console.log(data);
    
  }else{
    const data = await createLogistics(props.val)
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