<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/16
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="errorpage.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            margin: 0;
        }

        a{
            text-decoration: none;
        }

        #div2 {
            height: 100%;
            width: 100%;
            background-color: black;
            display: flex;

        }
        #div3{
            height: 350px;
            width: 400px;
            background-color: #D6D6D6;
            position: relative;
            margin: auto;
            border-radius: 4px;
            opacity: 0.9;
        }
        #h{
            padding-top: 14px;
            padding-left: 124px;
            padding-bottom: 6px;
        }

        #div3-2{
            padding-left: 50px;
        }

        #input2 {
            height: 36px;
            width: 300px;
            padding-left: 6px;
            margin-bottom: 18px;
            border: none;
            border-radius: 2px;
            color: #B3B3B3;
        }

        #input3{
            height: 36px;
            width: 300px;
            padding-left: 6px;
            margin-bottom: 4px;
            border: none;
            border-radius: 2px;
            color: #B3B3B3;
        }

        #div3-3{
            padding-top: 30px;
            padding-left: 50px;
            padding-bottom: 30px;
        }


        #input4{
            height: 36px;
            width: 300px;
            border: none;
            background-color: #32BAF1;
            border-radius: 4px;
            color: white;
        }

        #a2{
            color: #838383;
        }

        #span2{
            display: none;
        }

    </style>
</head>
<body>

<div id="div2">
    <div id="div3">
        <div id="h">
            <h2>后台管理中心</h2>
        </div>
        <form action="/backed/user/zhuce" method="post">
            <div id="div3-2">
                <input type="text" placeholder="注册账号" name="username" id="input2">
                <input type="password" placeholder="注册密码" name="password" id="input3">
                <div id="div3-4">
                    <a href="/backed/user/index" id="a2">返回登录</a>
                    <span id="span2">${msg}</span>
                </div>
            </div>
            <div id="div3-3">
                <input  type="submit" value="注册" id="input4" onclick="">
            </div>
        </form>
    </div>
</div>
</body>
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<script>
    $("#input4").click(function () {
        $("#span2").show();
    });
</script>


</html>
