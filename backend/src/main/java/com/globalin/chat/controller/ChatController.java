package com.globalin.chat.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.globalin.chat.model.*;
import com.globalin.chat.service.ChatService;
import com.globalin.user.model.*;

@Controller
@RequestMapping("/chat")
public class ChatController {
	@Autowired ChatService chatService;
	
	@GetMapping("chat")
	public String chatMain(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Long loginId = (Long)session.getAttribute("loginId");
		List<ChatRoomVO> rooms = chatService.getAllRoomsById(loginId);
		List<String> lastMsgs = new ArrayList<>();
		
		for (int i = 0; i < rooms.size(); i++) {
			lastMsgs.add(chatService.getLastContentInRoom(rooms.get(i).getRoomId()));
		}
		
		request.setAttribute("rooms", rooms);
		request.setAttribute("msgs", lastMsgs);
		
		return "chat/chat";
	}
	
	@PostMapping("createRoomProc")
	public String createChatRoom(boolean isAnonymous, String roomName, String roomType, HttpSession session) {
		boolean result = chatService.createChatRoom(isAnonymous, roomName, roomType, session);
				
		if (result) {
			
		}
		else {
			
		}
		
		return "redirect:chat";
	}
	
	@GetMapping("chatroom")
	public String goToChatRoom(@RequestParam long roomId, HttpServletRequest request) {
		request.setAttribute("roomId", roomId);
		request.setAttribute("msgs", chatService.getMessagesInRoom(roomId));
		
		return "chat/chatroom";
	}
	
	@PostMapping("inviteToRoom")
	public String inviteToRoom(long roomId, String email) {
		chatService.insertMemberToRoomByEmail(roomId, email);
		
		return "redirect:/chat/chatroom?roomId=" + roomId;
	}
}
