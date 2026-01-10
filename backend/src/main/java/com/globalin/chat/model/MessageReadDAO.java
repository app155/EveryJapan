package com.globalin.chat.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.dbcp.DBCPUtil;

@Repository
public class MessageReadDAO {
	private static MessageReadDAO instance;
	
	public static synchronized MessageReadDAO getInstance() {
		if (instance == null) {
			instance = new MessageReadDAO();
		}
		
		return instance;
	}
	
	public boolean insert(long messageId, long userId) {
		boolean result = false;
		
		String sql = "insert into messages(message_id, user_id) values (?, ?)";
		
		try (Connection con = DBCPUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
			
			pstmt.setLong(1, messageId);
			pstmt.setLong(2, userId);
			
			pstmt.executeUpdate();
			
			result = true;
			
			try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					
				}
			}
			
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
		
		return result;
	}
}
