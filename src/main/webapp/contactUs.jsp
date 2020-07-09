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
		<link rel="stylesheet" href="<%=basePath %>/css/contactUs.css" />
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
				<div class="nav-login dis">
					<div class="tip">123</div>
					<img src="<%=basePath %>/img/logo3.0.png" id="us"/>
					<div class="useName">1</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<ul>
			<li class="Li liActive">关于我们</li>
			<li class="Li">联系我们</li>
			<li class="Li">使用条款</li>
			<li class="Li">隐私声明</li>
			<li class="Li">合作交流</li>
		</ul>
	</div>
	<div class="section">
		<div class="sec show">1</div>
		<div class="sec">2</div>
		<div class="sec"></div>
		<div class="sec"></div>
		<div class="sec"></div>
	</div>
	
	
	<script type="text/javascript">
		var oli = document.getElementsByClassName("Li");
		var odiv = document.getElementsByClassName("sec");
		for(var i = 0; i < oli.length; i ++)
		{
			oli[i].index = i;
			oli[i].onclick = function(){
				for(var k = 0; k <odiv.length ; k ++)
				{
					oli[k].className = "Li"
					odiv[k].className = "sec";
				}
			oli[this.index].className = "Li liActive";
			odiv[this.index].className = "sec show";
			}
		}
	</script>
	</body>
</html>
