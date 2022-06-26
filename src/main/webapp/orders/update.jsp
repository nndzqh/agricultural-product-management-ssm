<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/6/26
  Time: 20:36
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
    <form action="${pageContext.request.contextPath}/orders/update" method="post" enctype="multipart/form-data"
          style="display: flex;flex-direction: column;">
        <input type="hidden" value="${order.id}" name="id">
        <input type="hidden" value="${order.productsId}" name="productsId">
        <input type="hidden" value="${order.num}" name="num">
        <div class="si">
            <span>订单编号</span>
            <input type="text" name="number" value="${order.number}">
        </div>
        <div class="si">
            <span>地址</span>
            <input type="text" name="address" value="${order.address}">
        </div>
        <div class="si">
            <span>联系人</span>
            <input type="text" name="contact" value="${order.contact}">
        </div>
        <div class="si">
            <span>电话</span>
            <input type="text" name="phone" value="${order.phone}">
        </div>

        <div class="di">
            <div class="check_container">
                <div><input type="radio" name="state" value="0" <c:if test='${order.state == 0}'>checked
                </c:if>>已支付
                </div>
                <div><input type="radio" name="state" value="1" <c:if test='${order.state == 1}'>checked
                </c:if>>未支付
                </div>
                <div><input type="radio" name="state" value="2" <c:if test='${order.state == 2}'>checked
                </c:if>>已发货
                </div>
                <div><input type="radio" name="state" value="3" <c:if test='${order.state == 3}'>checked
                </c:if>>未发货
                </div>
                <div><input type="radio" name="state" value="4" <c:if test='${order.state == 4}'>checked
                </c:if>>已签收
                </div>
                <div><input type="radio" name="state" value="5" <c:if test='${order.state == 5}'>checked
                </c:if>>未签收
                </div>
            </div>
        </div>
        <button id="btn" tyle="submit">修改</button>
    </form>
</div>
</body>
<script src="http://code.jquery.com/jquery-1.4.1.js"></script>
<style>
    .check_container {
        width: 100%;
        display: flex;
        align-items: center;
        justify-content: space-between;
        flex-wrap: wrap;
    }

    .check_container div {
        width: 30%;
        display: flex;
        align-items: flex-end;
    }

    .check_container input {
        width: 20px;
        height: 20px;
    }

    select {
        width: 208px;
        height: 34px;
        margin-top: 10px;
        border-radius: 20px;
        padding-left: 12px;
    }

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

    .di {
        display: flex;
        flex-direction: column;
        text-align: center;
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
