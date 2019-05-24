<%@page import="java.util.concurrent.TimeUnit"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="pack.Compte, java.lang.Process, java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
</head>
<body>


	<div class="topnav">
		<a class="active" href="../index.html">Accueil</a> <a href="../signup/signup.html">Inscription</a> <a
			href="../signup/loginPage.jsp">Connexion</a>
	</div>
		<form class="register-form" method="post" action=<%
				if (request.getParameter("submit") != null) {
					
					String command = "gnome-terminal";
		            Process child = Runtime.getRuntime().exec(command);

		            child.waitFor();
					
				
				}
			%>>

					<input class="searchform" type="submit" value="Stream it!" name="submit">
		</form>
		


</body>
</html>