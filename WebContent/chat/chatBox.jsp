<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Collection"%>

<%@ page import="pack.Message"%>
<%@ page import="pack.Indicateur"%>

<%@ page import="java.util.ArrayList"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="chat/js/main.js"></script>

<link rel="stylesheet" href="chat/css/style.css">

<title>Chat</title>
</head>
<body>


	<%String pseudo = (String) request.getParameter("pseudo"); 	 
	  String idChat = (String) request.getAttribute("idChat"); 	 
 	 %>

	<div id="chat-popup">
	
	  <form class="form-container" name="formEnvoi"> 
	  	<input type="hidden" name=op value=newMsg> 
	  	<input type="hidden" name=pseudo value=<%=pseudo %>> 			
	  	<input id="idChatId" type="hidden" name=idChat value=<%=idChat %>> 		  
	    <h1 style="color:white">ChatRoom</h1>
	
		
	    <div id="chatArea" > 
	    				
	    </div>
	
	    <textarea id="messageArea" placeholder="Type message.." name="message"></textarea>
	
	    <button type="button" class="btn" onclick="envoi(formEnvoi)">Send</button>
	  </form>
	  
	</div>

 	
</body>
</html>