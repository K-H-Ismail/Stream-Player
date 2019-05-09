<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="pack.CreationCompte, java.util.Map"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error Sign up</title>
<link rel="stylesheet" type="text/css" href="signup/css/style.css">
</head>
<body>
	<%
	  CreationCompte form = (CreationCompte) request.getAttribute("form");
	  Map<String, String> erreurs = (Map<String, String>) form.getErreurs();
	  String erreurLogin = erreurs.get("login");
	  String erreurPassword = erreurs.get("password");
	  String erreurEmail = erreurs.get("email");
	%>
	
	<div class="login-page">
		<div class="form">
			<form class="register-form" method="post" action="Servlet">
				<input type="text" placeholder="login" name="login" /> 
				
				<% if (erreurLogin!= null) {%>
				<span class="erreur"> <%=erreurLogin%> </span> 
				<%} %>
			
				<input type="password" placeholder="password" name="password" /> 
				
				<% if (erreurPassword!= null) {%>
				<span class="erreur"> <%=erreurPassword%> </span> 
				<%} %>
				
				<input type="text" placeholder="email address" name="email" /> 
				
				<% if (erreurEmail!= null) {%>
				<span class="erreur"> <%=erreurEmail%> </span> 
				<%} %>

				<button>Create</button>
				<input type="hidden" name="op" value="ajoutCompte">
				
				<p class="message">
					Already registered? <a href="signup/loginPage.jsp">Sign In</a>
				</p>
			</form>
		</div>
	</div>
</body>
</html>