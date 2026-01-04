package com.globalin.chat;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {
	
	@GetMapping("chat")
	public String chatMain() {
		return "chat/chat";
	}
	
	@PostMapping("createRoomProc")
	public String createChatRoom(boolean isAnonymous, String roomName, RoomType roomType, HttpSession session) {
		boolean result = ChatRoomDAO.getInstance()
				.insert(isAnonymous, roomName, roomType, (long)session.getAttribute("loginId"), (String)session.getAttribute("username"));
		
		if (result) {
			
		}
		else {
			
		}
		
		return "redirect:chat";
	}
}
