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
		<link rel="stylesheet" href="<%=basePath %>/css/experimentCourse.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/experimentCourseIconfont.css"/>
		<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
		<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
		<script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
		<script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="top">
				<span class="courseName"><i class="iconfont myIcon">&#xe6a7;</i>会飞的per</span>
				<img src="<%=basePath %>/img/logo3.0.png"/>
		</div>
		<div class="container-fluid">
			 <div class="row">
			    <div class="col-sm-3" style="background-color:lavenderblush;">
			    	 <div class="row">
					    <div class="col-sm-4" style="background-color:lavenderblush;;">实验简介</div>
					    <div class="col-sm-4" style="background-color:lavender;">实验手册</div>
					    <div class="col-sm-4" style="background-color:lavender;">评论</div>
					 </div>
					 <div class="obanner" style="background-color:lavender">1212</div>
					 <div class="obanner">5656</div>
					 <div class="obanner">89898</div>
			    </div>
			    <div class="col-sm-9" style="background-color:lavenderblush;">.col-sm-8</div>
			  </div>
		</div>
		<script type="text/javascript">
			var oli = document.getElementsByClassName("col-sm-4");
			var obanner = document.getElementsByClassName("container-fluid obanner");
			
			for(var i = 0; i < oli.length; i ++){
				oli[i].index = i;
				oli[i].onclick = function(){
					for(var k = 0; k < obanner.length; k ++){
						oli[k].style.backgroundColor = 'lavender';
						obanner[k].style.display = 'none';
					}
					oli[this.index].style.backgroundColor = 'lavenderblush';
					obanner[this.index].style.display = 'block';
				}
			}
		</script>
	</body>
</html>
