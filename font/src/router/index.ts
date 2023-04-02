import { createRouter, createWebHistory } from 'vue-router';
import Home from '../views/Home.vue';
import User from '../views/system/user/index.vue';
import Permission from '../views/system/permission/index.vue';
import OrderList from '../views/order/list/list.vue';
import HouseList from '../views/warehouse/house/index.vue';
import WareHouseList from '../views/warehouse/ioList/index.vue';

import Login from '../views/Login.vue'
import Admin from '../views/Admin.vue'
import Mobile from '../views/mobile/index.vue'
import DetailLogisitics from '../views/mobile/detail.vue';

const routes = [
  {
    path: '/home',
    name: 'Home',
    component: Home,
  },
  {
    path:"/login",
    name:"Login",
    component:Login
  },
  {
    path:"/mobile",
    name:"Mobile",
    component:Mobile
  },
  {
    path:"/detail/logisitics",
    name:"DetailLogisitics",
    component:DetailLogisitics
  },
  {
    path:"/admin",
    name:"Admin",
    component:Admin,
    children:[
      {
        path: '/system/user',
        name: 'User',
        component: User,
      },
      {
        path: '/system/permission',
        name: 'Permission',
        component: Permission,
      },
      {
        path: '/order/list',
        name: 'OrderList',
        component: OrderList,
      },
      {
        path: '/house/list',
        name: 'HouseList',
        component: HouseList,
      },
      {
        path:"/warehouse/list",
        name:"WarehouseList",
        component:WareHouseList
      }
    ]
  },

];

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router