<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="pack.Salon, java.util.Collection"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rejoindre Salon</title>
</head>
<body>
Liste des salons: <br>
	<%Collection<Salon> listeSalons = (Collection<Salon>) request.getAttribute("listeS");
	  if (!listeSalons.isEmpty()) {
		for (Salon s : listeSalons) {
			String nomSalon = s.getNom();
			String lienSalon = s.getLien();
	 %>
	  			<%=nomSalon%> : <a href="<%=lienSalon %>"><%=lienSalon %></a> <br> 
	   	  <%} %>
	  <%}%>

</body>
</html>