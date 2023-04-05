<template>
  <div>
    <div class="pies">
        <OrderPie :is-draw="state.draw" :total="500" :back-total="100"></OrderPie>
        <BackAnalyze :is-draw="state.draw" :total="500" :back-total="100"></BackAnalyze>
    </div>
  </div>
</template>

<script setup lang="ts">
import BackAnalyze from '../../charts/BackAnalyze.vue';
import OrderPie from '../../charts/OrderPie.vue'
import { reactive } from 'vue'

const state = reactive({
  draw:true
})

</script>

<style scoped>
.pies{
  display: flex;
  align-items: center;
  justify-content: space-between;
}
</style>