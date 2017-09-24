<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
    <script src="js/echarts.js"></script>
    <script src="js/china.js"></script>
    <script>
      function bar() {
          var chart=echarts.init(document.getElementById("first"));
          var option={
              xAxis:{
                  data:["上海","北京","郑州"]
              },
              yAxis:{},
              series:{
                  type:"bar",
                  data:[10000,11000,5000]
              }
          };
          chart.setOption(option);
      }
      function pie() {
          var chart=echarts.init(document.getElementById("first"));
          var option={
              tooltip:{
                trigger:"item",
                  formatter:"{b}<br/>{c}"
              },
              series:{
                  type:"pie",
                  data:[
                      {name:"郑州",value:1000},
                      {name:"开封",value:200}
                      ]
              }
          }
          chart.setOption(option)
      }
      function map() {
          var chart=echarts.init(document.getElementById("first"));
          var option={
              tooltip:{
                  trigger:"item",
                  formatter:"{b}"
              },
              series:[{
                  type:"map",
                  mapType:"china"
              }]
          }
          chart.setOption(option)
      }
      function use() {

          var chart=echarts.init(document.getElementById("first"));
          var option={
              tooltip:{
                  trigger:"item",
                  formatter:"{b}"
              },
              geo: {
                  map: 'china',
                  label: {
                      emphasis: {
                          show: false
                      }
                  }
              },
              series:[{
                  type:"scatter",
                  coordinateSystem: 'geo',
                  data: [
                      {name:"郑州",value:[113.65,34.76,300]},
                  ]
              }]
          }
        chart.setOption(option)
      }
    </script>
  </head>
  <body>
  <div id="first" style="width: 500px;height: 300px"></div>
  <button onclick="bar()">柱状图</button>
  <button onclick="pie()">饼状图</button>
  <button onclick="map()">地图</button>
  <button onclick="use()">使用地图</button>
  </body>
</html>
