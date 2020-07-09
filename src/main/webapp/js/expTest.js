var oliList = document.getElementsByClassName("liList");
var oexpName = document.getElementsByClassName("expName");
var expCont = document.getElementsByClassName("exp-cont")[0];
var pageLi = document.getElementsByClassName("pageItem");
var expList = document.getElementsByClassName("expList");
var oMian;
var flagNum;
var b = false;//实验列表刷新标记
var htmlPage;
var times = 0;
var mydata;
var userFlag;
var html = '<span id="expTitle">实验列表 <i class="iconfont">&#xe619;</i></span><hr />';
var loginStatus = document.getElementsByClassName("nav-top-right")[0];
var unLoginStatus = document.getElementsByClassName("unLogin")[0];
var loginFlag = true;
var xhr_1 = new XMLHttpRequest();
//用户登录信息
xhr_1.onreadystatechange = function() {
	if (xhr_1.readyState == 4) {
		if (xhr_1.status.toString().charAt(0) == "2" || xhr_1.status == 304) {
			var data = xhr_1.responseText;
			if (typeof data != "object") {
				data = JSON.parse(data);
				if (data.stateNumber == 1) {
					userFlag = data.stateNumber;
					unLoginStatus.style.display = 'none';
					loginStatus.style.display = 'block';
					var useImg = document.getElementById("useImg");
					var useName = document.getElementsByClassName("useName")[0];
					useImg.innerHTML = data.userName;
					useName.innerHTML = data.userName;
				}else if(data.stateNumber == 2){
					userFlag = data.stateNumber;
					unLoginStatus.style.display = 'none';
					loginStatus.style.display = 'block';
					var useImg = document.getElementById("useImg");
					var useName = document.getElementsByClassName("useName")[0];
					useImg.innerHTML = data.stuName;
					useName.innerHTML = data.stuName;
				}else if(data.stateNumber == 3){
					userFlag = data.stateNumber;
					unLoginStatus.style.display = 'none';
					loginStatus.style.display = 'block';
					var useImg = document.getElementById("useImg");
					var useName = document.getElementsByClassName("useName")[0];
					useImg.innerHTML = data.tchName;
					useName.innerHTML = data.tchName;
				}
				if(data == 0){
					loginFlag = false;
				}
			}
		}
	
	}
}
xhr_1.open("post", "checkLoginServlet", true);
xhr_1.send(null);



function str(){
	for(var k = 0; k < expList.length; k++){
		expList[k].style.display = "none";
	}
	expList[this.index].style.display = "block";
}

//实验列表信息
window.onload = function(){
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status.toString().charAt(0) == "2"||xhr.status == "304"){
				var data = xhr.responseText;
				if(typeof data != "object"){
					data = JSON.parse(data);
					mydata = data;
					b =true;
					var pageNum = Math.ceil(data.length/8);
					oMian = pageNum;
					for( var i = 0; i < pageNum; i ++){
						html += '<div class="expList"><ul>';
						for( var k = 0; k < 8; k ++, times++){
							if(times >= data.length){
								break;
							}else{
								html += '<li class="liList" data-num=' + data[k].expID + '>' + '<div class="expImg">' + '<img src="' + data[times].expURLPic + '"/>' + '</div><div class="expName"><div class="pn">' + data[times].expName + '</div><div class="pn-content">'; 
								html += data[times].expInfo + '</div></div><div class="expFoot"><span id="exp-tips" class="iconfont">&#xe614;</span><span id="exp-numPer">1</span></div><>';
							}
						}
						html += '</ul></div>';
					}
					expCont.innerHTML = html;
					for(var i = 0; i < oliList.length; i++){
						oliList[i].index = i;
						oliList[i].onmouseover = function(){
							oexpName[this.index].style.top = 90 + 'px';
						}
						oliList[i].onmouseout = function(){
							oexpName[this.index].style.top = 150 + 'px';
						}
						if(loginFlag){
							oliList[i].onclick = function(){
							var a = this.getAttribute("data-num");
							console.log(a);
							url = 'doExperiment.jsp?num=' + a;
							window.location.href = url;
							console.log(url);
							}
						}else{
							oliList[i].onclick = function() {
								alert("请先登录");
								window.location.href = "HomePage.jsp";
							}
						}
					}
					if(b){
						var exp_page = document.getElementsByClassName("exp-page-mid")[0];
						htmlPage = '<ul class="pagination" id="pages">';
						for(var i = 0; i < oMian; i ++){
							htmlPage += '<li class="page-item pageItem"><a class="page-link">' + (i+1) + '</a><>';
						}
						htmlPage += '</ul>';
						exp_page.innerHTML = htmlPage;
						for(var i = 0; i < pageLi.length; i++)
						{
							pageLi[i].index = i;
							pageLi[i].onclick = str;
						}
					}
				}
			}
		}
		
	}
	xhr.open("post","ExpListServlet",true);
	xhr.send(null);
}



//导航栏下拉菜单
var navTopRight = document.getElementsByClassName("nav-top-right")[0];
var tips = document.getElementById("tips");
navTopRight .onmouseover = function(){
	navTopRight.style.height = 250 + 'px';
	tips.style.transform = 'rotate(' + 0 + 'deg)';
	tips.style.color = '#1277EB';
}
navTopRight.onmouseout = function(){
	navTopRight.style.height = 60 + 'px';
	tips.style.transform = 'rotate(' + 90 + 'deg)';
	tips.style.color = '#FFFFFF';
}

var userList = document.getElementsByClassName("lis")[0];
userList.onclick = function(){
	if(userFlag == 3){
		url = 'teacherPage.jsp';
		window.location.href = url;
	}
	else if(userFlag == 2){
		url = "studentPage.jsp"
		window.location.href = url;
	}
	else if(userFlag == 1){
		url = "myClass.jsp"
		window.location.href = url;
	}
}
var userList3 = document.getElementsByClassName("lis")[3];
userList3.onclick = function(){
	url = "HomePage.jsp"
	window.location.href = url;
}
