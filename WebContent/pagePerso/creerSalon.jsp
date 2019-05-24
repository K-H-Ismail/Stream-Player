<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="pack.Categorie, java.util.Collection"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Créer Salon</title>
</head>
<body>
	<form method="get" action="Servlet">
		<p>
			<input type="text" placeholder="nom" name="nom" />
		</p>
		<p>
			<input type="text" placeholder="lien" name="lien" />
		</p>
		<p>
			<label for="choose-categorie">Choisir une catégorie:</label> 
			<select	id="choose-categorie" name="categorie" size="2" multiple>
				<%
					Collection<Categorie> listeCategorie = (Collection<Categorie>) request.getAttribute("listeC");
					if (!listeCategorie.isEmpty()) {
						for (Categorie c : listeCategorie) {
							String s = c.getNom();
						%> 
							<option value="<%=s%>"> <%=s%> </option>		
						<%}%>
					<%} %>
			</select>
		</p>
		<input type="submit" value="Créer" /> 
		<input type="hidden" name="op" value="ajoutSalon">
	</form>
	
	<form method="post" action="Servlet">
		<button type="submit">Ajouter Catégorie</button>
		<input type="hidden" name="op" value="pageCategorie">
	</form>
	
	<p>Maintenir la touche Ctrl pour saisir plusieurs choix.</p>
	
</body>
</html>