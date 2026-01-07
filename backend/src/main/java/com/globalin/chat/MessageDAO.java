package com.globalin.chat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dbcp.DBCPUtil;

public class MessageDAO {
	private static MessageDAO instance;
	
	public static synchronized MessageDAO getInstance() {
		if (instance == null) {
			instance = new MessageDAO();
		}
		
		return instance;
	}
	
	public String getContentById(long msgId) {
		String content = "";
		
		String sql = "select content from messages where message_id = ?";
		ResultSet rs = null;
		
		try (Connection con = DBCPUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			
			pstmt.setLong(1, msgId);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				content = rs.getString("content");
			}
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
		finally {
			if (rs != null) {
				try {
					rs.close();
				}
				catch (SQLException se) {
					se.printStackTrace();
				}
			}
		}
		
		return content;
	}
	
	public List<MessageVO> getMessagesInRoom(long roomId) {
		List<MessageVO> msgs = new ArrayList<>();
		
		String sql = "select * from messages where room_id = ? order by sent_at desc";
		ResultSet rs = null;
		
		try (Connection con = DBCPUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			
			pstmt.setLong(1, roomId);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				MessageVO msg = new MessageVO();
				
				msg.setMessageId(rs.getLong("message_id"));
				msg.setRoomId(rs.getLong("room_id"));
				msg.setSenderId(rs.getLong("sender_id"));
				msg.setContent(rs.getString("content"));
				msg.setAnonymous(rs.getBoolean("is_anonymous"));
				msg.setDelete(rs.getBoolean("is_delete"));
				msg.setSentAt(rs.getTimestamp("sent_at"));
				msg.setEditedAt(rs.getTimestamp("edited_at"));
				msg.setMessageType(MessageType.valueOf(rs.getString("message_type")));
				msg.setRoomId(roomId);
				
				msgs.add(msg);
			}
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
		finally {
			if (rs != null) {
				try {
					rs.close();
				}
				catch (SQLException se) {
					se.printStackTrace();
				}
			}
		}
		
		return msgs;
	}
	
	public boolean insert(long roomId, long senderId, String content) {
		boolean result = false;
		
		String sql = "insert into messages(room_id, sender_id, content, is_anonymous, message_type) values (?, ?, ?, ?, ?)";
		
		try (Connection con = DBCPUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
			
			pstmt.setLong(1, roomId);
			pstmt.setLong(2, senderId);
			pstmt.setString(3, content);
			pstmt.setBoolean(4, false);
			pstmt.setString(5, MessageType.PUBLIC.toString());
			
			pstmt.executeUpdate();
			
			result = true;
			
			try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					ChatRoomDAO.getInstance().updateLastMsgId(roomId, generatedKeys.getLong(1));
				}
			}
			
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
		
		return result;
	}
	
	public boolean insert(long roomId, long senderId, String content, boolean isAnonymous, MessageType messageType) {
		boolean result = false;
		
		String sql = "insert into messages(room_id, sender_id, content, is_anonymous, message_type) values (?, ?, ?, ?, ?)";
		
		try (Connection con = DBCPUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
			
			pstmt.setLong(1, roomId);
			pstmt.setLong(2, senderId);
			pstmt.setString(3, content);
			pstmt.setBoolean(4, isAnonymous);
			pstmt.setString(5, messageType.toString());
			
			pstmt.executeUpdate();
			
			result = true;
			
			try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					ChatRoomDAO.getInstance().updateLastMsgId(roomId, generatedKeys.getLong(1));
				}
			}
			
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
		
		return result;
	}
}
