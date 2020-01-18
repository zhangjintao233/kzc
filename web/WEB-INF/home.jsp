<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/15
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="errorpage.jsp" %>
<html>
<head>
    <title>后台首页</title>
    <style>
        body{
            margin: 0;
        }
        a{
            text-decoration: none;
        }
        #left{
            width: 18%;
            height: 100%;
            position: relative;
            float: left;
            border: 1px #EEEEEE solid;
        }
        #div4{
            position: absolute;
            left: 20px;
        }
        #div4-2{
            position: absolute;
            left: 20px;
            top: 60px;
        }
        #left a{
            color: #969696;
        }

        #top{
            height: 60px;
            width: 100%;
            float: top;
            border: 1px #EEEEEE solid;
            position: relative;
        }
        #top h2{
            height: 100%;
            width: 280px;
            margin: 0;
            border-right: 1px #EEEEEE solid;
        }
        #top h2 a{
            position: absolute;
            top: 12px;
            left: 50px;
            color: #333333;
        }
        #input3{
            height: 28px;
            width: 220px;
            margin-left: 100px;
            padding-left: 5px;
            border: 1px #CCCCCC solid;
        }
        #input4{
            height: 28px;
            width: 70px;
            position: absolute;
            border: none;
            background-color: #3385FF;
            color: white;
        }
        #form2{
            position: absolute;
            top: 14px;
            left: 250px;
        }

        #right {
            width: 82%;
            float: right;
            background-color: aqua;
        }

        

        
    </style>
</head>
<body>
<div>
    <div id="top">
        <h2><a href="/backed/index/home">后台管理首页</a></h2>

        <form action="" id="form2">
            <input type="text" placeholder="输入你要物品的查询的名字" id="input3">
            <input type="submit" value="搜索一下" id="input4">
        </form>
    </div>
    <div id="left">
        <div id="div4">
            <h4>欢迎${users.username}登录管理后台</h4>
        </div>
        <div id="div4-2">
            <a href="/backed/product/getall">获取所以商品的数据</a>
        </div>
    </div>
    <div id="right">

    </div>
</div>


</body>
</html>
