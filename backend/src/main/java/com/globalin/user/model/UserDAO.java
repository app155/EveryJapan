package com.globalin.user.model;
import java.sql.*;

import org.springframework.stereotype.Repository;

import com.dbcp.DBCPUtil;
import com.globalin.university.model.UniversityDAO;

@Repository
public class UserDAO {
	private static UserDAO instance;
	
	public static synchronized UserDAO getInstance() {
		if (instance == null) {
			instance = new UserDAO();
		}
		
		return instance;
	}
	
	public void testinsert() {
		String sql = "insert into users values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try (Connection con = DBCPUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setLong(1, 1);
			pstmt.setLong(2, 1);
			pstmt.setInt(3, 1);
			pstmt.setBoolean(4, false);
			pstmt.setTimestamp(5, new Timestamp(1));
			pstmt.setTimestamp(6, new Timestamp(2));
			pstmt.setString(7, "aa@aa.com");
			pstmt.setString(8, "1234");
			pstmt.setString(9, "testuser1");
			pstmt.setString(10, "testmajor");
			pstmt.setString(11, "testSID");
			pstmt.setString(12, "testImage");
			pstmt.setString(13, "testStatus");
			
			int num = pstmt.executeUpdate();
			System.out.println(num + "행 삽입완료");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public int loginProcess(String email, String password) {
		int result = -1;
		String sql = "select * from users where email = ?";
		ResultSet rs = null;
		
		try (Connection con = DBCPUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String dbPass = rs.getString("password");
				
				if (password.equals(dbPass)) {
					result = 1;
				}
				else {
					result = 0;
				}
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
		
		return result;
	}
	
	public void findByEmail() {
		
	}
	
	public boolean insert(String email, String password, String username, String university, int grade, String major, String studentId) {
		String sql = "insert into users values (NULL, ?, ?, NULL, NULL, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try (Connection con = DBCPUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			con.setAutoCommit(false);
			pstmt.setLong(1, UniversityDAO.getInstance().getIdByUnivName(university));
			pstmt.setInt(2, grade);
			pstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			pstmt.setString(4, email);
			pstmt.setString(5, password);
			pstmt.setString(6, username);
			pstmt.setString(7, major);
			pstmt.setString(8, studentId);
			pstmt.setString(9, "testImage");
			pstmt.setString(10, "testStatus");
			
			int num = pstmt.executeUpdate();
			con.commit();
			System.out.println(num + "행 삽입완료");
			return true;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Long getUserIdByEmail(String email) {
		Long userId = null;
		
		String sql = "select user_id from users where email = ?";
		ResultSet rs = null;
		
		try (Connection con = DBCPUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				userId = rs.getLong("user_id");
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
		
		return userId;
	}
	
	public String getUsernameByEmail(String email) {
		String username = null;
		
		String sql = "select username from users where email = ?";
		ResultSet rs = null;
		
		try (Connection con = DBCPUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				username = rs.getString("username");
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
		
		return username;
	}
}
