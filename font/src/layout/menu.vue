<style scoped>
.wlgl{
  display: flex;
  align-items: center;
  justify-content: center;
  height: 40px;
  background-color: #f0f0f3;
  font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}
.tac{
  width: 200px;
  overflow: hidden;
}
.tac >>> .el-sub-menu__title{
display: flex;
align-items: center;
justify-content: center;
/* width: 200px; */
}
.tac >>>.el-menu-item{
  display: flex;
align-items: center;
justify-content: center;
/* width: 200px; */
}
.el-menu{
  height: 1000px;
}
</style>

<template>
  <el-row class="tac">
    <el-col>
      <div class="wlgl">物流信息管理平台</div>
      <el-menu default-active="2" 
      class="el-menu-vertical-demo"     
      background-color="#2d3a4b"
      text-color="#fff"
      active-text-color="#ffd04b"
      >
        <el-sub-menu index="1">
          <template #title>
            <span>系统管理</span>
          </template>
          <el-menu-item index="1-1" @click="to('/system/user')"> 用户管理</el-menu-item>
        </el-sub-menu>
        <el-sub-menu index="2">
          <template #title>
            <span>订单管理</span>
          </template>
          <el-menu-item index="2-1" @click="to('/order/list')"> 订单列表</el-menu-item>
          <el-menu-item index="2-2" @click="to('/order/analyze')"> 数据统计</el-menu-item>
          <el-menu-item index="2-3" @click="to('/back/list')"> 退换货列表</el-menu-item>
        </el-sub-menu>
        <el-sub-menu index="3">
          <template #title>

            <span>仓库管理</span>
          </template>
          <el-menu-item index="3-1" @click="to('/warehouse/list')"> 仓储列表</el-menu-item>
          <el-menu-item index="3-2" @click="to('/house/list')"> 仓库列表</el-menu-item>
        </el-sub-menu>
        <el-sub-menu index="4">
          <template #title>
            <span>物流管理</span>
          </template>
          <el-menu-item index="3-3" @click="to('/logistics/list')"> 物流列表</el-menu-item>
        </el-sub-menu>
        <el-sub-menu index="5">
          <template #title>
            <span>投诉管理</span>
          </template>
          <el-menu-item index="5-1" @click="to('/complaint/list')"> 投诉列表</el-menu-item>
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

function to(path: string) {
  router.push(path)
}

</script>