
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
  <form action="${pageContext.request.contextPath}/products/add" method="post" enctype="multipart/form-data" style="display: flex;flex-direction: column;">
    <div class="si">
      <span>请输入产品名称</span>
      <input type="text" name="name">
    </div>
    <div class="si">
      <span>请选择分类</span>
      <select name="categoryId">
          <c:forEach var="category" items="${categoryList}">
              <option value="${category.id}">${category.name}</option>
          </c:forEach>
      </select>
    </div>
    <div class="si">
        <input class="" accept="image/*;" type="file" attachtype="1" name="farm"/>
    </div>
    <!-- 分类下拉框 -->
    <button id="btn" tyle="submit">添加</button>
  </form>
</div>
</body>
<script src="http://code.jquery.com/jquery-1.4.1.js"></script>
<script>
    // 上传方法的监听
    $(".ticketUploader").on("change", function (e) {
        var files = e.target.files;
        for (var i = 0; i < files.length; i++) {
            var file = files[i];
            Utils.ImgToBase64(file,1980,function(resizeImgBase64) {
                $("#a").remove();
                $('#ticketImages' ).append('<li id="a" img="' + resizeImgBase64 + '" class="weui-uploader__file" style="background-image:url(' + resizeImgBase64 + ')" bUploaded="0"><close οnclick="closePic(this)" class="el-icon-error"></close></li>');
            });
        }
    });
    function closePic(obj){
        console.log(obj)
        //此时的obj就是close标签，下面是获得这个标签的父标签，这里的父标签是li
        let pic = obj.parentNode
        pic.remove()//li标签remove了就删除了
        $(".ticketUploader").val('');
    }

</script>
<style>
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

