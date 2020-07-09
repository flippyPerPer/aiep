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
		<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">
		<!-- Google Chrome Frame也可以让IE用上Chrome的引擎: -->
		<meta name="renderer" content="webkit">
		<!--国产浏览器高速模式-->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 定义页面的最新版本 -->
		<meta name="description" content="网站简介" />
		<!-- 网站简介 -->
		<meta name="keywords" content="搜索关键字，以半角英文逗号隔开" />
		<title>实验平台</title>

		<!-- 公共样式 开始 -->

		<script type="text/javascript" src="<%=basePath %>/js/jquery-1.11.3.min.js"></script>
		<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/layui.css">
		<!-- 滚动条插件 -->
		<script src="<%=basePath %>/js/jquery-ui-1.10.4.min.js"></script>
		<script src="<%=basePath %>/js/jquery.mCustomScrollbar.min.js"></script>
		<script src="<%=basePath %>/js/cframe.js"></script><!-- 仅供所有子页面使用 -->
		<!-- 公共样式 结束 -->
		<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/frameStyle.css">
		<script type="text/javascript" src="<%=basePath %>/js/frame.js"></script>
        <script src="<%=basePath %>/js/jquery.countdown.js"></script>
	</head>

	<body>
		<!-- 左侧菜单 - 开始 -->
		<div class="frameMenu">
			<div class="logo">
				<div class="logoText">
				    <ul style="float: left;">
					  <p><span>实验时间剩余：</span><b class="alt-1">1:00</b></p>
					</ul>
					<ul style="float: left;margin-left: 10px;display: none;">
						<li style="margin: 3px; margin-top: -10px;">
							<button id="start_btn">开始实验</button>
						</li>
						<li style="margin: 3px;">
							<button id="stop_btn">停止实验</button>
						</li>
						<li style="margin: 3px; display: none;">
							<button id="come_btn">继续实验</button>
						</li>
					</ul>
				</div>
			</div>
			<div class="data">
				<ul style="border: 1px;">
					<li class="title" >实验题目</li>
					<br />	
					<li class="information">谈到俄罗斯和日本的关系，这真的不是一个好的关系，因为在第二次世界大战的时候两国之间的关系出现了很大的问题。那就是北方四岛涉及到了双方的领土问题。日本和俄罗斯这两个国家对此也是相当的重视。另外的原
					就是日本是美国的小老弟，所以俄罗斯很重视日本的行动。</li>
					<br />
				</ul>
			</div>
		</div>
		<!-- 左侧菜单 - 结束 -->

		<div class="main">

			<!-- 核心区域 - 开始 -->
			<div class="frameMain">
				<div class="con">
					<iframe id="mainIframe" src="" scrolling="no"></iframe>
				</div>
			</div>
			<!-- 核心区域 - 结束 -->
		</div>
		<script type="text/javascript" src="<%=basePath %>/js/frameHttp.js"></script>
		<script>
			window.jQuery(function($) {
				"use strict";

				$('time').countDown({
					with_separators: false
				});
				$('.alt-1').countDown({
					css_class: 'countdown-alt-1'
				});
				$('.alt-2').countDown({
					css_class: 'countdown-alt-2'
				});

			});
		</script>
	</body>

</html>
