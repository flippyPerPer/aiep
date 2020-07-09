//基本框架

var navTopRight = document.getElementsByClassName("nav-top-right")[0];
var tips = document.getElementById("tips");

var con_left = document.getElementsByClassName("con-left")[0];
var Li = document.getElementsByClassName("liList");
var oScetion = document.getElementsByClassName("scetion");

var exp_banner = document.getElementsByClassName("banner")[0];
var exp_li = document.getElementsByClassName("exp-li");
var exp_all = document.getElementsByClassName("exp-all");

navTopRight.onmouseover = function() {
	navTopRight.style.height = 250 + 'px';
	tips.style.transform = 'rotate(' + 0 + 'deg)';
	tips.style.color = '#1277EB';
}
navTopRight.onmouseout = function() {
	navTopRight.style.height = 60 + 'px';
	tips.style.transform = 'rotate(' + 90 + 'deg)';
	tips.style.color = '#FFFFFF';
}

Li[0].style.backgroundColor = "#17A2B8";
for (var i = 0; i < Li.length; i++) {
	Li[i].index = i;
	Li[i].onclick = function() {
		for (var k = 0; k < oScetion.length; k++) {
			Li[k].style.backgroundColor = null;
			oScetion[k].style.display = "none";
		}
		Li[this.index].style.backgroundColor = "#17A2B8";
		oScetion[this.index].style.display = "block";
	}
}

for (var i = 0; i < exp_li.length; i++) {
	exp_li[i].index = i
	exp_li[i].onmouseover = function() {
		exp_all[this.index].style.top = 0 + 'px';
	}
	exp_li[i].onmouseout = function() {
		exp_all[this.index].style.top = 254 + 'px';
	}
}

// 个人信息

// 手机号验证
var flag;
var phone = document.getElementById("phone");
var phoneShow = document.getElementById("phoneShow");
var Sphone = /^[1][3-9]{1}[0-9]{9}$/;
phone.onblur = function() {
	if (phone.value == null || phone.value == "") {
		phoneShow.innerHTML = "*号码不能为空！";
		flag = false;
	} else if (!Sphone.test(phone.value)) {
		phoneShow.innerHTML = "*请输入11手机号";
		flag = false;
	} else {
		phoneShow.innerHTML = "";
		flag = true;
	}
}

// 邮箱验证
var emil = document.getElementById("emil");
var emilShow = document.getElementById("emilShow");
var Spostbox = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
emil.onblur = function() {
	if (emil.value == null || emil.value == "") {
		emilShow.innerHTML = "*邮箱不能为空！";
		flag = false;
	} else if (!Spostbox.test(emil.value)) {
		emilShow.innerHTML = "*请输入有效邮箱地址";
		flag = false;
	} else {
		emilShow.innerHTML = "";
		flag = true;
	}
}
// 密码验证
var passw = document.getElementById("passw");
var passwShow = document.getElementById("passwShow");
var Spassword = /^[a-z0-9A-Z]{6,18}$/;
passw.onblur = function() {
	if (passw.value == null || passw.value == "") {
		passwShow.innerHTML = "*密码不能为空！";
		flag = false;
	} else if (!Spassword.test(passw.value)) {
		passwShow.innerHTML = "*请输入6-18任意数字或字母";
		flag = false;
	} else {
		passwShow.innerHTML = "";
		flag = true;
	}
}

var Rpassw = document.getElementById("Rpassw");
var RpasswShow = document.getElementById("RpasswShow");
Rpassw.onblur = function() {
	if (Rpassw.value != passw.value) {
		RpasswShow.innerHTML = "*两此密码不一致！";
		flag = false;
	} else if (Rpassw.value == null || Rpassw.value == "") {
		RpasswShow.innerHTML = "*密码不能为空！";
		flag = false;
	} else {
		RpasswShow.innerHTML = "";
		flag = true;
	}
}

