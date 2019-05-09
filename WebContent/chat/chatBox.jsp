<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Collection"%>
<%@ page import="pack.Message"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chat</title>
</head>
<body>



	<%
		String pseudo = (String) request.getParameter("pseudo");
	%>
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<link
		href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"
		rel="stylesheet">
	<script
		src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

	<script src="//cdn.pubnub.com/pubnub.min.js"></script>
	<form action="Servlet" method="get">
		<div class="col-md-6">
			<div class="panel panel-default">
				<div class="panel-heading">Live Chat</div>
				<ul class="list-group" id="chat-output"
					style="height: 150px; overflow-y: scroll;"></ul>
				<%
					Collection<Message> listeMessage = (Collection<Message>) request.getAttribute("listeMessage");
					for (Message m : listeMessage) {
						String user = m.getUser();
						String text = m.getText();
				%>
				<%=user%>
				:
				<%=text%>
				<br>
				<%
					}
				%>

				<div class="panel-body">
					<form id="chat">
						<div class="input-group">
							<input type="hidden" name=op value=newMsg> <input
								type="hidden" name=pseudo value=<%=pseudo%>> <input
								type="text" class="form-control" name="message" /> <span
								class="input-group-btn">
								<button type="submit" class="btn btn-default">Send
									Message</button>
							</span>
						</div>
					</form>
				</div>
			</div>
		</div>

	</form>
	<script src="main.js" ></script>


</body>
</html>