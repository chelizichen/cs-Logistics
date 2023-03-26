<script setup lang="ts">
import { onMounted } from 'vue';
import Layout from './layout/layout.vue';
import { getAllUsers } from './api/user';


onMounted(async()=>{
  const data = await getAllUsers();
  console.log(data);
})
</script>

<template>
  <Layout></Layout>
</template>

<style scoped>

</style>
