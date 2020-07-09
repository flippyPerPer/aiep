<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="zh">
<head>
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta http-equiv="X-UA-Compatible" content="ie=edge" />
	<meta name="description" content="这是一个在线人工智能实验操作平台，你可以免费使用此平台上所有资源，并与老师同学一起构建实验......"/>
	<meta name="keywords" content="人工智能、人工智能实验平台、人工智能在线工具、人工智能实战"/>
	<link rel="icon" type="image/x-icon" href="<%=basePath %>/img/logo4.0.ico"/>
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/HomePage.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/iconfont.css" />
	<title>Welcome to the AI online platform</title>
</head>
<body onload="createCode()" style="overflow: -Scroll;overflow-x: hidden;">
	<!--
    	作者：offline
    	时间：2019-04-03
    	描述：背景图
    -->
	<div class="container-bg">‘
		<!--
        	作者：offline
        	时间：2019-04-03
        	描述：导航栏
        -->
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
					<a href="registrationPage.jsp" class="register"><span>注册</span></a>
					<span class="login" onclick="createCode();">登录</span>
				</div>
			</div>
		</div>
	<!--
    	作者：offline
    	时间：2019-04-01
    	描述：页面简介，、登录框
    -->
    <div class="container">
    	<div class="con-mid">
    		<div class="section">
    			<p style="font-size: 60px; font-weight: 100;">Welcome to</p>
					<h1 style="font-size: 42px; font-weight: 100;">the AI online platform</h1>
					<br>
					<p>这是一个在线人工智能实验操作平台，你可以免费使用此平台上所有资源，并与老师同学一起构建实验......</p>
					<br>
					<a href="#" class="freeReg">免费注册>>></a>
    		</div>
    		<div class="LoginPage">
    			<form action="LoginServlet" method="post" onsubmit=" return validateCode();">
    				<br />
    				<br />
    				<br />
    				<br />
    				<i id="Return" class="iconfont">&#xe6f1;</i>
    				<i class="LoginImg iconfont">&#xe60c;</i><input type="text" name="userName" id="userName" placeholder="请输入账号：" />
    				<p class="userText"></p>
    				<i class="LoginImg iconfont">&#xe618;</i><input type="password" name="password" id="password" placeholder="请输入密码：" />
    				<br />
    				<p class="passwordText"></p>
    				<br />
    				<div id="test"> 
    					<input type="text" name="Test" id="Test" placeholder="验证码：" />
    					<p class="testNum"></p>
    					<p id="reNum" onclick="createCode();">看不清，换一张...</p>
    					<div class="test-rad">
    						<input type="radio" name="t&s" value="1" checked="checked"/><span style="color: #FFFFFF;">普通用户</span>
    						<input type="radio" name="t&s" value="2"/><span style="color: #FFFFFF;">学生</span>
    						<input type="radio" name="t&s" value="3"/><span style="color: #FFFFFF;">教师</span>
    					</div>
    				</div>
    				<input type="submit" value="登录" id="submit"/>
    				<a href="#">忘记密码?</a>
    			</form>
    		</div>
    	</div>
    </div>
		</div>
	<!--
    	作者：offline
    	时间：2019-04-01
    	描述：页脚
    -->
    <div class="Bottom">
		<div class="Bottom-content">
			<br />
			<br />
			<h1>Tty AI Online Platform</h1>
			<br />
			<p>Use AI online platfprm with your own servers or in a private colud with the <a href="#">AI online platform.</a>Improve</p>
			<p>your developer efficiency with flexible deployment options,centralized permission,hunders of</p>
			<p>integrations,technical support,and more...</p>
			<a href="#" class="con">联系我们</a>
			<br />
			<p style="color: #999; font-size: 14px;">机械视觉工作室旗下人工智能实验技能提升的在线学习平台。 </p>
			<p style="color: #999; font-size: 14px;">©机械视觉工作室 版权所有</p>
		</div>
	</div>
	<script type="text/javascript" src="<%=basePath %>/js/jquery-3.3.1.min.js" ></script>
	<script type="text/javascript">
		/*loginPage样式*/
		$(".login").click(function(){
			$(".LoginPage").css("height","380px");
		});
		$("#Return").click(function(){
			$(".LoginPage").css("height","0px");
		});
		/*验证码板块*/
		var code;
		function createCode()
		{
			code = "";
			var codeLength = 6; //验证码的长度
			var checkCode = document.getElementsByClassName("testNum")[0];
			var codeChars = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 
			      'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
			      'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'); //所有候选组成验证码的字符，当然也可以用中文的
			for(var i = 0; i < codeLength; i++) 
			{
			 var charNum = Math.floor(Math.random() * 62);
			 code += codeChars[charNum];
			}
			if(checkCode){
				checkCode.innerHTML = code;
			}
		}
		function validateCode() 
		{
			var inputCode=document.getElementById("Test").value;
			if(inputCode.length <= 0) 
			{
			  alert("请输入验证码！");
			  createCode();
			  return false;
			}
			else if(inputCode.toUpperCase() != code.toUpperCase()) 
			{
			  alert("验证码输入有误！");
			  createCode();
			  return false;
			}
			else 
			{
			 return true;
			} 
		}
	</script>
</body>
</html>