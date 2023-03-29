<template>
    <el-row class="tac">
      <el-col>
        <h5 class="mb-2">物流信息管理平台</h5>
        <el-menu
          default-active="2"
          class="el-menu-vertical-demo"
        >
          <el-sub-menu index="1">
            <template #title>
              <el-icon><location /></el-icon>
              <span>系统管理</span>
            </template>
              <el-menu-item index="1-1" @click="to('/system/user')"> <el-icon><location /></el-icon>用户管理</el-menu-item>
              <el-menu-item index="1-2" @click="to('/system/permission')"> <el-icon><location /></el-icon>权限管理</el-menu-item>
          </el-sub-menu>
          <el-sub-menu index="2">
            <template #title>
              <el-icon><location /></el-icon>
              <span>订单管理</span>
            </template>
              <el-menu-item index="2-1" @click="to('/order/list')"> <el-icon><location /></el-icon>订单列表</el-menu-item>
              <el-menu-item index="2-2"> <el-icon><location /></el-icon>数据统计</el-menu-item>
              <el-menu-item index="2-3"> <el-icon><location /></el-icon>退换货列表</el-menu-item>
          </el-sub-menu>
          <el-sub-menu index="3">
            <template #title>
              <el-icon><location /></el-icon>
              <span>仓库管理</span>
            </template>
              <el-menu-item index="3-1"> <el-icon><location /></el-icon>商品列表</el-menu-item>
              <el-menu-item index="3-3"> <el-icon><location /></el-icon>仓库列表</el-menu-item>
              <el-menu-item index="3-2"> <el-icon><location /></el-icon>库存统计</el-menu-item>
          </el-sub-menu>
        </el-menu>
      </el-col>
    </el-row>
  </template>
  
  <script lang="ts" setup>
  import {
    Document,
    Menu as IconMenu,
    Location,
    Setting,
  } from '@element-plus/icons-vue'
import { useRouter } from 'vue-router';

const router = useRouter()

function to(path:string){
  router.push(path)
}

  </script>