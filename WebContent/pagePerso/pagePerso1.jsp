<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="pack.Compte, pack.Utilisateur"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
</head>
<body>
	<center>
		<%
			Utilisateur utilisateur = (Utilisateur) session.getAttribute("sessionUtilisateur");
			String login = (String) utilisateur.getLogin();
		%>
		Welcome <%=login%>
		<form method="post" action="Servlet">
		<button>Se déconnecter</button>
		<input type="hidden" name="op" value="logout">
		</form>

	</center>

</body>
</html>