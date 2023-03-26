<template>
    <div>
      <el-container>
        <el-header>
          <div>头部</div>
        </el-header>
        <el-container>
          <el-aside>
            <Menu></Menu>
          </el-aside>
          <el-main>
            <RouterView></RouterView>
          </el-main>
        </el-container>
        <el-footer>Footer</el-footer>
      </el-container>
    </div>
  </template>
  
  <script setup lang="ts">
  import { ElContainer, ElHeader, ElAside, ElMain, ElFooter } from 'element-plus';
import { RouterView } from 'vue-router';
  import Menu from './menu.vue'
  </script>