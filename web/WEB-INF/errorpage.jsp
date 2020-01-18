<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/16
  Time: 8:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>系统出错了!</title>
    <style>
        #left{
            width: 15%;
            height: 100%;
            float: left;
            background-color: red;
        }

        #right{
            width: 85%;
            float: right;
            background-color: aqua;
        }
    </style>
</head>
<body>

<div id="left">
    <p>
        <a href="/backed/index/home">回到首页</a>
    </p>
    <h1>欢迎${users.username}管理员登录管理后台</h1>
    <a href="/backed/product/getall">获取所以商品的数据</a>
</div>
<div id="right">
    <h1>系统出错了!请联系系统管理员。</h1>
</div>

</body>
</html>
