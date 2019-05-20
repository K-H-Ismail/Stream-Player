<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Collection"%>

<%@ page import="pack.Message"%>
<%@ page import="pack.Indicateur"%>

<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="chat/css/style.css">

<title>Chat</title>
</head>
<body>


	<%String pseudo = (String) request.getParameter("pseudo"); 	 
	  Indicateur ind = (Indicateur) request.getAttribute("nvMessage");
 	 %>

	
	<div class="chat-popup" id="myForm">
	  <form action="Servlet" method="get" class="form-container">
	  	<input type="hidden" name=op value=newMsg> 
	  	<input type="hidden" name=pseudo value=<%=pseudo %>> 			
	  
	    <h1>ChatRoom</h1>
	
		<h2> <%=ind.getnvMessage()%></h2>
		
	    <div id ="chatArea" > 
	    				<%
					Collection<Message> listeMessage = (Collection<Message>) request.getAttribute("listeMessage");
					for (Message m : listeMessage) {
						String user = m.getUser();
						String text = m.getText();
						String heure = m.getDate();
						if(text.equals("true")){
							ind.setnvMessage(true);
							text = "reussiTrue";
						}else if (text.equals("false")){
							ind.setnvMessage(false);
							text = "reussiFalse";
						}
				%>
				<div id="message"> 
				(<%=heure%>) <B><%=user%></B> : <%=text%> 
				 </div>
				 
				 <%}%>  
	    </div>
	
	    <textarea id="messageArea" placeholder="Type message.." name="message" required></textarea>
	
	    <button type="submit" class="btn">Send</button>
	    <button type="button" class="btn cancel" onclick="closeForm()"> Disconnect</button>
	  </form>
	  
	</div>

 	
</body>
</html>