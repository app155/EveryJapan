package com.globalin.chat.model;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

import com.globalin.util.HttpSessionConfigurator;

@ServerEndpoint(value = "/chat", configurator = HttpSessionConfigurator.class)
public class MultiChatEndPoint {
	// 방ID => 클라이언트 리스트 맵
	private static final Map<Long, Set<Session>> rooms = new ConcurrentHashMap<>(); 
	
	@OnOpen
	public void onOpen(Session session, EndpointConfig config) {
		
		// http세션에서 정보를 가져오고
		Long loginId = (Long)config.getUserProperties().get("loginId");
		String username = (String)config.getUserProperties().get("username");
		Long roomId = (Long)config.getUserProperties().get("roomId");
		// String roomSessionId = getRoomId(session);
		
		// 여기서 엔드포인트 세션에 저장함................
		config.getUserProperties().put("username", username);
		config.getUserProperties().put("loginId", loginId);
		config.getUserProperties().put("roomId", roomId);
		
		
		rooms.computeIfAbsent(roomId, k -> ConcurrentHashMap.newKeySet()).add(session);
		System.out.println("👤 [" + roomId + "] 연결: " + session.getId());
	}
	
	@OnMessage
	public void onMessage(Session session, String message) {
		String roomSessionId = getRoomId(session);
		Long roomId = (Long)session.getUserProperties().get("roomId");
		Long loginId = (Long)session.getUserProperties().get("loginId");
		String username = (String)session.getUserProperties().get("username");
		String broadcastMsg = username + ": " + message;
        
		MessageDAO.getInstance().insert(roomId, loginId, message);
		
		// 해당 방 클라이언트들에게만 전송
		rooms.getOrDefault(roomId, Collections.emptySet()).stream()
			.filter(Session::isOpen)
			.forEach(client -> {
				try {
					client.getBasicRemote().sendText(broadcastMsg);
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
			});
	}
	
	private String getRoomId(Session session) {
		// ws://localhost:8080/chat?room=general
		return session.getQueryString() != null && 
				session.getQueryString().contains("room=") ?
				session.getQueryString().split("room=")[1].split("&")[0] :
				"general";  // 기본 방
	}
}
