<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="pack.Compte, java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My profile</title>
<link type="text/css" rel="stylesheet" href="pagePerso/css/style.css">
</head>
<body>
	<%
		Compte compte = (Compte) request.getAttribute("compte");
		String image = (String) compte.getImage();
		String login = (String) compte.getLogin();
		List<Compte> souscriptions = compte.getSouscriptions();
	%>
	<h1> <%=login %>'s Profile</h1>
	<img class="avatar" src="pagePerso/<%=image %>" alt="profile picture" width="150" height="150" /> <br>
	
	<h2>Mes souscriptions:</h2>
	<% for (Compte c : souscriptions) {
	      	String nom = c.getLogin(); %>
			<font size="3"><%=nom %></font> <br>
	 <%} %>
</body>
</html>