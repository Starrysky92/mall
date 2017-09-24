<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/28 0028
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/icon.css"/>
    <link rel="stylesheet" href="css/easyui.css"/>
    <link rel="stylesheet" href="css/bootstrap.css"/>
    <script src="js/jquery.js"></script>
    <script type="text/javascript" src="js/easyui.js"></script>
    <script type="text/javascript" src="ckeditor/ckeditor.js"></script>
</head>
<body>
<div style="margin-bottom: 20px">
    <input name="categoryid" class="easyui-combotree" style="width: 100%;height: 30px;" data-options="url:'findAllCategory2.do',promt:'请选择类别'"/>
</div>
</body>
</html>
