<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/15
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="errorpage.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>商品列表</title>
    <style>
        #left {
            width: 15%;
            height: 100%;
            float: left;
            background-color: red;
        }

        #right {
            width: 85%;
            float: right;
            background-color: aqua;
        }

        #top{
            height: 60px;
            width: 85%;
            float: right;
            background-color: chartreuse;
        }

        #input3{
            margin-top: 20px;
            margin-left: 100px;
            padding-left: 5px;
        }
    </style>

</head>
<body>
<div id="top">
    <form action="/backed/product/select" method="get">
        <input type="text" placeholder="输入你要物品的查询的名字" id="input3" name="name">
        <input type="submit" value="搜索">
    </form>
</div>
<div id="left">
    <p>
        <a href="/backed/index/home">回到首页</a>
    </p>
    <h1>欢迎${users.username}管理员登录管理后台</h1>
    <a href="/backed/product/getall">获取所以商品的数据</a>
</div>
<div id="right">
    <c:if test="${not empty plist.data}">
        <table>
            <tr>
                <th>序号</th>
                <th>商品名称</th>
                <th>商品单价</th>
                <th>商品数量</th>
                <th>商品在售</th>
                <th>商品创建时间</th>
                <th>商品更新时间</th>
            </tr>
            <c:forEach items="${plist.data}" var="p">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.pname}</td>
                    <td>${p.price}</td>
                    <td>${p.pnum}</td>
                    <td class="pt">${p.type}</td>
                    <td>${p.create_time}</td>
                    <td>${p.update_time}</td>
                    <td>
                        <button onclick="toType(this)">下架</button>
                        <button>修改</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <c:if test="${empty plist.data}">
        没有更多的商品
    </c:if>
</div>
</body>
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<script>
    function toType(sut) {
        var id2 = $(sut).parent().parent().children().first().text();
        $.get(
            "/backed/product/totype",
            {id: id2},
            function (data) {
                var unm = Number(data);
                if (data > 0) {
                    $(sut).parent().parent().children().first().nextAll(".pt").text(1);
                }
            }
        )
    }
</script>
</html>
