<template>
  <div ref="chartRef" style="height:400px;width:500px"></div>
</template>

<script setup lang="ts">
import { onMounted, ref, watch } from 'vue';
import * as echarts from 'echarts';

const chartRef = ref<any>(null);

const props = defineProps<{
  total: number,
  backTotal: number,
  isDraw: boolean
}>()

watch(props, (val) => {
  if (val.isDraw) {
    drawChart()
  }
})

function drawChart() {
  const chart = echarts.init(chartRef.value);
  let back = { value: props.backTotal, name: "退货" }
  let total = { value: props.total, name: "总数" }
  let rate =(props.backTotal / props.total).toFixed(2)
  chart.setOption({
    title: {
      text: '退换率（'+rate+"%）"
    },
    tooltip: {
      trigger: 'item',
      formatter: '{a} <br/>{b}: {c} ({d}%)'
    },
    legend: {
      orient: 'vertical',
      left: 10,
      top: 50,
      data: ['退货', '总数']
    },
    series: [
      {
        name: 'Categories',
        type: 'pie',
        radius: ['50%', '70%'],
        avoidLabelOverlap: false,
        label: {
          show: false,
          position: 'center'
        },
        emphasis: {
          label: {
            show: true,
            fontSize: '30',
            fontWeight: 'bold'
          }
        },
        labelLine: {
          show: false
        },
        data: [back, total]
      }
    ] as any
  });
}

onMounted(() => {
  if (props.isDraw) {
    drawChart()
  }
})

</script>
