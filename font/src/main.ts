import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import ElementPlus from "element-plus";
import router from "./router/index"
createApp(App).use(ElementPlus).use(router).mount('#app')
