package com.globalin.chat.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.dbcp.DBCPUtil;

@Repository
public class ChatRoomDAO {
	private static ChatRoomDAO instance;
	
	public static synchronized ChatRoomDAO getInstance() {
		if (instance == null) {
			instance = new ChatRoomDAO();
		}
		
		return instance;
	}
	
	public List<ChatRoomVO> getAllRoomsById(Long userId) {
		List<ChatRoomVO> rooms = new ArrayList<>();
		String sql = "select * from chat_rooms where room_id in (select room_id from chat_members where user_id = ?)";
		ResultSet rs = null;
		
		try (Connection con = DBCPUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			
			pstmt.setLong(1, userId);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				ChatRoomVO room = new ChatRoomVO();
				
				room.setRoomId(rs.getLong("room_id"));
				room.setAnonymous(rs.getBoolean("is_anonymous"));
				room.setLastMessageAt(rs.getTimestamp("last_message_at"));
				room.setCreateAt(rs.getTimestamp("create_at"));
				room.setRoomName(rs.getString("room_name"));
				room.setRoomType(RoomType.valueOf(rs.getString("room_type")));
				
				rooms.add(room);
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
		
		return rooms;
	}
	
	public boolean updateLastMsgId(long roomId, long msgId) {
		boolean result = false;
		
		String sql = "update chat_rooms set last_message_id = ?, last_message_at = ? where room_id = ?";
		
		try (Connection con = DBCPUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setLong(1, msgId);
			pstmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
			pstmt.setLong(3, roomId);
			
			pstmt.executeUpdate();
			
			result = true;
			
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
		
		return result;
	}
	
	public boolean insert(boolean isAnonymous, String roomname, RoomType roomType, long userId, String nickname) {
		boolean result = false;
		
		String sql = "insert into chat_rooms(is_anonymous, room_name, room_type) values (?, ?, ?)";
		
		try (Connection con = DBCPUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
			
			pstmt.setBoolean(1, isAnonymous);
			pstmt.setString(2, roomname);
			pstmt.setString(3, roomType.toString());
			
			pstmt.executeUpdate();
			
			result = true;
			
			try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					ChatMemberDAO.getInstance().insertWhenRoomCreated(generatedKeys.getLong(1), userId, nickname);
				}
			}
			
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
		
		return result;
	}
}
