package com.globalin.university.model;

import java.sql.*;

import com.dbcp.DBCPUtil;

public class UniversityDAO {
	private static UniversityDAO instance;
	
	public static synchronized UniversityDAO getInstance() {
		if (instance == null) {
			instance = new UniversityDAO();
		}
		
		return instance;
	}
	
	
	public long getIdByUnivName(String name) {
		String sql = "select university_id from universities where name = ?";
		ResultSet rs = null;
		long result = -1;
		
		try (Connection con = DBCPUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				result = rs.getLong(1);
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
}
