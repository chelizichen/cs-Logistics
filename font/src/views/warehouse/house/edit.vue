<template>
  <el-dialog v-model="props.dialogFormVisible" title="Shipping address" @closed="close">
    <el-form :model="props.val">

      <el-form-item label="地址" :label-width="formLabelWidth">
        <el-input v-model="props.val.address" autocomplete="off" />
      </el-form-item>
      <el-form-item label="邮箱" :label-width="formLabelWidth">
        <el-input v-model="props.val.email" autocomplete="off" />
      </el-form-item>
      <el-form-item label="名字" :label-width="formLabelWidth">
        <el-input v-model="props.val.name" autocomplete="off" />
      </el-form-item>
      <el-form-item label="密码" :label-width="formLabelWidth">
        <el-input v-model="props.val.password" autocomplete="off" />
      </el-form-item>
      <el-form-item label="权限" :label-width="formLabelWidth">
        <el-input v-model="props.val.permissions" autocomplete="off" />
      </el-form-item>
      <el-form-item label="电话" :label-width="formLabelWidth">
        <el-input v-model="props.val.phoneNumber" autocomplete="off" />
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

const props = defineProps<{
  dialogFormVisible: boolean,
  val: Partial<user_table>
}>()


const formLabelWidth = '140px'

async function submit() {
  if(props.val.id){
    const data = await updateUser(props.val.id, props.val)
    console.log(data);
    
  }else{
    const data = await createUser(props.val)
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