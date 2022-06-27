<%--
  Created by IntelliJ IDEA.
  User: 15005
  Date: 2022/6/26
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>农产品后台管理后台</title>
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
            <form action="${pageContext.request.contextPath}/orders/getPage" method="get">
              <input class="content_input" placeholder="请输入订单编号" type="text" name="keyWord" style="">
              <button class="content_button">查 询</button>
            </form>
        </div>
        <div class="content_table">
            <table border="1">
                <tr>
                    <th style="width:55px">序号</th>
                    <th style="width:180px">订单编号</th>
                    <th style="width:70px">数量</th>
                    <th style="width:100px">地址</th>
                    <th style="width:100px">联系人</th>
                    <th style="width:100px">联系人电话</th>
                    <th style="width:100px">产品名称</th>
                    <th style="width:100px">订单状态</th>
                    <th style="width:100px">订单创建时间</th>
                    <th style="width: 250px">操作</th>
                </tr>
                <c:forEach var="orders" items="${pageInfo.list}" varStatus="s">

                    <tr>
                        <td>${s.count}</td>
                        <td>${orders.number}</td>
                        <td>${orders.num}</td>
                        <td>${orders.address}</td>
                        <td>${orders.contact}</td>
                        <td>${orders.phone}</td>
                        <td>${orders.productName}</td>
                        <td>
                            <c:if test="${orders.state == 0}">已支付</c:if>
                            <c:if test="${orders.state == 1}">未支付</c:if>
                            <c:if test="${orders.state == 2}">已发货</c:if>
                            <c:if test="${orders.state == 3}">未发货</c:if>
                            <c:if test="${orders.state == 4}">已签收</c:if>
                            <c:if test="${orders.state == 5}">未签收</c:if>
                        </td>
                        <td><fmt:formatDate value="${orders.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td><a href="${pageContext.request.contextPath}/orders/delete?ordersId=${orders.id}" class="add_button"/>删 除</a>
                            <a href="${pageContext.request.contextPath}/orders/get?orderId=${orders.id}"
                               class="add_button"/>修 改</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <!-- 分页 -->
        <div class="box-tools pull-right">
            <ul class="pagination" style="">
                <c:if test="${pageInfo.pageNum != 1}">
                    <li><a href="${pageContext.request.contextPath}/orders/getPage?page=1&size=5" aria-label="Previous">首页</a></li>
                    <li><a href="${pageContext.request.contextPath}/orders/getPage?page=${pageInfo.pageNum-1}&size=5">上一页</a></li>
                </c:if>
                <c:forEach begin="1" end="${pageInfo.pages}" var="pageNum">
                    <li><a href="${pageContext.request.contextPath}/orders/getPage?page=${pageNum}&size=5">${pageNum}</a></li>
                </c:forEach>
                <c:if test="${pageInfo.pageNum != pageInfo.pages}">
                    <li><a href="${pageContext.request.contextPath}/orders/getPage?page=${pageInfo.pageNum+1}&size=5">下一页</a></li>
                    <li><a href="${pageContext.request.contextPath}/orders/getPage?page=${pageInfo.pages}&size=5" aria-label="Next">尾页</a></li>
                </c:if>
            </ul>
        </div>
    </div>
    <!--左侧导航区-->
    <div class="aside">
        <div class="nav">
            <ul>
                <li><a href="${pageContext.request.contextPath}/products/getPage" target="_self" >农产品管理</a></li>
                <li><a href="${pageContext.request.contextPath}/category/page" target="_self">农产品分类管理</a></li>
                <li><a href="${pageContext.request.contextPath}/stock/getPage" target="_self">库存管理</a></li>
                <li><a href="${pageContext.request.contextPath}/orders/getPage" target="_self" class="active">订单管理</a></li>
            </ul>
        </div>
    </div>
</div>
</body>

<script src="http://code.jquery.com/jquery-1.4.1.js"></script>
<script type="text/javascript">

</script>
<style>
    .add_button {
        line-height: 15px;
        font-size: 14px;
        background-color: rgb(65, 192, 244);
        border: 1px solid rgb(65, 192, 244);
        padding: 13px 20px;
        border-radius: 15px;
        height: 15px;
        margin-bottom: 2px;
        margin-left: 13px;
        color: #ffffff;
    }
    .pagination {
        width: 100%;
        display: flex;
        justify-content: center;
    }

    .pagination li {
        margin-left: 10px;
    }
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
        text-decoration-line: none;
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

    .main {
        width: 80%;
        margin: 30px auto 0;
        padding-left: 260px;
        overflow: hidden;
    }

    .main .content {
        float: left;
        width: 100%;
        padding-bottom:20px;
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
    .content_table{
        padding: 10px 15px;
        background-color: #ffffff;
        margin: 20px;
        width: calc(100% - 70px);
    }


    .content_table table {
        overflow-x: scroll;
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
