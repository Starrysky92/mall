<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/30 0030
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.css"/>
    <script src="js/jquery.js"></script>
    <script type="text/javascript" src="js/easyui.js"></script>
    <link rel="stylesheet" href="css/icon.css"/>
    <link rel="stylesheet" href="css/easyui.css"/>
    <script>
        function deletecart(id) {
            $.get("deletecart.do",{id:id},function (b) {
                location.reload(true)
            })
        }
        function addnum(b){
                var num = $("#"+b).val();
                $("#"+b).val(parseInt(num) + 1);
                $.get("addnum.do", {id: b, num: $("#"+b).val()}, function () {
                    location.reload(true)
                })
        }
        function lessnum(b) {
                var num = $("#"+b).val();
                if(num<=1){
                    $.messager.alert("系统提示","不能再减了")
                    return;
                }
                $("#"+b).val(parseInt(num)-1);
                $.get("lessnum.do",{id:b,num:$("#"+b).val()},function () {
                    location.reload(true)
            })
        }
        function MouseOver(c) {
            var num = $("#"+c).val();
            $.get("addnum.do", {id: c, num: num}, function () {
                location.reload(true)
            })
        }

    </script>
</head>
<body>
<h1>购物车的商品</h1>
<ul class="list-group">
    <c:forEach items="${cart.show()}" var="itme">
        <li class="list-group-item">
            <span style="display: none" id="id">${itme.id}</span>
            <span>
                ${itme.name}
            </span>&nbsp;&nbsp;
            <span>
                ${itme.price}
            </span>&nbsp;&nbsp;
            <a onclick="lessnum('${itme.id}')" class="btn btn-default" type="button">-</a>&nbsp;&nbsp;
            <input id="${itme.id}" value="${itme.num}" style="width: 30px" onblur="MouseOver('${itme.id}')"></input>&nbsp;&nbsp;
            <a onclick="addnum('${itme.id}')" class="btn btn-default" type="button">+</a>&nbsp;&nbsp;
            <span>
                <a href="javascript:deletecart('${itme.id}')" class="btn btn-danger">删除</a>
            </span>
        </li>
    </c:forEach>
    <li class="list-group-item">
        总价:${cart.total()}
    </li>
</ul>
</body>
</html>
