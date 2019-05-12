<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign up</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="login-page">
		<div class="form">
			<h1>Authentification</h1>
			<form class="login-form" method="post" action="../Servlet">
				<input type="text" placeholder="login" name="login" /> 
				<input type="password" placeholder="password" name="password" />
				<button>login</button>
				<input type="hidden" name="op" value="connexion">
				<p class="message">
					Not registered? <a href="signup.html">Create an account</a>
				</p>
			</form>
		</div>
	</div>
	<script src="js/main.js"></script>
</body>
</html>