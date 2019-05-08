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
			<form class="login-form" method="post">
				<input type="text" placeholder="name" name="un" /> <input
					type="password" placeholder="password" name="pw" />
				<button>login</button>
				<input type="hidden" name="op" value="connection">
				<p class="message">
					Not registered? <a href="signup.html">Create an account</a>
				</p>
			</form>
		</div>
	</div>
	<script src="js/main.js"></script>
</body>
</html>