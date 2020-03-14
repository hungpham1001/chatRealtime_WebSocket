package com.example.demo.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

import com.example.demo.Server.Message.ChatMessage;

@Controller
public class WebSocketController {
	@Autowired
	SimpMessageSendingOperations messageSending;
	private Map<String, String> map = new HashMap<String, String>();
	@MessageMapping("/app/chat.AddUser")
	@SendTo("/topic/publicChatRoom")
	public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		map.put(chatMessage.getSender(), chatMessage.getSender());
		messageSending.convertAndSend("/topic/userOnlineList", map);
		return chatMessage;
	}
	@MessageMapping("/app/chat.deleteUser")
	@SendTo("/topic/publicChatRoom")
	public ChatMessage deleteUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		//headerAccessor.getSessionAttributes().remove(chatMessage.getSender());
		map.remove(chatMessage.getSender());
		messageSending.convertAndSend("/topic/userOnlineList", map);
		return chatMessage;
	}
	
	@MessageMapping("/app/chat.SendMessage")
	@SendTo("/topic/publicChatRoom")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
		return chatMessage;
	}
}
