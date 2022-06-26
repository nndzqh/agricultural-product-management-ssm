
<%--
  Created by IntelliJ IDEA.
  User: 63547
  Date: 2022/6/26
  Time: 19:14
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
  <form action="${pageContext.request.contextPath}/products/update" method="post" style="display: flex;flex-direction: column;">
    <input type="hidden" value="${products.id}" name="id">
    <div class="si">
      <span>请输入产品名称</span>
      <input type="text" name="name" value="${products.name}">
    </div>
    <div class="si">
      <span>请选择分类</span>
      <select name="categoryId">
        <c:forEach var="category" items="${categoryList}">
        <option value="${category.id}"
                <c:if test='${category.id == products.categoryId}'>selected='selected'</c:if>>
          ${category.name}
        </option>
        </c:forEach>
      </select>
    </div>
    <div class="si">
      <span>请上传图片</span>
      <input type="file" name="myfile" />
    </div>
    <div class="check_container">
      <div><input type="radio" name="state" value="0" <c:if test='${products.state == 0}'>checked</c:if>>起 售</div>
      <div><input type="radio" name="state" value="1" <c:if test='${products.state == 1}'>checked</c:if>>停 售</div>
    </div>

    <button id="btn" type="submit">修改</button>
  </form>
</div>
</body>
<script src="http://code.jquery.com/jquery-1.4.1.js"></script>
<script type="text/javascript">
  $(document).ready(function() {
    $(".click").click(function() {
      $(".down").slideToggle("slow");
    });
  });

</script>
<style>
  .check_container{
    width: 50%;
    margin: 0 auto;
    display: flex;
    align-items: center;
    justify-content: space-between;
  }
  .check_container div{
    display: flex;
    align-items: center;
  }
  .check_container input{
    width: 20px;
    height: 20px;
  }
  select{
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

