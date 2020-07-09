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
<title>欢迎登陆 AIEP在线实验平台...</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="ie=edge" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="icon" type="image/x-icon"
	href="<%=basePath%>/img/logo4.0.ico" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/css/experimentPage.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/css/experimentPageIconfont.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/css/new_iconfont.css" />
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>

</head>
<body>
	<!--
        	作者：offline
        	时间：2019-05-09
        	描述：导航条
        -->
	<div class="mynav">
		<div class="nav-top">
			<img src="<%=basePath%>/img/logo3.0.png" />
			<div class="nav-top-left">
				<ul>
					<li><a href="#">首页</a></li>
					<span>|</span>
					<li><a href="#">实验列表</a></li>
					<span>|</span>
					<li><a href="#">我的班级</a></li>
					<span>|</span>
					<li><a href="#">帮助中心</a></li>
					<span>|</span>
					<li><a href="#">加入论坛</a></li>
				</ul>
			</div>
			<!--
                	作者：offline
                	时间：2019-05-09
                	描述：搜索框
                -->
			<div class="query">
				<form action="" method="get" id="formlist">
					<input type="text" name="" value="" id="que" /> <input
						type="submit" value="&#xe60e;" id="fir" class="iconfont" />
				</form>
			</div>
			<!--
                	作者：offline
                	时间：2019-05-09
                	描述：未登录
                -->
			<div class="unLogin">
				<a href="registrationPage.jsp" class="register"><span>注册</span></a>
				<a href="HomePage.jsp"><span class="login">登录</span></a>
			</div>
			<div class="nav-top-right">
				<!--
                    	作者：offline
                    	时间：2019-05-09
                    	描述：成功登录
                    -->
				<div class="nav-login">
					<div class="tip iconfont" id="tips">&#xe608;</div>
					<span id="useImg"></span>
					<div class="useName"></div>
					<div class="triangle"></div>
					<div class="useFoot">
						<ul>
							<li class = "lis"><span class="useList iconfont icon-personalCenter"></span><a>个人中心</a></li>
							<li class = "lis"><span class="useList iconfont icon-wenku"></span><a>文库下载</a></li>
							<li class = "lis"><span class="useList iconfont icon-VIP"></span><a>我的VIP</a></li>
							<li class = "lis"><span class="useList iconfont">&#xe670;</span><a href="LogOutServlet">退出账号</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--
        	作者：offline
        	时间：2019-05-09
        	描述：轮播图
        -->
	<div class="top-section">
		<div id="demo" class="carousel slide" data-ride="carousel">
			<ul class="carousel-indicators">
				<li data-target="#demo" data-slide-to="0" class="active"></li>
				<li data-target="#demo" data-slide-to="1"></li>
				<li data-target="#demo" data-slide-to="2"></li>
			</ul>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="<%=basePath%>/img/ea4a1.jpg">
				</div>
				<div class="carousel-item">
					<img src="<%=basePath%>/img/bc86e50976ac4b28bd3e163de4f6de48.jpg">
				</div>
				<div class="carousel-item">
					<img src="<%=basePath%>/img/9d9896618bdf4b39b25bdb094f0759c4.png">
				</div>
			</div>
			<a class="carousel-control-prev" href="#demo" data-slide="prev">
				<span class="carousel-control-prev-icon"></span>
			</a> <a class="carousel-control-next" href="#demo" data-slide="next">
				<span class="carousel-control-next-icon"></span>
			</a>

		</div>
	</div>


	<div class="exp">
		<div class="exp-cont"></div>
		<!--
	        	作者：offline
	        	时间：2019-05-09
	        	描述：分页角标
	        -->
		<div class="exp-page">
			<div class="exp-page-mid"></div>
		</div>

	</div>
	</div>
	<!--
        	作者：offline
        	时间：2019-05-09
        	描述：底部信息栏
        -->

	<div class="pageBottom">
		<div class="pageBottom-mid">
			<img src="<%=basePath%>/img/logo3.0.png" alt="" /> <span
				id="logoFoot">aiep.com</span>
			<ul>
				<li><a href="#">隐私条款</a></li>
				<li><a href="#">网站介绍</a></li>
				<li><a href="#">合作交流</a></li>
				<li><a href="#">联系我们</a></li>
			</ul>
			<div class="Form">
				<span>机器视觉工作室旗下人工智能实验技能提升的在线学习平台</span> <span>©机器视觉工作室 版权所有</span>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="<%=basePath%>/js/expTest.js"></script>

</body>
</html>

