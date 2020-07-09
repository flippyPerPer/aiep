window.onload = function(){
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
			    html+=    '<ul style="border: 1px;">'
				html+=	'<li class="title" >'+ data[i].expName +'</li>'
				html+=	'<br />'	
				html+=	'<li class="information">'+ data[i].expInfo +'</li>'
				html+=	'<br />'
				html+='</ul> '          
				}
				document.getElementsByClassName("data")[0].innerHTML += html;
            }
        }
	}
	var str = window.location.href;
	if(/\?/.test(str)){
		var urlString = str.substring(str.indexOf("=")+1);
		xhr.open("POST","DoExpServlet",true);
		xhr.setRequestHeader('content-type','application/x-www-form-urlencoded');
		xhr.send("id=" + urlString);
	}
}