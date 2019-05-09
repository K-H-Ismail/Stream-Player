<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="pack.Compte, pack.Utilisateur"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="topnav">
		<a class="active" href="./index.html">Accueil</a> <a
			href="./signup/signup.html">Inscription</a> <a
			href="./signup/loginPage.jsp">Connection</a>
	</div>
	<center>
		<%
			Utilisateur utilisateur = (Utilisateur) session.getAttribute("sessionUtilisateur");
			String login = (String) utilisateur.getLogin();
		%>
		Welcome
		<%=login%>
		<form action="Servlet" method="get">
			<input type="hidden" type="text" name="op" value="add_friend">
			<form class="searchform cf">
				<input type="text" name="login" placeholder="Ajouter un ami">
				<button type="submit">Ajouter</button>
			</form>

			<form method="post" action="Servlet">
				<button>Se déconnecter</button>
				<input type="hidden" name="op" value="logout">
			</form>
	</center>

</body>
</html>