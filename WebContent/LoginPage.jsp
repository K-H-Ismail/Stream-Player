<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="pack.Compte"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<form method="post" action="Servlet">
		<p>
			Login : <input type="text" name="un" /><br>
		</p>
		<p>
			Password : <input type="password" name="pw" />
		</p>
		<p>
			<input type="submit" value="Se connecter"> 
			<input type="hidden" name="op" value="connection">
		</p>
	</form>
</body>
</html>