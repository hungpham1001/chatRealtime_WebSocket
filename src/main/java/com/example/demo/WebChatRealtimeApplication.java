package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@SpringBootApplication
@EnableWebSocket
public class WebChatRealtimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebChatRealtimeApplication.class, args);
	}

}
