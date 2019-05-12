<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="pack.Compte"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My profile</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
	<%
		Compte compte = (Compte) session.getAttribute("compte");
		String image = (String) compte.getImage();
		String login = (String) compte.getLogin();
	%>
	<h1> <%=login %>'s Profile</h1>
	<img class="avatar" src=<%=image %> alt="profile picture" width="150" height="150" />
</body>
</html>