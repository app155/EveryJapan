package com.globalin.chat.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalin.chat.model.ChatMemberDAO;
import com.globalin.chat.model.ChatRoomDAO;
import com.globalin.chat.model.ChatRoomVO;
import com.globalin.chat.model.MessageDAO;
import com.globalin.chat.model.MessageVO;
import com.globalin.chat.model.RoomType;

@Service
public class ChatService {
	@Autowired ChatRoomDAO roomDAO;
	@Autowired MessageDAO msgDAO;
	@Autowired ChatMemberDAO memDAO;
	
	public List<ChatRoomVO> getAllRoomsById(long loginId) {
		return roomDAO.getAllRoomsById(loginId);
	}
	
	public String getContentById(long msgId) {
		return msgDAO.getContentById(msgId);
	}
	
	public String getLastContentInRoom(long roomId) {
		return msgDAO.getLastContentInRoom(roomId);
	}
	
	public boolean createChatRoom(boolean isAnonymous, String roomName, String roomType, HttpSession session) {
		Long loginId = (Long)session.getAttribute("loginId");
		String username = (String) session.getAttribute("username");
		
		return roomDAO.insert(isAnonymous, roomName, RoomType.valueOf(roomType), loginId, username);
	}
	
	public List<MessageVO> getMessagesInRoom(long roomId) {
		return msgDAO.getMessagesInRoom(roomId);
	}
	
	public boolean insertMemberToRoomByEmail(long roomId, String email) {
		return memDAO.insertMemberToRoomByEmail(roomId, email);
	}

	public boolean saveMsg(long roomId, long userId, String message) {
		return msgDAO.insert(roomId, userId, message);
	}

}
