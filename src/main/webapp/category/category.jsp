<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/6/26
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="./static/css/style.css">
</head>
<body>
<!--顶部信息区-->
<div class="header">
    <div>
        <h1>农产品后台管理系统</h1>
    </div>
</div>
<div class="main">
    <!--主体-->
    <div class="content">
        <div class="content_header">
            <input class="content_input" placeholder="请输入农产品名称" type="text" style="">
            <button class="content_button">查 询</button>
            <button class="content_button">添加农产品分类</button>
        </div>
        <div class="content_table">
            <table border="1">
                <tr>
                    <th>分类名称</th>
                    <th>创建时间</th>
                    <th>修改时间</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="categorylist" var="category">
                <tr>
                    <td>农产品分类</td>
                    <td>2022.3.6 6:55</td>
                    <td>2022.3.6 12:00</td>
                    <td>
                        <button class="content_button">删 除</button>
                        <button class="content_button">修 改</button>
                    </td>
                </tr>
                </c:forEach>
            </table>
        </div>
        <!-- 分页 -->
        <form action="demoServlet">
            <table>
                <tr>
                    <c:forEach items="${requestScope.pages}" var="pages" varStatus="s">
                        <td>
                            <button type="submit" name="currentPage" value="${pages}">
                                    ${pages}
                            </button>
                        </td>
                    </c:forEach>
                </tr>
            </table>
        </form>
    </div>
    <!--左侧导航区-->
    <div class="aside">
        <div class="nav">
            <ul>
                <li><a href="setting.html" target="main" >农产品管理</a></li>
                <li><a href="user.html" target="main" class="active">农产品分类管理</a></li>
                <li><a href="article.html" target="main">库存管理</a></li>
                <li><a href="category.html" target="main">订单管理</a></li>
            </ul>
        </div>
    </div>
    </main>
</div>
<script src="http://code.jquery.com/jquery-1.4.1.js"></script>
<script type="text/javascript">

</script>
<style>
    * {
        margin: 0px;
        padding: 0px;
    }

    body {
        background-color: #fff;
    }

    li {
        list-style-type: none;
    }

    a {
        color: #000;
    }

    a:hover {
        color: brown;
    }

    .header {
        background:rgb(9, 159, 247);
        overflow: hidden;
        height: 80px;
        /* border-bottom-left-radius: 20px;
        border-bottom-right-radius: 20px; */
    }

    .header div {
        width: 100%;
        height: 60px;
    }
    .header h1 {
        color: #fff;
        float: left;
        font-weight: normal;
        line-height: 80px;
        padding-left: 20px;
        letter-spacing: 3px;

    }

    /*侧边导航栏*/
    .main {
        width: 80%;
        height: 800px;
        margin: 30px auto 0;
        padding-left: 260px;
        overflow: hidden;
    }

    .main .content {
        float: left;
        width: 100%;
        min-height: 100%;
        background: #eee;
        overflow: hidden;
        box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.1);
        border-radius: 6px;
    }

    .main .aside {
        float: left;
        border-radius: 6px;
        background: #eee;
        box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.1);
        padding-bottom: 20px;
        width: 230px;
        margin-left: -100%;
        position: relative;
        left: -257px;
    }
    .main .aside .nav li {
        line-height: 2rem;
    }

    .main .aside .nav li a {
        padding: 10px 15px;
        display: block;
    }
    .main .aside .nav li a.active,
    .main .aside .nav li a:hover {
        border-left: 3px solid rgb(9, 159, 247) !important;
        background: #ffffff;
        padding-left: 15px;
        margin-left: -3px;
    }
    .content_table,
    .addStu {
        background-color: #ffffff;
        margin: 20px;

    }

    .addStu {
        background-color: #ffffff;
        margin: 10px 20px;
    }

    .content_table table {
        border-collapse: collapse;
        width: 100%;
    }

    .content_table table tr {
        text-align: center;
        height: 60px;
    }

    .content_button {
        cursor: pointer;
        background-color: rgb(65, 192, 244);
        height: 42px;
        width: 80px;
        border-radius: 15px;
        color: #ffffff;
        border: 1px solid rgb(65, 192, 244);
    }

    .content_button:active {
        background-color: rgb(6, 166, 231);
        border: 1px solid rgb(6, 166, 231);
    }

    .content_input {
        border: none;
        height: 40px;
        width: 200px;
        border-radius: 10px;
        margin: 20px 10px;
        padding-left: 10px;
    }
    input:focus{
        outline: none;
        background-color: rgb(255, 253, 254);
    }

    .addStu_input {
        height: 30px;
        width: 200px;
        border-radius: 10px;
        padding-left: 10px;
        margin: 10px;
    }

    .addStu button {
        margin-left: 600px;
        cursor: pointer;
        height: 42px;
        width: 100px;
        border-radius: 5px;
        border: 1px solid #eee;
    }

    .addStu button:active {
        background-color: #999999;
        cursor: pointer;
        border: 1px solid #999999;
    }
</style>
</html>

