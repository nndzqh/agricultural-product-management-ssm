<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/6/26
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
</head>
<body>
<div class="content">
    <form action="${pageContext.request.contextPath}/category/add" method="post" style="display: flex;flex-direction: column;">
        <div class="si">
            <span>请输入产品分类名称</span>
            <input type="text" name="name">
        </div>
        <div class="si">
            <span>排序</span>
            <input class="click" type="text" name="sort" />
        </div>

        <!-- 分类下拉框 -->
        <button id="btn" type="submit">提交</button>
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
        width: 270px;
        border-radius: 20px;
        height: 30px;
        margin-top: 10px;
    }

    .si {
        display: flex;
        align-items: center;
    }

    span {
        width: 200px;
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

