import { createRouter, createWebHistory } from 'vue-router';
import Home from '../views/Home.vue';
import User from '../views/system/user/index.vue';
import Permission from '../views/system/permission/index.vue';
import OrderList from '../views/order/list/list.vue';

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
  },
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
    path: '/',
    name: 'Home',
    component: Home,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router