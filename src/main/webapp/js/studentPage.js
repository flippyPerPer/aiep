var navTopRight = document.getElementsByClassName("nav-top-right")[0];
var tips = document.getElementById("tips");

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

var con_left = document.getElementsByClassName("con-left")[0];
var Li = document.getElementsByClassName("liList");
var oScetion = document.getElementsByClassName("scetion");

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

// 弹窗
var addClass = document.getElementsByClassName("join")[0];
var Cannel = document.getElementsByClassName("Cannel")[0];
var classAll = document.getElementsByClassName("all")[0];

addClass.onclick = function() {
	classAll.style.display = 'block';
}
Cannel.onclick = function() {
	classAll.style.display = 'none';
}

//班级
Li[1].addEventListener('click', addExper);
function addExper() {
	var html = "";
	var xhr;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(this.readyState == 4){
			if(this.status.toString().charAt() == "2"||this.status == "304"){
				var data = xhr.responseText;
				if(typeof data != "object"){
					data = JSON.parse(data);
				}
				for(var i in data){
		    	html+='<div class="classList" data-id='+ data[i].classCode +'>';
		    	html+='<div class="class-top" style="background-image: url('+ "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1573905503399&di=7d9dc058f5f74fb4386b15b97a90431a&imgtype=0&src=http%3A%2F%2Fs2.sinaimg.cn%2Fmw690%2F007E0FjJzy7sgSrGjKN41" +');">';
		    	html+='<span class="className">'+data[i].className +'</span>';
		    	html+='<span class="classIntro">'+"教师: "+data[i].classTch +'</span>';
		    	html+='</div>';
		    	html+='<div class="class-foot">';
		    	html+='<span class="classNotice"><p class="classNotice-top">近期公告：</p>' + "班级介绍" + '</span>';
		    	html+='<span class="classCode"></span>';
		    	html+='<span class="classMember">邀请码：'+data[i].classCode+ '<i class="iconfont peng">&#xe677;</i>'+80+'</span>';
		    	html+='</div>';
		    	html+='</div>';                            
				}
				oScetion[1].innerHTML += html;
				var classList = document.getElementsByClassName("classList");
				for(var k in classList){
					classList[k].onclick = function(){
					var a = this.getAttribute("data-id");
					url = 'addExperiment.jsp?num=' + a;
					window.location.href = url;
					}
				}
			}
		}
}
	xhr.open("GET", "ShowStuClassesServlet", true);
	xhr.send();
}