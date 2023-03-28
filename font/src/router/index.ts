import { createRouter, createWebHistory } from 'vue-router';
import Home from '../views/Home.vue';
import User from '../views/system/user/index.vue';
import Permission from '../views/system/permission/index.vue';

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
    path: '/',
    name: 'Home',
    component: Home,
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