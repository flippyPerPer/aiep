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
		<link rel="stylesheet" href="<%=basePath %>/css/myClass.css" />
		<link rel="stylesheet" href="<%=basePath %>/css/myClassIconfont.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/experimentPageIconfont.css"/>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/new_iconfont.css" />
	</head>
	<body>
		<!--
        	作者：offline
        	时间：2019-04-24
        	描述：弹窗
        -->
		<div class="all">
			<div class="addClass">
				<form action="" method="post">
					<input type="text" name="" id="addClassNum" placeholder="请输入班级码"/>
					<input type="submit" name="" id="addClassSub" value="确认" />
					<div class="Cannel">取消</div>
				</form>
			</div>
		</div>
		<!--
        	作者：offline
        	时间：2019-04-24
        	描述：导航栏
        -->
		<div class="mynav">
		<div class="nav-top">
			<img src="<%=basePath %>/img/logo3.0.png" />
			<div class="nav-top-left">
				<ul>
					<li><a href="experimentPage.jsp">首页</a></li>
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
			<div class="query">
				<form action="" method="get" id="formlist">
					<input type="text" name="" value=""id="que"/>
					<input type="submit"  value="&#xe60e;" id="fir" class="iconfont"/>
				</form>
			</div>
			<div class="nav-top-right">
				<div class="nav-login">
					<div class="tip iconfont" id="tips">&#xe608;</div>
					<span id="useImg">鹏</span>
					<div class="useName">Atlantis</div>
					<div class="triangle"></div>
					<div class="useFoot">
						<ul>
							<li><span class="useList iconfont icon-personalCenter"></span><a href="">个人设置</a></li>
							<li><span class="useList iconfont icon-wenku"></span><a href="">文库下载</a></li>
							<li><span class="useList iconfont icon-VIP"></span><a href="">我的VIP</a></li>
							<li><span class="useList iconfont">&#xe670;</span><a href="">退出账号</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--
    	作者：offline
    	时间：2019-04-24
    	描述：班级列表
    -->
    <div class="container">
    	<div class="container-mid">
    		<span class="join"><i class="iconfont">&#xe649;</i>&nbsp;加入班级</span>
    		<a href="myClassList.jsp">
    			<div class="classList">
    				<div class="class-top" style="background-image: url(<%=basePath %>/img/1471.png);">
    					<span class="className">软件1,2班 Python教学实验课程教学实验课程教学实验课程</span>
    					<span class="classIntro">角色：学生&nbsp;&nbsp;&nbsp;教师:王鹏</span>
    				</div>
    				<div class="class-foot">
    					<span class="classNotice"><p class="classNotice-top">近期公告：</p>font-family属性是多种字体的名称，作为一个"应变"制度，以确保浏览器/操作系统之间的最大兼容性。如果浏览器不支持的第一个字体，它尝试下一个的字体。</span>
    					<span class="classCode"></span>
    					<span class="classMember">邀请码：564856<i class="iconfont peng">&#xe677;</i>80</span>
    				</div>
    			</div>
    		</a>
    		
    	</div>
    </div>
	<script type="text/javascript" src="<%=basePath %>/js/myClass.js"></script>
	</body>
</html>
