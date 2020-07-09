var navTopRight = document.getElementsByClassName("nav-top-right")[0];
var tips = document.getElementById("tips");
var addClass = document.getElementsByClassName("join")[0];
var Cannel = document.getElementsByClassName("Cannel")[0];
var classAll = document.getElementsByClassName("all")[0];

addClass.onclick = function(){
	classAll.style.display = 'block';
}
Cannel.onclick = function(){
	classAll.style.display = 'none';
}

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