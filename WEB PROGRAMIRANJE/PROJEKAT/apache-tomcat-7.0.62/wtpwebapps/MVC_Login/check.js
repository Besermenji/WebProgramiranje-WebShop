function checkLogin(p){
	var username = document.forms["f"]["usrname"].value;
	var pwd = document.forms["f"]["pwd"].value;
	var x = username.substring(0,1);
	var t = p.parentNode.nodeName;

	if(username == "" || username == null){
		document.getElementById("message").innerHTML = "username empty!";
		//alert("empyu");
		return false;
	}
	else if(pwd == "" || pwd == null){
		document.getElementById("message").innerHTML = "password empty!";
		return false;
	}
	else if(x == x.toLowerCase()){
		document.getElementById("message").innerHTML = "username small!";
		return false;
	}
	
	
	  
}