// 信息修改
var sub = document.getElementsByClassName("sub")[0];
sub.onclick = function() {
	var pho = phone.value;
	var emi = emil.value;
	var pas = passw.value;
	var Rpas = Rpassw.value;
	var xhr_1;
	xhr_1 = new XMLHttpRequest();

	xhr_1.onreadystatechange = function() {
		if (this.readyState == 4) {
			if (this.status.toString().charAt() == "2" || this.status == "304") {
				var data = xhr_1.responseText;
				console.log(data);
				if (typeof data != "object") {
					data = JSON.parse(data);
				}
				phone.value = data.tchPhone;
				emil.value = data.tchEmail;
				passw.value = null;
				Rpassw.value = null;
				alert("修改成功！")
			}
		}
	}

	xhr_1.open("POST", "UpdateTchSignServlet", true);

	xhr_1.setRequestHeader('content-type', 'application/x-www-form-urlencoded');
	xhr_1.send("phone=" + pho + "&emil=" + emi + "&password=" + pas);

}

// 添加实验

Li[1].addEventListener('click', addExper);
function addExper() {
	var html = "";
	var xhr;
	// 创建XMLHttpRequest()对象；
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (this.readyState == 4) {
			if (this.status.toString().charAt() == "2" || this.status == "304") {
				var data = xhr.responseText;
				if (typeof data != "object") {
					data = JSON.parse(data);
				}
				for ( var i in data) {
					html += '<div class="exp-li">';
					html += '<div class="exp-top">';
					html += '<img src="' + data[i].expURLPic + '"/>';
					html += '</div>';
					html += '<div class="exp-body">';
					html += data[i].expName;
					html += '</div>';
					html += '<div class="exp-foot">';
					html += data[i].expInfo;
					html += '</div>';
					html += '<div class="exp-all">';
					html += '<span class="expBottom expRevise" data-id="'
							+ data[i].expID + '">修改</span>';
					html += '<span class="expBottom expDelete" data-id="'
							+ data[i].expID + '">删除</span>';
					html += '</div>';
					html += '</div>';

				}
				html += "<a href=\"addExperiment.jsp\"><div class=\"exp-add\"><i class=\"iconfont\" id=\"add\">&#xe649;</i></div></a>"
				oScetion[1].innerHTML = html;

				for (var m = 0; m < exp_li.length; m++) {
					exp_li[m].index = m;
					exp_li[m].onmouseover = function() {
						exp_all[this.index].style.top = 0 + 'px';
					}
					exp_li[m].onmouseout = function() {
						exp_all[this.index].style.top = 254 + 'px';
					}
				}

				// 修改实验
				var expRevise = document.getElementsByClassName("expRevise");
				for (var k = 0; k < expRevise.length; k++) {
					expRevise[k].onclick = function() {
						var a = this.getAttribute("data-id");
						url = 'ExpSignServlet?num=' + a;
						window.location.href = url;
					}
				}
				//删除实验
				var expDelete = document.getElementsByClassName("expDelete");

				for(var i = 0; i < expDelete.length; i++){
					expDelete[i].onclick = function(){
						var val = confirm("确认删除？");
						if(val){
							var b = this.getAttribute("data-id");
							var xhr_1;
								// 创建XMLHttpRequest()对象；
								xhr_1 = new XMLHttpRequest();
								xhr_1.onreadystatechange = function(){
									if(this.readyState == 4){
										if(this.status.toString().charAt() == "2"||this.status == "304"){
											var data = xhr_1.responseText;
											if(typeof data == 1){
												alert("删除成功!");
												window.location.reload();
											}
											
										}
									}
								}
								
								xhr_1.open("GET","DeleteExpServlet",true);
								xhr_1.setRequestHeader('content-type','application/x-www-form-urlencoded');
								xhr_1.send("expID=" + b);
						}
					}
				}

			}
		}
	}

	xhr.open("GET", "ShowTchExpServlet", true);

	xhr.send();
}
var expRevise = document.getElementsByClassName("expRevise");
for (var k = 0; k < expRevise.length; k++) {
	expRevise[k].onclick = function() {
		var a = this.getAttribute("data-id");
		url = 'addExperiment.jsp?num=' + a;
		window.location.href = url;
	}
}

