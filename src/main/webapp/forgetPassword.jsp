<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<meta http-equiv="X-UA-Compatible" content="ie=edge" />
		<meta name="description" content=""/>
		<meta name="keywords" content=""/>
		<link rel="icon" type="image/x-icon" href="<%=basePath %>/img/logo4.0.ico"/>
		<link rel="stylesheet" href="<%=basePath %>/css/forgetPassword.css" />
	</head>
	<body>
		<div class="nav">
		<div class="nav-top">
			<img src="<%=basePath %>/img/logo3.0.png" />
			<div class="nav-top-left">
				<ul>
					<li><a href="#">首页</a></li>
					<span>|</span>
					<li><a href="#">个人主页</a></li>
					<span>|</span>
					<li><a href="#">解决方案</a></li>
					<span>|</span>
					<li><a href="#">帮助中心</a></li>
					<span>|</span>
					<li><a href="#">加入论坛</a></li>
				</ul>
			</div>
			<div class="nav-top-right">
				<div class="nav-unLogin">
					<a href="" class="register"><span>注册</span></a>
					<a href="HomePage.jsp"><span class="login">登录</span></a>
				</div>
			</div>
		</div>
	</div>
	
	<div class="container">
		<div class="scetion">
			<span class="title">忘记密码？</span>
			<form action="" method="post" onsubmit="return sub();">
				<input type="text" name="" id="Input" placeholder="请输入邮箱地址："/>
				<span id="tips"></span>
				<input type="submit" name="" id="Submit" value="提交" />
			</form>
		</div>
	</div>
	<div class="pageBottom">
		<div class="pageBottom-mid">
			<img src="<%=basePath %>/img/logo3.0.png" alt="" />
			<span id="logoFoot">aiep.com</span>
			<ul>
				<li><a href="#">隐私条款</a></li>
				<li><a href="#">网站介绍</a></li>
				<li><a href="#">合作交流</a></li>
				<li><a href="#">联系我们</a></li>
			</ul>
			<div class="Form">
				<span>机器视觉工作室旗下人工智能实验技能提升的在线学习平台</span>
				<span>©机器视觉工作室 版权所有</span>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		var Input = document.getElementById("Input");
		var tips = document.getElementById("tips");
		function sub(){
			var Spostbox = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
			var flag = true;
			if(!Spostbox.test(Input.value)){
				tips.innerHTML = "*邮箱地址不正确！";
				flag = false;
			}
			if(Input.value == ""||Input.value == null){
				tips.innerHTML = "*请输入邮箱地址！";
				flag = false;
			}
			return flag;
		}
	</script>
	</body>
</html>
