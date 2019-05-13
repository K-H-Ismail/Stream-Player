<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="pack.Utilisateur"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
<link type="text/css" rel="stylesheet" href="pagePerso/css/style.css">
</head>
<body>
	<div class="topnav">
		<a class="active" href="index.html">Accueil</a> 
		<a href="pagePerso/profile.jsp">Profil</a>
		<div class="topnav-right">
			<a href="Servlet?op=logout">Se déconnecter</a>
		</div>
			
	</div>
	<center>
		<%
			Utilisateur utilisateur = (Utilisateur) session.getAttribute("sessionUtilisateur");
			String login = (String) utilisateur.getLogin();
		%>
		<h1>Welcome <%=login%></h1>

		<form class="searchform cf" method="post" action="Servlet">
			<input type="text" name="login" placeholder="Ajouter un ami">
			<button type="submit">Ajouter</button>
			<input type="hidden" type="text" name="op" value="add_friend">
		</form>
		
		<form>
        	<button type="submit" formaction="pagePerso/upload.jsp">Upload Fichier</button>
      	</form>
      	
      	<form method="post" action="Servlet">
        	<button type="submit">Créer un salon</button>
        	<input type="hidden" type="text" name="op" value="creerSalon">
      	</form>
      	
      	<form method="post" action="Servlet">
        	<button type="submit">Rejoindre un salon</button>
        	<input type="hidden" type="text" name="op" value="rejoindreSalon">
      	</form>

	</center>

</body>
</html>