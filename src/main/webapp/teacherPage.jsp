<%@page import="com.tensorflow.entity.Tch"%>
<%@page import ="com.alibaba.fastjson.JSON"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String temp = (String)session.getAttribute("tch");
	Tch tch = JSON.parseObject(temp, Tch.class);
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
		<link rel="stylesheet" href="<%=basePath %>/css/teacherPage.css" />
		<link rel="stylesheet" href="<%=basePath %>/css/myClassIconfont.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/experimentPageIconfont.css"/>
		<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/myClassIconfont.css"/>
		<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/new_iconfont.css" />
		<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
		<script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
		<script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="all">
			<div class="addClass">
				<form action="CreateClassServlet" method="post">
					<input type="text" name="className" id="addClassNum" placeholder="请输入班级名称"/>
					<input type="submit" id="addClassSub" value="确认" />
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
					<span id="useImg"><%out.print(tch.getTchName());%></span>
					<div class="useName"><%out.print(tch.getTchName());%></div>
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
        	时间：2019-05-02
        	描述：banner
        -->
        <div class="mycontainer">
        	<div class="con-left">
        		<ul>
        			<li class="liList">个人信息</li>
        			<li class="liList">添加实验</li>
        			<li class="liList">发布作业</li>
        			<li class="liList">班级管理</li>
        		</ul>
        	</div>
        	<div class="con-right banner">
        		<div class="scetion active">
        			<div class="BasicInfor">
					  <table class="table">
					    <tbody>
					       <tr>
					        <td style="border: 0px; width: 245px;">所在院校：</td>
							 <td style="border: 0px;" id="sch_name"><%out.print(tch.getUnivName()); %></td>
					      </tr>
					      <tr>
					        <td style="border: 0px;">教师工号：</td>
					        <td style="border: 0px;" id="tea_id"><%out.print(tch.getTchNum()); %></td>
					      </tr>
							  <tr>
					        <td style="border: 0px;">名称：</td>
					        <td style="border: 0px;" id="name"><%out.print(tch.getTchName()); %></td>
					     </tr>
					    </tbody>
					  </table>
				</div>
				<div class="schoolInfor">
					 <table class="table">
					    <tbody> 
					       <tr>
					        <td style="border: 0px;">手机号：</td>
							 <td style="border: 0px;"><input type="text" id="phone" class="per_info" value="<%out.print(tch.getTchPhone()); %>" /></td>
					      </tr>
					      <tr>
					        <td style="border: 0px;">邮箱：</td>
					        <td style="border: 0px;"><input type="text" id="emil" class="per_info" value="<%out.print(tch.getTchEmail()); %>" /></td>
					      </tr>
							  <tr>
					        <td style="border: 0px;">修改密码：</td>
					        <td style="border: 0px;"><input type="password" id="passw" class="per_info" value="" /></td>
					      </tr>
					      <tr>
					        <td style="border: 0px;">确认密码：</td>
							<td style="border: 0px;"><input type="password" id="Rpassw" class="per_info" value="" /></td><td style="border: 0px;">
					      </tr>
					    </tbody>
					 </table>
				</div>
				<div class="inp_show">
					<div class="tip_show" id="phoneShow"></div>
					<div class="tip_show" id="emilShow"></div>
					<div class="tip_show" id="passwShow"></div>
					<div class="tip_show" id="RpasswShow"></div>
				</div>
				<div class="sub">修改</div>
        		</div>
        		<div class="scetion">
        			
        		</div>
        		<div class="scetion" style="width: 960px; cursor: pointer;">
        			<table class="table table-hover">
					   <thead>
					      <tr>
					      	 <th>作业名称</th>
					         <th>实验ID</th>
					         <th>班级</th>
					         <th>启动时间</th>
					         <th>截止时间</th>
					         <th>&nbsp;&nbsp;&nbsp;提交情况</th>
					      </tr>
					   </thead>
					   <tbody id="operationList">
					   </tbody>
        			</table>
        			<a href="addWork.jsp" target="view_window" id="addOperation"> <strong>添加作业</strong> &nbsp;<i class="iconfont">&#xe649;</i></a>
        		</div>
        		<div class="scetion" id="class_list"></div>

        	</div>
        </div>
	<script type="text/javascript" src="<%=basePath %>/js/teacherPage.js"></script>
	</body>
</html>
