<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>后台管理系统登录</title>
	</head>
	<body>
		<div class="header">
			<p style="font-size: 40px;margin-bottom: 20px;">后台管理系统登录</p>
		</div>
		<div class="content">
			<form action="${pageContext.request.contextPath}/user/login" method="post">
				<div><span>账 号：</span><input placeholder="请输入账号" type="text" name="username"></div>
				<div><span>密 码：</span><input placeholder="请输入密码" type="password" name="password"></div>
				<button type="submit">登 录</button>
			</form>
		</div>
	</body>
	<style>
		input{
			margin-top: 15px;
			width: 250px;
			height: 40px;
			padding-left: 15px;
			border-radius: 15px;
			border: 1px solid #333;
		}
		button{
			margin-top: 20px;
			height: 40px;
			width: 100px;
		}
		*{
			margin: 0;
			padding: 0;
		}
		body{
			padding-top: 200px;
			display: flex;
			flex-direction: column;
			justify-content: center;
			align-items: center;
			width: 100%;
			background-color:lightgrey;
		}
		.content{
			padding: 20px;
			height: 300px;
			width: 400px;
			background-color: #eee;
			border-radius: 30px;
			display: flex;
		}
		.content form{
			width: 400px;
 			display: flex;
			flex-direction: column;
			align-items: center;
			justify-content: center;
		}
	</style>
</html>