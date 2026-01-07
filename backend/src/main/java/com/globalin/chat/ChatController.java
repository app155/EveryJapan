package com.globalin.chat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.globalin.user.UserDAO;

@Controller
@RequestMapping("/chat")
public class ChatController {
	
	@GetMapping("chat")
	public String chatMain(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Long loginId = (Long)session.getAttribute("loginId");
		request.setAttribute("rooms", ChatRoomDAO.getInstance().getAllRoomsById(loginId));
		request.setAttribute("msgDao", MessageDAO.getInstance());
		
		return "chat/chat";
	}
	
	@PostMapping("createRoomProc")
	public String createChatRoom(boolean isAnonymous, String roomName, String roomType, HttpSession session) {
		boolean result = ChatRoomDAO.getInstance()
				.insert(isAnonymous, roomName, RoomType.valueOf(roomType.toUpperCase()), (long)session.getAttribute("loginId"), (String)session.getAttribute("username"));
		
		if (result) {
			
		}
		else {
			
		}
		
		return "redirect:chat";
	}
	
	@GetMapping("chatroom")
	public String goToChatRoom(@RequestParam long roomId, HttpServletRequest request) {
		request.setAttribute("roomId", roomId);
		request.setAttribute("msgs", MessageDAO.getInstance().getMessagesInRoom(roomId));
		
		return "chat/chatroom";
	}
	
	@PostMapping("inviteToRoom")
	public String inviteToRoom(long roomId, String email) {
		ChatMemberDAO memDao = ChatMemberDAO.getInstance();
		
		memDao.insertMemberToRoomByEmail(roomId, email);
		
		return "redirect:/chat/chatroom?roomId=" + roomId;
	}
}
