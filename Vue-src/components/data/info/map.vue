<template>
    <div class="map">
        <div id="chinaMap" style="width: 71vw;height: 54.5vh;"></div>
    </div>
</template>

<script>
export default {
    name: 'map',
    props: {
        num: 0
    },
    methods: {
        drawLine(){
            var myChart = echarts.init(document.getElementById("chinaMap"));
            /**
             *  指定图表的配置项和数据
             * */
            var option= {
                backgroundColor: '#fff',  //设置背景颜色
                title: {
                    show:true,
                    text: '中国地图',
                    subtext: '',
                    x:'center'
                },
                tooltip : {
                    trigger: 'item'
                },
                //左侧小导航图标
                visualMap: {
                    show : true,
                    x: 'left',
                    y: 'bottom',
                    splitList: [
                        {start: 10, end:20},
                        {start: 6, end: 10},
                        {start: 0, end: 6},
                    ],
                    color: ['#a5ad00', '#8bdd00', '#2cd493']
                },
                //配置属性
                series: [{
                    name: '数量',
                    type: 'map',
                    mapType: 'china',
                    roam: false,
                    zoom:1.2,
                    label: {
                        normal: {
                            show: false ,
                        },
                        emphasis: {
                            show: false
                        }
                    },
                    data:[{name: '广东',value:this.num }]
                }]
            };
            myChart.setOption(option);
                }
            },
            mounted() {
                this.drawLine();
                
        },
}
</script>

<style scoped>
.map{
    width: 100%;
    height: 100%;
    overflow: hidden;
}
</style>