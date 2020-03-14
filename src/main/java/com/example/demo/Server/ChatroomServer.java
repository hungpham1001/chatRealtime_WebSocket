package com.example.demo.Server;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/chatRoom")
public class ChatroomServer {
	static Set<Session> users = Collections.synchronizedSet(new HashSet<>());
	
	@OnOpen
	public void handleOpen(Session session) {
		users.add(session);
	}
	
	@OnMessage
	public void handleMessage(String message, Session userSession) throws IOException {
		String userName = (String) userSession.getUserProperties().get("username");
		if(userName.isEmpty()) {
			userSession.getUserProperties().put("username", message);
			userSession.getBasicRemote().sendText("You are connected as: "+userName);
		} else {
			for(Session users: users) {
				users.getBasicRemote().sendText(message);
			}
		}
	}
	
	@OnClose
	public void handleDelete(Session session) throws IOException {
		users.remove(session);
		for(Session users: users) {
			users.getBasicRemote().sendText(session.getUserProperties().get("username")+ " out");
		}
	}
	
	@OnError
	public void handleError(Throwable e) {
		e.printStackTrace();
	}
}
