import { createRouter, createWebHistory } from 'vue-router';
import Home from '../views/Home.vue';
import User from '../views/system/user/index.vue';
import Permission from '../views/system/permission/index.vue';
import OrderList from '../views/order/list/list.vue';
import Login from '../views/Login.vue'
import Admin from '../views/Admin.vue'
import Mobile from '../views/mobile/index.vue'

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
    ]
  },

];

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router