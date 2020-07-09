
var str = window.location.href;
if(/\?/.test(str)){
	var urlString = str.substring(str.indexOf("=")+1);
	console.log(urlString);
}
