
/*注册表单切换*/
var oRe = document.getElementsByClassName("Re");
var oForm = document.getElementsByClassName("form");
var oSection = document.getElementsByClassName("section")[0];
var ver_Rshow = document.getElementsByClassName("ver_Rshow");
for(var i = 0; i < oRe.length; i++){
	oRe[i].index = i; 
	oRe[i].onclick = function(){
		oSection.style.height = 720 + "px";
		for(var k = 0; k < oRe.length; k ++){
			oRe[k].className = "Re";
			oForm[k].className = "form formNone";
			ver_Rshow[k].style.top = 625 + "px";
		}
		this.className = "Re reActive";
		if(this.index == 2){
			oForm[this.index].className = "form";
		}else{
			oForm[this.index].className = "form";
			oSection.style.height = 800 + "px";
			ver_Rshow[this.index].style.top = 710 + "px";
		}
	}
}

/*学生表输出框底边样式*/

var oSinp_border = document.getElementsByClassName("Sinp_border");
var osipsShow = document.getElementsByClassName("stipsShow");
for (var i = 0; i < oSinp_border.length; i ++)
{
	oSinp_border[i].index = i;
	oSinp_border[i].onfocus = function(){
		for(var k = 0; k < oSinp_border.length; k ++)
		{
			osipsShow[k].className = "tips stipsShow";
		}
	osipsShow[this.index].className = "tips stipsShow tipsActive";
	}
} 
/*教师表输出框底边样式*/
var oTinp_border = document.getElementsByClassName("Tinp_border");
var otipsShow = document.getElementsByClassName("ttipsShow");
for (var i = 0; i < oTinp_border.length; i ++)
{
	oTinp_border[i].index = i;
	oTinp_border[i].onfocus = function(){
		for(var k = 0; k < oTinp_border.length; k ++)
		{
			otipsShow[k].className = "tips ttipsShow";
		}
	otipsShow[this.index].className = "tips ttipsShow tipsActive";
	}
}
/*普通用户表输出框底边样式*/
var oOinp_border = document.getElementsByClassName("Oinp_border");
var ootipsShow = document.getElementsByClassName("otipsShow");
for (var i = 0; i < oOinp_border.length; i ++)
{
	oOinp_border[i].index = i;
	oOinp_border[i].onfocus = function(){
		for(var k = 0; k < oOinp_border.length; k ++)
		{
			ootipsShow[k].className = "tips otipsShow";
		}
	ootipsShow[this.index].className = "tips otipsShow tipsActive";
	}
}
 
 
 

/*学生表*/
var oStu_na = document.getElementById("stu_na");
var oStu_pw = document.getElementById("stu_pw");
var oStu_Rpw = document.getElementById("stu_Rpw");
var oStu_user = document.getElementById("stu_user");
var oStu_sch = document.getElementById("stu_sch");
var oStu_p = document.getElementById("stu_p");
var oStu_ph = document.getElementById("stu_ph");

