<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="http://cdn.jsdelivr.net/sockjs/0.3.4/sockjs.min.js"></script>
<script src="https://cdn.bootcss.com/stomp.js/2.3.3/stomp.min.js"></script>
<title>Room Chat Demo</title>
</head>
<body class="container">
	<h2 class="alert alert-info">Room Chat Demo</h2>
	<main class="col-lg-8 col-md-8 col-sm-8">
		<p id="errorMessage" style="color: red"></p>
		<p style="color: red;"><i id="username">${username}</i><a href="/logout" onclick="disconnect()" style="margin-left: 50px;">Log Out</a></p>
		<div>
			<input id="textMessage" type="text" class="form-control" style="overflow-x: scroll;" placeholder="Enter your chat here">
			<input class="btn btn-info" value="Send" onclick="sendMessage()" type="button">
		</div>
		<div style="margin-top: 20px; border-radius: 20px; border-color: blue">
			<textarea id="messageArea" disabled="disabled" class="form-control" style="overflow: scroll;" rows="20" cols="1"></textarea>
		</div>
	</main>
	<aside class="col-lg-4 col-md-4 col-sm-4">
		<div class="panel panel-defaul">
			<div class="panel-heading">
				<b>Users online</b>
			</div>
			<div class="panel-body">
				<ul id="list">
				</ul>
			</div>
		</div>
	</aside>
	<script src="/script.js">
	</script>
</body>
</html>