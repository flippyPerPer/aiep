<%@page import="com.tensorflow.entity.Exp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	Exp exp = (Exp)request.getAttribute("exp");

%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>修改实验</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<meta http-equiv="X-UA-Compatible" content="ie=edge" />
		<meta name="description" content=""/>
		<meta name="keywords" content=""/>
		<link rel="icon" type="image/x-icon" href="<%=basePath %>/img/logo4.0.ico"/>
		<link rel="stylesheet" href="<%=basePath %>/css/addExpriment.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/myClassListIconfont.css"/>
		<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/experimentPageIconfont.css"/>
		
	</head>
	<body>
		<!--
        	作者：offline
        	时间：2019-05-05
        	描述：导航栏
        -->
        <div class="nav">
			<div class="nav-left">
				<a href="teacherPage.jsp"><i class="iconfont per">&#xe69c;</i>添加实验</a>
			</div>
			<div class="nav-right">
				<img src="<%=basePath %>/img/logo3.0.png" alt="" />
			</div>
		</div>
		<!--
        	作者：offline
        	时间：2019-05-05
        	描述：body
        -->
        <div class="container">
        	<form action="updateExperimentServlet" method="get">
        		<div class="expfoot">请选取一个图像文件: <input type="file" id="file" name="file"/></div>
        		<div class="id" style="display:none">ID:<input name = "Exp_ID" value="<%out.print(exp.getExpID());%>"></div>
        		<div class="expname">实验名称：</div><input type="text" name="Exp_name" value="<%out.print(exp.getExpName()); %>" id="exp-name"/>
        		<div class="expcont">实验简介：</div><textarea name="Exp_info" rows="10" cols="30" id="exp-cont" ><%out.print(exp.getExpInfo());%></textarea>
        		<div class="expcont">实验Api：</div><textarea name="Exp_api" rows="10" cols="30" id="exp-cont"style="height: 100px;"><%out.print(exp.getExpApi()); %></textarea>
        		<input type="submit" name="sub" id="sub" value="提交修改" />
        	</form>
        </div>
	</body>
</html>