var oSNshow = document.getElementById("SNshow");
var oSPshow = document.getElementById("SPshow");
var oSRPshow = document.getElementById("SRPshow");
var oSusershow = document.getElementById("SUsershow");
var oSSCshow = document.getElementById("SSCshow");
var oSPOshow = document.getElementById("SPOshow");
var oSPHshow = document.getElementById("SPHshow");
function studentsCheck(){
	var flag = true;
	var Snumber = /^[0-9]{6,16}$/;
	var Spassword = /^[a-z0-9A-Z]{6,18}$/;
	var Spostbox = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	var Sphone = /^[1][3-9]{1}[0-9]{9}$/;
	oSNshow.innerHTML = "";
	oSPshow.innerHTML = "";
	oSRPshow.innerHTML = "";
	oSusershow.innerHTML = "";
	oSSCshow.innerHTML = "";
	oSPOshow.innerHTML = "";
	oSPHshow.innerHTML = "";
	if(oStu_na.value == null||oStu_na.value == ""){
		oSNshow.innerHTML = "*账号不能为空！";
		flag = false;
	}
	if(!Snumber.test(oStu_na.value)){
		oSNshow.innerHTML = "*请输入6-16位学号";
		flag = false;
	}
	if(oStu_pw.value == null||oStu_pw.value == ""){
		oSPshow.innerHTML = "*密码不能为空！";
		flag = false;
	}
	if(!Spassword.test(oStu_pw.value)){
		oSPshow.innerHTML = "*请输入6-18任意数字或字母";
		flag = false;
	}
	if(oStu_Rpw.value == null||oStu_Rpw.value == ""){
		oSRPshow.innerHTML = "密码不能为空！";
		flag = false;
	}
	if(oStu_Rpw.value != oStu_pw.value){
		oSRPshow.innerHTML = "*两次密码不一致！";
		flag = false;
	}
	if(oStu_user.value == null||oStu_user.value == ""){
		oSusershow.innerHTML = "姓名不能为空！";
		flag = false;
	}
	if(oStu_sch.value == null||oStu_sch.value == ""){
		oSSCshow.innerHTML = "*学校名不能为空！";
		flag = false;
	}
	if(oStu_p.value == null||oStu_p.value == ""){
		oSPOshow.innerHTML = "*邮箱地址不能为空！";
		flag = false;
	}
	if(!Spostbox.test(oStu_p.value)){
		oSPOshow.innerHTML = "*请输入正确邮箱地址";
		flag = false;
	}
	if(oStu_ph.value == null||oStu_ph.value == ""){
		oSPHshow.innerHTML = "*手机号不能为空！";
		flag = false;
	}
	if(!Sphone.test(oStu_ph.value)){
		oSPHshow.innerHTML = "*请输入正确手机号";
		flag = false;
	}
	return false;
}
/*教师表*/
var oTea_na = document.getElementById("tea_na");
var oTea_pw = document.getElementById("tea_pw");
var oTea_Rpw = document.getElementById("tea_Rpw");
var oTea_user = document.getElementById("tea_user");
var oTea_sch = document.getElementById("tea_sch");
var oTea_p = document.getElementById("tea_p");
var oTea_ph = document.getElementById("tea_ph");

var oTNshow = document.getElementById("TNshow");
var oTPshow = document.getElementById("TPshow");
var oTRPshow = document.getElementById("TRPshow");
var oTUsershow = document.getElementById("TUsershow");
var oTSCshow = document.getElementById("TSCshow");
var oTPOshow = document.getElementById("TPOshow");
var oTPHshow = document.getElementById("TPHshow");
function teachersCheck(){
	var flag = true;
	var Snumber = /^[0-9]{6,16}$/;
	var Spassword = /^[a-z0-9A-Z]{6,18}$/;
	var Spostbox = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	var Sphone = /^[1][3-9]{1}[0-9]{9}$/;
	oTNshow.innerHTML = "";
	oTPshow.innerHTML = "";
	oTRPshow.innerHTML = "";
	oTUsershow.innerHTML = "";
	oTSCshow.innerHTML = "";
	oTPOshow.innerHTML = "";
	oTPHshow.innerHTML = "";
	if(oTea_na.value == null||oTea_na.value == ""){
		oTNshow.innerHTML = "*账号不能为空！";
		flag = false;
	}
	if(!Snumber.test(oTea_na.value)){
		oTNshow.innerHTML = "*请输入6-16位学号";
		flag = false;
	}
	if(oTea_pw.value == null||oTea_pw.value == ""){
		oTPshow.innerHTML = "*密码不能为空！";
		flag = false;
	}
	if(!Spassword.test(oTea_pw.value)){
		oTPshow.innerHTML = "*请输入6-18任意数字或字母";
		flag = false;
	}
	if(oTea_Rpw.value == null||oTea_Rpw.value == ""){
		oTRPshow.innerHTML = "*密码不能为空！";
		flag = false;
	}
	if(oTea_Rpw.value != oTea_pw.value){
		oTRPshow.innerHTML = "*两次密码不一致！";
		flag = false;
	}
	if(oTea_user.value == null||oTea_user.value == ""){
		oTUsershow.innerHTML = "*姓名不能为空！";
		flag = false;
	}
	if(oTea_sch.value == null||oTea_sch.value == ""){
		oTSCshow.innerHTML = "*学校名不能为空！";
		flag = false;
	}
	if(oTea_p.value == null||oTea_p.value == ""){
		oTPOshow.innerHTML = "*邮箱地址不能为空！";
		flag = false;
	}
	if(!Spostbox.test(oTea_p.value)){
		oTPOshow.innerHTML = "*请输入正确邮箱地址";
		flag = false;
	}
	if(oTea_ph.value == null||oTea_ph.value == ""){
		oTPHshow.innerHTML = "*手机号不能为空！";
		flag = false;
	}
	if(!Sphone.test(oTea_ph.value)){
		oTPHshow.innerHTML = "*请输入正确手机号";
		flag = false;
	}
	return flag;
}

