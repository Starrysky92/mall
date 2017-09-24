<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/30 0030
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.css"/>
</head>
<body>
<div style="margin: 100px 100px;width: 80%">
<ul class="list-group">
<c:forEach items="${commos}" var="commo">
   <li class="list-group-item">
        <span>
            ${commo.name}
        </span>&nbsp;&nbsp;
        <span>
            ${commo.price}
        </span>&nbsp;&nbsp;
        <a href="addcart.do?id=${commo.id}" class="btn btn-danger">购买</a>
   </li>
</c:forEach>
</ul>
</div>
</body>
</html>
