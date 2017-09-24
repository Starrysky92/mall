<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
        <script>
        var map;
        function show(data) {
             map=new BMap.Map("first");
            var point=new BMap.Point(116.404, 39.915);
            if(data){
                point=new BMap.Point(data.point.lng,data.point.lat)
            }
            map.centerAndZoom(point,13);
        }
        function dw() {
            var l=new BMap.Geolocation();
            l.getCurrentPosition(function (data) {
                show(data);
                address(data)
            })
        }
        function address(data) {
            var c=new BMap.Geocoder();
            var p=new BMap.Point(data.point.lng,data.point.lat);
            c.getLocation(p,function (d) {
                alert(d.address)
            })
        }
        function search() {
            var sh=new BMap.LocalSearch(map,{
                renderOptions:{map:map,autoViewport:true},
            });
            sh.searchNearby("川菜","纬五路");
        }
        function nav() {
            var v=new BMap.WalkingRoute(map,{
                renderOptions:{map:map,autoViewport:true}
            });
            v.search("火车站","河南教育学院")
        }
    </script>
</head>
<body>
<div id="first" style="width: 500px;height: 500px"></div>
    <button onclick="show()">显示</button>
    <button onclick="dw()">定位</button>
<button onclick="search()">搜索</button>
<button onclick="nav()">导航</button>
</body>
</html>
