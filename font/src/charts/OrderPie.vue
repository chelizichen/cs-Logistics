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
  isDraw:boolean
}>()

watch(props, (val) => {
  if (val.isDraw) { 
    drawChart()
  }
})

function drawChart() {
  const chart = echarts.init(chartRef.value);
  let back = {value:props.backTotal, name:"退货"}
  let finish = { value: props.total - props.backTotal, name: "完成" }
  chart.setOption({
    title: {
      text: `物流订单统计（总数：${props.total}）`
    },
    tooltip: {
      trigger: 'item',
      formatter: '{a} <br/>{b}: {c} ({d}%)'
    },
    legend: {
      orient: 'vertical',
      left: 10,
      top: 50,
      data: ['退货','完成']
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
        data:[back,finish]
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