// 显示作业
Li[2].addEventListener("click", addOperation);
function addOperation() {
	var xhr;
	var html = "";
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (this.readyState == 4) {
			if (this.status.toString().charAt() == "2" || this.status == "304") {
				var data = xhr.responseText;
				if (typeof data != "object") {
					data = JSON.parse(data);
				}
				for( var i in data){
					html += "<tr class=\"demo\" data-id=\""
							+ data[i].expID
							+ "\"><td>"
							+ data[i].workName
							+ "</td><td>"
							+ data[i].expID
							+ "</td><td>"
							+ data[i].classCode
							+ "</td><td>"
							+ data[i].startTime
							+ "</td><td>"
							+ data[i].endTime
							+ "</td><td>"
							+ "<a href=\"#\" class=\"btn btn-info btn-sm btn_1\"><span class=\"glyphicon glyphicon-zoom-in\"></span>查看</a>&nbsp;<a href=\"#\" class=\"btn btn-info btn-sm btn_2\"><span class=\"glyphicon glyphicon-trash\"></span>删除</a></td></tr>"
				}
				document.getElementById("operationList").innerHTML = html;
				//查看作业
				var btn_1 = document.getElementsByClassName("btn_1");
				for(var k = 0; k < btn_1.length; k ++){
					btn_1[k].index = k;
					btn_1[k].onclick = function(){
					var a = document.getElementsByClassName("demo")[this.index].getAttribute("data-id");
					console.log(a);
					url = 'addWork.html?num=' + a;
					window.location.href = url;
					}

				}
				//删除作业
				var btn_2 = document.getElementsByClassName("btn_2");

				for(var i = 0; i < btn_2.length; i++){
					btn_2[i].index = i;
					btn_2[i].onclick = function(){
						var val = confirm("确认删除？");
						if(val){
							var b = document.getElementsByClassName("demo")[this.index].getAttribute("data-id");
							var xhr_1;
								// 创建XMLHttpRequest()对象；
								xhr_1 = new XMLHttpRequest();
								xhr_1.onreadystatechange = function(){
									if(this.readyState == 4){
										if(this.status.toString().charAt() == "2"||this.status == "304"){
											var data = xhr_1.responseText;
											if(typeof data == 1){
												alert("删除成功!");
												window.location.reload();
											}
											
										}
									}
								}
								
								xhr_1.open("GET","DeleteExpServlet",true);
								xhr_1.setRequestHeader('content-type','application/x-www-form-urlencoded');
								xhr_1.send("expID=" + b);
						}
					}
				}
			}
		}
	}
	xhr.open("GET", "ShowTchWorksServlet", true);
	xhr.send();
}


// 显示班级

Li[3].addEventListener("click",classList);
function classList(){
	var xhr;
	var html = "";
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(this.readyState == 4){
			if(this.status.toString().charAt() == "2"||this.status == "304"){
				var data = xhr.responseText;
				if(typeof data != "object"){
					data = JSON.parse(data);
				}
				for(var i in data){
					html+='<a href="classManagement.jsp">';
		    		html+='<div class="classList">';
		    		html+='<div class="class-top" style="background-image: url(' +"http://ws4.sinaimg.cn/large/9150e4e5ly1flhz64m7gbj20am08cq37.jpg"+');">';
		    		html+='<span class="className">'+ data[i].className +'</span>';
		    		html+='<span class="classIntro">角色：学生&nbsp;&nbsp;&nbsp;教师:'+ data[i].classTch +'</span>';
		    		html+='</div>';
		    		html+='<div class="class-foot">';
		    		html+='<span class="classNotice"><p class="classNotice-top">近期公告：</p>' + "班级介绍" + '</span>';
		    		html+='<span class="classCode"></span>';
		    		html+='<span class="classMember">邀请码：' + data[i].classCode + '<i class="iconfont peng">&#xe677;</i>80</span>';
		    		html+='</div>';
		    		html+='</div>';
    				html+='</a>';

					}
				html+='<div class="exp-add" ><i class="iconfont newClass" id="add">&#xe649;</i></div>';
				document.getElementById("class_list").innerHTML = html;
				
				var newClass = document.getElementsByClassName("newClass")[0];
				var all = document.getElementsByClassName("all")[0];
				var Cannel = document.getElementsByClassName("Cannel")[0];
				newClass.onclick = function() {
					all.style.display = 'block';
				}
				Cannel.onclick = function() {
					all.style.display = 'none';
				}
			}
		}
	}
	xhr.open("GET","ShowTchClassesServlet",true);
	xhr.send();
}


// 创建班级

