<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/6/26
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
</head>
<body>
<div class="content">
    <form action="${pageContext.request.contextPath}/stock/update" method="post" style="display: flex;flex-direction: column;">
        <input type="hidden" value="${stockVo.id}" name="id">
        <div class="si">
            <span>产品名称</span>
            <span> ${stockVo.name}</span>
<%--            <input type="text" name="name" value="$">--%>
        </div>
        <div class="si">
            <span>库存数量</span>
            <input class="click" type="text" name="sum" value="${stockVo.sum}"/>
        </div>
        <button id="btn" tyle="submit">提交</button>
    </form>
</div>
</body>
<style>

    body {
        display: flex;
        text-align: center;
        width: 100%;
        align-items: center;
    }

    .content {
        background-color: #eee;
        border-radius: 20px;
        padding: 20px;
        width: 350px;
        margin: 200px auto;
    }

    input {
        width: 200px;
        border-radius: 20px;
        height: 30px;
        margin-top: 10px;
    }

    .si {
        display: flex;
        align-items: center;
    }

    span {
        width: 130px;
    }

    #btn {
        width: 340px;
        margin-top: 20px;
        height: 30px;
        border: none;
        border-radius: 30px;
        background-color: cornflowerblue;
        color: #fff;
    }
</style>
</html>
