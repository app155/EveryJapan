package com.globalin.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.globalin.chat.model.MultiChatEndPoint;
import com.globalin.chat.service.ChatService;

@Component
public class WebSocketInitializer {
	@Autowired ChatService chatService;
	
	@PostConstruct
	public void Init() {
		MultiChatEndPoint.chatService = chatService;
		System.out.println("✅ WebSocket chatService 초기화 완료: " + chatService);
	}
}
