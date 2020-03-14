<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Login</title>
</head>
<body>
	<main class="container">
		<h2 class="alert alert-info">Login</h2>
		<form action="/login" method="post" class="form-group">
			<input name="username" id="username" class="form-control" type="text" placeholder="Choose your user name">
			<br><button class="btn btn-success" type="submit">Login</button>
		</form>
	</main>
</body>
</html>