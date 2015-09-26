<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<script type="text/javascript" src = "check.js">  </script>
</head>
<body onload="return provera()">
<h3>Login</h3>
<br>
<p id="message"></p>
<form  name = "f" method="post" action= "login" onsubmit="return checkLogin(this)">
<p>Username: <input type="text" name = "usrname" /></p>
<p>Password: <input type="password" name = "pwd" /></p>
<br>
<button type="submit">Login</button>
</form>

</body>
</html>