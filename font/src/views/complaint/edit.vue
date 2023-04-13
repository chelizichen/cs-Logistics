<template>
  <el-dialog v-model="props.dialogFormVisible" title="Shipping address" @closed="close">
    <el-form :model="props.val">

      <el-form-item label="地址" :label-width="formLabelWidth">
        <el-input v-model="props.val.status" autocomplete="off" />
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
import { update } from '../../api/complaint';

const props = defineProps<{
  dialogFormVisible: boolean,
  val: Partial<complaint_table>
}>()


const formLabelWidth = '140px'

async function submit() {
    const data = await update(props.val)
    emit("success", "操作成功")
    emit("close")

}

const emit = defineEmits(["close", "success"])

function close() {
  emit("close")
}


</script>

<style scoped>

</style>