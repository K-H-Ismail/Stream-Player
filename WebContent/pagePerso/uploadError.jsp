<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="pack.UploadFichier, java.util.Map"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error upload</title>
</head>
<body>
	<%
		UploadFichier form = (UploadFichier) request.getAttribute("form");
		Map<String, String> erreurs = (Map<String, String>) form.getErreurs();
		String erreurDescription = erreurs.get("description");
		String erreurFichier = erreurs.get("fichier");
	%>
	
	<form method="post" enctype="multipart/form-data" action="../Servlet">
		<input type="text" placeholder="description" name="description" />
		<% if (erreurDescription!= null) {%>
		<span class="erreur"> <%=erreurDescription%> </span> 
		<%} %>
		
		<input type="file" id="fichier" name="fichier" />
		<% if (erreurFichier!= null) {%>
		<span class="erreur"> <%=erreurFichier%> </span> 
		<%} %>
		
	    <input type="submit" value="Envoyer" /> 
	    <input type="hidden" name="op" value="upload">
	</form>
</body>
</html>