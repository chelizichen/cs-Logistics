<template>
  <el-dialog v-model="props.dialogFormVisible" title="更新仓库" @closed="close">
    <el-form :model="props.val">

      <el-form-item label="地址" :label-width="formLabelWidth">
        <el-input v-model="props.val.location" autocomplete="off" />
      </el-form-item>
      <el-form-item label="仓库名称" :label-width="formLabelWidth">
        <el-input v-model="props.val.name" autocomplete="off" />
      </el-form-item>
      <el-form-item label="负责人电话" :label-width="formLabelWidth">
        <el-input v-model="props.val.phone" autocomplete="off" />
      </el-form-item>
      <el-form-item label="工作时间" :label-width="formLabelWidth">
        <el-input v-model="props.val.workTime" autocomplete="off" />
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="close">取消</el-button>
        <el-button type="primary" @click="submit">
          提交
        </el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import { reactive, ref, watch } from 'vue'
import {updateHouse,createHouse} from '../../../api/house'
const props = defineProps<{
  dialogFormVisible: boolean,
  val: Partial<house_table>
}>()


const formLabelWidth = '140px'

async function submit() {
  if(props.val.id){
    const data = await updateHouse(props.val.id, props.val)
    console.log(data);
    
  }else{
    const data = await createHouse(props.val)
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