<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=d1WvUU6wLDbHkLNDDWGrvABVGrEWqa14"></script>
    <script src="js/echarts.js"></script>
    <script src="js/bmap.js"></script>
    <script>
        function show() {
            var chart=echarts.init(document.getElementById("first"));
            var option={
                tooltip:{
                  trigger:"item",
                  formatter:"{b}<br/>{c}"
                },
                bmap:{
                    center:[113.65,34.76],
                    zoom:5,
                    roam:true
                },
                series:[{
                    type:"effectScatter",
                    coordinateSystem:"bmap",
                    data:[
                        {name:"郑州",value:[113.65,34.76,300]}
                    ]
                }]
            }
            chart.setOption(option)
        }
        function qx() {
            var planePath = 'path://M1705.06,1318.313v-89.254l-319.9-221.799l0.073-208.063c0.521-84.662-26.629-121.796-63.961-121.491c-37.332-0.305-64.482,36.829-63.961,121.491l0.073,208.063l-319.9,221.799v89.254l330.343-157.288l12.238,241.308l-134.449,92.931l0.531,42.034l175.125-42.917l175.125,42.917l0.531-42.034l-134.449-92.931l12.238-241.308L1705.06,1318.313z';
            var chart=echarts.init(document.getElementById("first"));
            var color = ['#a6c84c', '#ffa022', '#46bee9'];
            var option={
                tooltip:{
                    trigger:"item",
                    formatter:"{b}<br/>{c}"
                },
                bmap:{
                    center:[113.65,34.76],
                    zoom:5,
                    roam:true
                },
                series:[{
                    type:"lines",
                    coordinateSystem:"bmap",
                    zlevel: 2,
                    symbol: ['none', 'arrow'],
                    symbolSize: 10,
                    symbol: planePath,
                    effect: {
                        show: true,
                        period: 6,
                        trailLength: 0,
                        symbol: planePath,
                        symbolSize: 15
                    },
                    lineStyle: {
                        normal: {
                            color: color[0],
                            width: 1,
                            opacity: 0.6,
                            curveness: 0.2
                        }
                    },
                    data:[
                        {fromName:"北京",toName:"上海",coords:[[116.4551,40.2539],[121.4648,31.2891]]},
                        {fromName:"北京",toName:"东莞",coords:[[116.4551,40.2539],[113.8953,22.901]]},
                        {fromName:"北京",toName:"乌鲁木齐",coords:[[116.4551,40.2539],[87.9236,43.5883]]},
                        {fromName:"北京",toName:"长春",coords:[[116.4551,40.2539],[125.8154,44.2584]]},
                        {fromName:"北京",toName:"厦门",coords:[[116.4551,40.2539],[118.1689,24.6478]]},
                        {fromName:"北京",toName:"拉萨",coords:[[116.4551,40.2539],[91.1865,30.1465]]},
                        {fromName:"北京",toName:"武汉",coords:[[116.4551,40.2539],[114.3896,30.6628]]},
                        {fromName:"北京",toName:"呼和浩特",coords:[[116.4551,40.2539],[111.4124,40.4901]]},
                        {fromName:"北京",toName:"合肥",coords:[[116.4551,40.2539],[117.29,32.0581]]},
                    ]
                }]
            }
            chart.setOption(option)
        }
    </script>
</head>
<body>
<div id="first" style="width: 95%;height: 95%"></div>
<button onclick="show()">显示</button>
<button onclick="qx()">迁徙</button>
</body>
</html>
