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
	<meta name="description" content=""/>
	<meta name="keywords" content=""/>
	<link rel="icon" type="image/x-icon" href="<%=basePath %>/img/logo4.0.ico"/>
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/registrationPage.css"/>
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/iconfontRegistration.css" />
	<title>用户注册-AIEP</title>
</head>
<body>
	<div class="nav">
		<div class="nav-top">
			<img src="img/logo3.0.png" />
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
				<a href="" class="register"><span>注册</span></a>
				<a href="HomePage.jsp"><span class="login">登录</span></a>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="section">
			<div class="sec_top">
				<span class="Re reActive" id="stu_Re">学生注册</span>
				<span class="Re" id="tea_Re">教师注册</span>
				<span class="Re" id="or_Re">普通用户注册</span>
			</div>
			<div class="sec_body">
				<div class="form">
					<form action="StuRegisterServlet" method="post" onsubmit="return studentsCheck();">
						<span class="sp_style iconfont">&#xe61d;</span><input type="text" name="stunum" id="stu_na" class="Sinp_border inpStyle stu_inp" placeholder="学号："/>
						<p class="tips stipsShow" id="SNshow"></p>
						<span class="sp_style iconfont">&#xe648;</span><input type="password" name="stupassword" id="stu_pw" class="Sinp_border inpStyle stu_inp" placeholder="设置密码："/>
						<p class="tips stipsShow" id="SPshow"></p>
						<span class="sp_style iconfont">&#xe648;</span><input type="password" name="stu_Rpw" id="stu_Rpw" class="Sinp_border inpStyle stu_inp" placeholder="确认密码："/>
						<p class="tips stipsShow" id="SRPshow"></p>
						<span class="sp_style iconfont">&#xe61c;</span><input type="text" name="stuname" id="stu_user" class="Sinp_border inpStyle stu_inp" placeholder="姓名："/>
						<p class="tips stipsShow" id="SUsershow"></p>
						<span class="sp_style iconfont">&#xe625;</span><input type="text" name="stuunivname" id="stu_sch" class="Sinp_border inpStyle stu_inp" placeholder="学校："/>
						<p class="tips stipsShow" id="SSCshow"></p>
						<span class="sp_style iconfont">&#xe6a6;</span><input type="text" name="stuemail" id="stu_p" class="Sinp_border inpStyle stu_inp" placeholder="邮箱："/>
						<p class="tips stipsShow" id="SPOshow"></p>
						<span class="sp_style iconfont">&#xe61a;</span><input type="text" name="stuphone" id="stu_ph" class="Sinp_border inpStyle stu_inp" placeholder="手机号码："/>
						<p class="tips stipsShow" id="SPHshow"></p>
						<div class="ver">
							<span class="iconfont" id="sp_style_1">&#xe630;</span><input type="text" name="stu_ver" id="Sinp_border stu_ver stu_inp" class="ver_inp" placeholder="验证码："/>
							<div class="ver_show"></div>
							<span class="ver_Rshow">看不清，换一张...</span>
						</div>
						<input type="submit" name="stu_sub" id="stu_sub" class="sub" value="同意条例并注册"/>
						<p id="sta"><a href="#">《使用条款》 </a>和<a href="#">《隐私声明》 </a></p>
					</form>
				</div>
				
				<div class="form formNone">
					<form action="TchRegisterServlet" method="post" onsubmit="return teachersCheck();">
						<span class="sp_style iconfont">&#xe630;</span><input type="text" name="tchnum" id="tea_na" class="Tinp_border inpStyle tea_inp" placeholder="工号："/>
						<p class="tips ttipsShow" id="TNshow"></p>
						<span class="sp_style iconfont">&#xe648;</span><input type="password" name="tchpassword" id="tea_pw" class="Tinp_border inpStyle tea_inp" placeholder="设置密码："/>
						<p class="tips ttipsShow" id="TPshow"></p>
						<span class="sp_style iconfont">&#xe648;</span><input type="password" name="tea_Rpw" id="tea_Rpw" class="Tinp_border inpStyle tea_inp" placeholder="确认密码："/>
						<p class="tips ttipsShow" id="TRPshow"></p>
						<span class="sp_style iconfont">&#xe61c;</span><input type="text" name="tchname" id="tea_user" class="Sinp_border inpStyle stu_inp" placeholder="姓名："/>
						<p class="tips stipsShow" id="TUsershow"></p>
						<span class="sp_style iconfont">&#xe625;</span><input type="text" name="tchunivname" id="tea_sch" class="Tinp_border inpStyle tea_inp" placeholder="学校："/>
						<p class="tips ttipsShow" id="TSCshow"></p>
						<span class="sp_style iconfont">&#xe6a6;</span><input type="text" name="tchemail" id="tea_p" class="Tinp_border inpStyle tea_inp" placeholder="邮箱："/>
						<p class="tips ttipsShow" id="TPOshow"></p>
						<span class="sp_style iconfont">&#xe61a;</span><input type="text" name="tchphone" id="tea_ph" class="Tinp_border inpStyle tea_inp" placeholder="手机号码："/>
						<p class="tips ttipsShow" id="TPHshow"></p>
						<div class="ver">
							<span class="iconfont" id="sp_style_1">&#xe630;</span><input type="text" name="tea_ver" id="tea_ver" class="ver_inp" placeholder="验证码："/>
							<div class="ver_show"></div>
							<span class="ver_Rshow">看不清，换一张...</span>
						</div>
						<input type="submit" name="tea_sub" id="tea_sub" class="sub" value="同意条例并注册"/>
						<p id="sta"><a href="#">《使用条款》 </a>和<a href="#">《隐私声明》 </a></p>
					</form>
				</div>
				
				<div class="form formNone">
					<form action="UserRegisterServlet" method="post" onsubmit="return ordinaryUsersCheck();">
						<span class="sp_style iconfont">&#xe61c;</span><input type="text" name="username" id="or_na" class="Oinp_border inpStyle tea_inp" placeholder="账号："/>
						<p class="tips otipsShow" id="ONshow"></p>
						<span class="sp_style iconfont">&#xe648;</span><input type="password" name="password" id="or_pw" class="Oinp_border inpStyle tea_inp" placeholder="设置密码："/>
						<p class="tips otipsShow" id="OPshow"></p>
						<span class="sp_style iconfont">&#xe648;</span><input type="password" name="or_Rpw" id="or_Rpw" class="Oinp_border inpStyle tea_inp" placeholder="确认密码："/>
						<p class="tips otipsShow" id="ORPshow"></p>
						<span class="sp_style iconfont">&#xe638;</span><input type="text" name="or_sch" id="or_sch" class="Oinp_border inpStyle tea_inp" placeholder="地址："/>
						<p class="tips otipsShow" id="OSCshow"></p>
						<span class="sp_style iconfont">&#xe6a6;</span><input type="text" name="email" id="or_p" class="Oinp_border inpStyle tea_inp" placeholder="邮箱："/>
						<p class="tips otipsShow" id="OPOshow"></p>
						<span class="sp_style iconfont">&#xe61a;</span><input type="text" name="userphone" id="or_ph" class="Oinp_border inpStyle tea_inp" placeholder="手机号码："/>
						<p class="tips otipsShow" id="OPHshow"></p>
						<div class="ver">
							<span class="iconfont" id="sp_style_1">&#xe630;</span><input type="text" name="or_ver" id="or_ver" class="ver_inp" placeholder="验证码："/>
							<div class="ver_show"></div>
							<span class="ver_Rshow">看不清，换一张...</span>
						</div>
						<input type="submit" name="or_sub" id="or_sub" class="sub" value="同意条例并注册"/>
						<p id="sta"><a href="#">《使用条款》 </a>和<a href="#">《隐私声明》 </a></p>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="<%=basePath%>js/registration.js"></script>
	</script>
</body>
</html>