/*普通用户表*/
var oOr_na = document.getElementById("or_na");
var oOr_pw = document.getElementById("or_pw");
var oOr_Rpw = document.getElementById("or_Rpw");
var oOr_sch = document.getElementById("or_sch");
var oOr_p = document.getElementById("or_p");
var oOr_ph = document.getElementById("or_ph");

var oONshow = document.getElementById("ONshow");
var oOPshow = document.getElementById("OPshow");
var oORPshow = document.getElementById("ORPshow");
var oOSCshow = document.getElementById("OSCshow");
var oOPOshow = document.getElementById("OPOshow");
var oOPHshow = document.getElementById("OPHshow");
function ordinaryUsersCheck(){
	var flag = true;
	var Snumber = /^[a-z0-9A-Z]{6,16}/;
	var Spassword = /^[a-z0-9A-Z]{6,18}$/;
	var Spostbox = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	var Sphone = /^[1][3-9]{1}[0-9]{9}$/;
	oONshow.innerHTML = "";
	oOPshow.innerHTML = "";
	oORPshow.innerHTML = "";
	oOSCshow.innerHTML = "";
	oOPOshow.innerHTML = "";
	oOPHshow.innerHTML = "";
	if(oOr_na.value == null||oOr_na.value == ""){
		oONshow.innerHTML = "*账号不能为空！";
		flag = false;
	}
	if(!Snumber.test(oOr_na.value)){
		oONshow.innerHTML = "*请设置6-16位账号";
		flag = false;
	}
	if(oOr_pw.value == null||oOr_pw.value == ""){
		oOPshow.innerHTML = "*密码不能为空！";
		flag = false;
	}
	if(!Spassword.test(oOr_pw.value)){
		oOPshow.innerHTML = "*请输入6-18任意数字或字母";
		flag = false;
	}
	if(oOr_Rpw.value == null||oOr_Rpw.value == ""){
		oORPshow.innerHTML = "*两次密码不一致！";
		flag = false;
	}
	if(oOr_Rpw.value != oOr_pw.value){
		oORPshow.innerHTML = "*两次密码不一致！";
		flag = false;
	}
	if(oOr_sch.value == null||oOr_sch.value == ""){
		oOSCshow.innerHTML = "*地址不能为空！";
		flag = false;
	}
	if(oOr_p.value == null||oOr_p.value == ""){
		oOPOshow.innerHTML = "*邮箱地址不能为空！";
		flag = false;
	}
	if(!Spostbox.test(oOr_p.value)){
		oOPOshow.innerHTML = "*请输入正确邮箱地址";
		flag = false;
	}
	if(oOr_ph.value == null||oOr_ph.value == ""){
		oOPHshow.innerHTML = "*手机号不能为空！";
		flag = false;
	}
	if(!Sphone.test(oOr_ph.value)){
		oOPHshow.innerHTML = "请输入正确手机号";
		flag = false;
	}
	return flag;
}


