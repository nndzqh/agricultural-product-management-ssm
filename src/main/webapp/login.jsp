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
			<p style="font-size: 40px;margin-bottom: 20px;">农产品管理系统登录</p>
		</div>
		<div class="content">
			<form action="${pageContext.request.contextPath}/user/login" method="post">
				<div><span>账 号：</span><input placeholder="请输入账号" type="text" name="username"></div>
				<div><span>密 码：</span><input placeholder="请输入密码" type="password" name="password"></div>
				<button class="button" type="submit">登 录</button>
			</form>
		</div>
	</body>
	<style>
		.button{
			background-color: rgb(65, 192, 244);
			border: none;
			border-radius: 20px;
			width: 333px;
			color: #fff;
			font-size: 20px;
		}
		.button:active{
			background-color: rgb(6, 166, 231);
		}
		input{
			margin-top: 20px;
			width: 250px;
			height: 40px;
			padding-left: 15px;
			border-radius: 15px;
			border: 1px solid #333;
		}
		button{
			margin-top: 20px;
			height: 44px;
		}
		*{
			margin: 0;
			padding: 0;
		}
		body{
			padding-top: 170px;
			display: flex;
			flex-direction: column;
			justify-content: center;
			align-items: center;
			width: 100%;
			background-color:lightgrey;
		}
		.content{
			padding: 20px;
			height: 210px;
			width: 400px;
			background-color: #fff;
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