'use strict';
	
	var username = null;
	var stompClient = null;
	var textMessage = document.querySelector("#textMessage");
	var messageArea = document.querySelector("#messageArea");
	var listUser = document.querySelector("#list");
	function connect(){
		username = document.querySelector("#username").innerText.trim();
		var socket = new SockJS("/ws");
		stompClient = Stomp.over(socket);
		stompClient.connect({}, onConnected, onError);
	}
	connect();
	
	function onError(){
		document.querySelector("#errorMessage").innerText = 'Can not connect to server!';
	}
	function onConnected(){
		stompClient.subscribe('/topic/userOnlineList', userListReceived);
		stompClient.subscribe('/topic/publicChatRoom', onMessageReceived);
		stompClient.send('/app/chat.AddUser', {}, JSON.stringify({sender:username,type:'JOIN'}));
	}
	function disconnect(){
		stompClient.send('/app/chat.deleteUser', {}, JSON.stringify({sender:username,type:'LEAVE'}))
	}
	function sendMessage(){
		if(textMessage.value.trim() && stompClient){
			var chatMessage = {
					sender: username,
					type: 'CHAT',
					content: textMessage.value
			}
			stompClient.send("/app/chat.SendMessage",{},JSON.stringify(chatMessage));
			textMessage.value = '';
		}
	}
	function userListReceived(payload){
		var userList = JSON.parse(payload.body);
		var user;
		listUser.textContent = '';
		for(user in userList){
			var li = document.createElement('LI');
			var username = document.createTextNode(userList[user]);
			li.appendChild(username);
			listUser.appendChild(li);
		}
	}
	function onMessageReceived(payload){
		var message = JSON.parse(payload.body);
		var messageContent = null;
		if(message.type==='JOIN'){
			messageContent = message.sender + " joined\n";
		} else if(message.type==='LEAVE'){
			messageContent = message.sender + " leave\n";
		} else{
			messageContent= message.sender + ": " + message.content + "\n"; 
		}
		messageArea.value = messageArea.value + messageContent;
	}