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
		<title>班级成员</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<meta http-equiv="X-UA-Compatible" content="ie=edge" />
		<meta name="description" content=""/>
		<meta name="keywords" content=""/>
		<link rel="icon" type="image/x-icon" href="<%=basePath %>/img/logo4.0.ico"/>
		<link rel="stylesheet" href="<%=basePath %>/css/myClassList.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/myClassListIconfont.css"/>
		<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/experimentPageIconfont.css"/>
	</head>
	<body>
		<!--
        	作者：offline
        	时间：2019-04-24
        	描述：导航栏
        -->
		<div class="nav">
			<div class="nav-left">
				<a href="myClass.jsp"><i class="iconfont per">&#xe69c;</i>软件4班</a>
			</div>
		</div>
		<!--
        	作者：offline
        	时间：2019-04-25
        	描述：主体
        -->
        <div class="container">
        	<div class="container-mid">
        		<span id="dem">成员</span>
        		<div class="con-left">
        			<div class="JoinNum">加课码：HFIJFF</div>
        		</div>
        		<div class="con-right">
        			<div class="teacherList"><div class="teachersName">教师：王鹏</div><span class="teacherNumber">6017230326</span></div>
        			<div class="studentList"><div class="studentsName">王鹏</div><span class="studentNumber">6017230326</span><span class="studentClass">软件4</span></div>
        			<div class="studentList"><div class="studentsName">王鹏</div><span class="studentNumber">6017230326</span><span class="studentClass">软件4</span></div>
        			<div class="studentList"><div class="studentsName">王鹏</div><span class="studentNumber">6017230326</span><span class="studentClass">软件4</span></div>
        		</div>
        	</div>
        </div>
	<script type="text/javascript" src="<%=basePath %>/js/myClass.js"></script>
	</body>
</html>
