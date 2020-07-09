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
		<link rel="stylesheet" href="<%=basePath %>/css/addWork.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/experimentCourseIconfont.css"/>
		<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
		<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
		<script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
		<script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
		
		<script src="https://cdn.bootcss.com/moment.js/2.18.1/moment-with-locales.min.js"></script>
		<link href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
		<script src="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
	</head>
	<body>
		<div class="top">
			<a href="teacherPage.jsp"><span class="courseName"><i class="iconfont myIcon">&#xe6a7;</i><%out.print(tch.getTchName()); %></span></a>
			<img src="img/logo3.0.png"/>
		</div>
		<div class="cont">
			<form action="addWorkServlet" class="form-horizontal" role="form" method="post">
                <fieldset>
                    <legend>发布作业</legend>
                    <div class="form-group">
                        <label class="control-label">作业名称</label>
                        <div class="col-sm-8">
                            <input class="form-control text-left" name="workName" id="ds_host" type="text"/>
                        </div>
                        <label class="col-sm-2 control-label" for="ds_name">实验ID</label>
                        <div class="col-sm-4">
                           <input class="form-control text-left" name="expID" id="ds_name" type="text"/>
                        </div>
                        <label class="col-sm-2 control-label" for="ds_name">开始时间</label>
                        <div class="col-sm-4">
                          <input type='text' class="form-control text-left" name="workStartTime" id='datetime' />
                          </div>
                          <label class="col-sm-2 control-label" for="ds_name">结束时间</label>
                          <div class="col-sm-4">
                            <input type='text' class="form-control text-left" name="workEndTime" id='datetime1' />
                          </div>
                      </div>
                    </fieldset>     
                    <fieldset>
                        <legend>选择班级</legend>
                        <div class="form-group">
                           <label for="disabledSelect"  class="col-sm-2 control-label">班级名称</label>
                           <div class="col-sm-4">
                              <select id="disabledSelect" name="workClass" class="form-control">
                                 <option>测试班级</option>
                                 <option>另一个测试班级</option>
                              </select>
                           </div>
                        </div>
                    </fieldset>
                    <fieldset>
                       <div class="form-group">
						    <label for="disabledSelect"  class="col-sm-2 control-label">作业描述</label>
						    <textarea class="form-control col-sm-8 text-left" name="workInfo" rows="3" style="display:block;margin-left:20px"></textarea>
						</div>
                    </fieldset>
                    <button type="submit" class="btn btn-primary btn-lg btn-block col-sm-10" style="display:block;margin:15px auto">发布</button>
               </form>
		</div>
		<script>
			$(function() {
				$("#datetime").datetimepicker({
					format: 'YYYY-MM-DD hh:mm',
					locale: moment.locale('zh-cn')
				});
				$("#datetime1").datetimepicker({
					format: 'YYYY-MM-DD hh:mm',
					locale: moment.locale('zh-cn')
				});
			});
		</script>
	</body>
</html>
