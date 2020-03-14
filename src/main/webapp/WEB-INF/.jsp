<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Room Chat Demo</title>
</head>
<body>
	<main class="container">
		<h2 class="alert alert-info">Room Chat Demo</h2>
		<div>
			<input id="textMessage" class="col-lg-10" style="overflow: scroll;" type="text" placeholder="Enter your chat here">
			<input class="btn btn-info" value="Send" type="button">
		</div>
		<div>
			<textarea id="messageArea" style="overflow: scroll;" rows="20" cols="50"></textarea>
		</div>
	</main>
	<script type="text/javascript">
		var webSocket = new WebSocket("ws://localhost:8080/")
	</script>
</body>
</html>