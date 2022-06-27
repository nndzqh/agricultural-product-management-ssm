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
            <form action="${pageContext.request.contextPath}/category/page" method="get">
                <input class="content_input" placeholder="请输入农产品分类名称" type="text" name="name" style="">
                <button class="content_button">查 询</button>
            </form>
            <a class="add_button" href="./addCategory.jsp" target="main">添加农产品分类</a>
        </div>
        <div class="content_table">
            <table border="1">
                <tr>
                    <th>排序</th>
                    <th>分类名称</th>
                    <th>创建时间</th>
                    <th>修改时间</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${pageInfo.list}" var="c" varStatus="ca">
                <tr>
                    <td>${ca.count}</td>
                    <td>${c.name}</td>
                    <td> ${c.createTime}</td>
                    <td> ${c.updateTime} </td>
                    <td>
                        <a class="add_button" href="${pageContext.request.contextPath}/category/getById?id=${c.id}" target="main"/>修 改
                        <a class="add_button" href="" target="main" onclick="detal(${c.id})"/>删除
                    </td>
                </tr>
                </c:forEach>
            </table>
        </div>

        <!-- 分页 -->
        <div class="box-tools pull-right">
            <ul class="pagination" style="">
                <li><a  href="${pageContext.request.contextPath}/category/page?page=1&size=5" aria-label="Previous">首页</a></li>
                <li><a  href="${pageContext.request.contextPath}/category/page?page=${pageInfo.pageNum-1}&size=5">上一页</a></li>
                <c:forEach begin="1" end="${pageInfo.pages}" var="pageNum">
                <li><a  href="${pageContext.request.contextPath}/category/page?page=${pageNum}&size=5">${pageNum}</a></li>
                </c:forEach>
                <li><a  href="${pageContext.request.contextPath}/category/page?page=${pageInfo.pageNum+1}&size=5">下一页</a></li>
                <li><a  href="${pageContext.request.contextPath}/category/page?page=${pageInfo.pages}&size=5" aria-label="Next">尾页</a></li>
            </ul>
        </div>
    </div>
    <!--左侧导航区-->
    <div class="aside">
        <div class="nav">
            <ul>
                <li><a href="${pageContext.request.contextPath}/products/getPage" target="_self"  >农产品管理</a></li>
                <li><a href="${pageContext.request.contextPath}/category/page" target="_self" class="active">农产品分类管理</a></li>
                <li><a href="${pageContext.request.contextPath}/stock/getPage" target="_self">库存管理</a></li>
                <li><a href="${pageContext.request.contextPath}/orders/getPage" target="_self">订单管理</a></li>
            </ul>
        </div>
    </div>

</div>
</body>
<script src="http://code.jquery.com/jquery-1.4.1.js"></script>
<script type="text/javascript">
    function detal(id){
        $.ajax({
            type:"get",
            url:"${pageContext.request.contextPath}/category/delete",
            data:{
                id:id
            },
            success:function (res) {
                console.log(res,'2131asdadadsadas');
                if(res){
                    alert("该种类下，存在农产品，不可删除");
                }else{
                    alert("删除成功！！！！");
                    location.reload();
                }
            }
        })
    }

</script>
<style>
    .add_button{
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
    .content_header{
        display: flex;
        align-items: center;
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
    .content_table,
    .addStu {
        background-color: #ffffff;
        margin: 20px;
        padding: 10px 15px;

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
    .pagination{
        width: 100%;
        display: flex;
        justify-content: center;
    }
    .pagination li{
        margin-left: 10px;
    }
</style>
</html>

