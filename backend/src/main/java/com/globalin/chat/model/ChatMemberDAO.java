package com.globalin.chat.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dbcp.DBCPUtil;
import com.globalin.user.model.UserDAO;

public class ChatMemberDAO {
	private static ChatMemberDAO instance;
	
	public static synchronized ChatMemberDAO getInstance() {
		if (instance == null) {
			instance = new ChatMemberDAO();
		}
		
		return instance;
	}
	
	public boolean insertWhenRoomCreated(long roomId, long userId, String nickname) {
		boolean result = false;
		
		String sql = "insert into chat_members(room_id, user_id, nickname) values (?, ?, ?)";
		
		try (Connection con = DBCPUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			
			pstmt.setLong(1, roomId);
			pstmt.setLong(2, userId);
			pstmt.setString(3, nickname);
			
			pstmt.executeUpdate();
			
			result = true;
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
		
		return result;
	}
	
	public boolean insertMemberToRoomByEmail(long roomId, String email) {
		boolean result = false;
		
		String sql = "insert into chat_members(room_id, user_id, nickname) values (?, ?, ?)";
		
		try (Connection con = DBCPUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			
			pstmt.setLong(1, roomId);
			pstmt.setLong(2, UserDAO.getInstance().getUserIdByEmail(email));
			pstmt.setString(3, UserDAO.getInstance().getUsernameByEmail(email));
			
			pstmt.executeUpdate();
			
			result = true;
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
		
		return result;
	}
}
