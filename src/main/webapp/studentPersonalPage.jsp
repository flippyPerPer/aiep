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
		<title>个人主页</title>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<meta http-equiv="X-UA-Compatible" content="ie=edge" />
		<meta name="description" content=""/>
		<meta name="keywords" content=""/>
		<link rel="icon" type="image/x-icon" href="<%=basePath %>/img/logo4.0.ico"/>
		<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/studentPersonalPage.css"/>
		<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
		<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
		<script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
		<script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
		</head>
	<body>
		<div class="top">
			<div class="top-bga">
				<div class="topSection">
					<img src="<%=basePath %>/img/logo3.0.png"/>
					<span class="userName">Atlantis</span>
				</div>
			</div>
			<div class="bottom">
				<ul>
					<li class="oli active">个人信息</li>
					<li class="oli">修改信息</li>
					<li class="oli">个人实验</li>
					<li class="oli">加入班级</li>
					<li class="oli">成绩统计</li>
				</ul>
			</div>
		</div>
		<div class="con">
			<div class="section secActive">
				<div class="BasicInfor">
					<img src="<%=basePath %>/img/logo3.0.png"/ class="headImg">
					  <table class="table">
					    <tbody>
					       <tr>
					        <td style="border: 0px;">所在院校：</td>
							 <td style="border: 0px;">天津大学仁爱学院</td>
					      </tr>
					      <tr>
					        <td style="border: 0px;">所属院系：</td>
					        <td style="border: 0px;">计算机系</td>
					      </tr>
							  <tr>
					        <td style="border: 0px;">自然班级：</td>
					        <td style="border: 0px;">暂无</td>
					      </tr>
					      <tr>
					        <td style="border: 0px;">我的学号：</td>
							 <td style="border: 0px;">6015000000</td>
					      </tr>
					    </tbody>
					  </table>
				</div>
				<div class="schoolInfor">
					 <table class="table">
					    <tbody>
					      
					       <tr>
					        <td style="border: 0px;">用户名：</td>
							 <td style="border: 0px;">Atlantis</td>
					      </tr>
					      <tr>
					        <td style="border: 0px;">手机号码：</td>
					        <td style="border: 0px;">18000000000</td>
					      </tr>
							  <tr>
					        <td style="border: 0px;">真实姓名：</td>
					        <td style="border: 0px;">王酸奶</td>
					      </tr>
					      <tr>
					        <td style="border: 0px;">性别：</td>
							 <td style="border: 0px;">男</td>
					      </tr>
					      <tr>
					        <td style="border: 0px;">电子邮箱：</td>
					        <td style="border: 0px;">1769978386@qq.com</td>
					      </tr>
							  <tr>
					        <td style="border: 0px;">出生日期：</td>
					        <td style="border: 0px;">2019/05/03</td>
					     </tr>
					    </tbody>
					  </table>
				</div>
			</div>
			<div class="section"></div>
			<div class="section"></div>
			<div class="section"></div>
			<div class="section"></div>
		</div>
		<div class="foot"></div>
		
		<script type="text/javascript">
			var oli = document.getElementsByClassName("oli");
			var osec = document.getElementsByClassName("section");
			
			for(var i = 0; i < oli.length; i ++){
				oli[i].index = i;
				oli[i].onclick = function(){
					for(var k = 0; k < osec.length; k ++){
						oli[k].className = "oli";
						osec[k].className = "section";
					}
				oli[this.index].className = "oli active";
				osec[this.index].className = "section secActive";
				}
			}
		</script>
	</body>
</html>
