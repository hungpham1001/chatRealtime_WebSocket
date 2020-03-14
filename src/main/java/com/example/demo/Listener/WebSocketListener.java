package com.example.demo.Listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.example.demo.Server.Message.ChatMessage;
import com.example.demo.Server.Message.ChatMessage.MessageType;

@Component
public class WebSocketListener{
	@Autowired
	private SimpMessageSendingOperations messageTemplate;
	
	@EventListener
	public void	handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
		StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
		String userName = (String) headerAccessor.getSessionAttributes().get("username");
		if(userName!=null) {
			ChatMessage message = new ChatMessage();
			message.setSender(userName);
			message.setType(MessageType.LEAVE);
			messageTemplate.convertAndSend("/topic/publicChatRoom",message);
		}
	}
}
