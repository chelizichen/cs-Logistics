<template>
  <div>
    <el-container>
      <el-container>
        <el-aside style="width: 200px;">
          <Menu></Menu>
        </el-aside>
        <el-main>
          <RouterView></RouterView>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>
  
<script setup lang="ts">
import { ElContainer, ElHeader, ElAside, ElMain, ElFooter } from 'element-plus';
import { RouterView } from 'vue-router';
import Menu from './menu.vue'
</script>