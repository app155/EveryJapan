package com.globalin.timetable.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dbcp.DBCPUtil;

@Repository
public class TimetableDAO {
	public List<TimetableVO> getTimetables(long userId) {
		List<TimetableVO> timetables = null;
		String sql = "select * from timetables where user_id = ?";
		ResultSet rs = null;
		
		try (Connection con = DBCPUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setLong(1, userId);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
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
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return timetables;
	}
	
	public TimetableVO getTimetable(long userId) {
		TimetableVO timetable = null;
		String sql = "select * from timetables where user_id = ?";
		ResultSet rs = null;
		
		try (Connection con = DBCPUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setLong(1, userId);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				timetable = new TimetableVO();
				
				timetable.setTimetableId(rs.getLong("table_id"));
				timetable.setUserId(rs.getLong("user_id"));
				timetable.setName(rs.getString("name"));
				timetable.setSemester(rs.getString("semester"));
				
				
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
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return timetable;
	}
	
	public void insert(long userId) {
		String sql = "insert into timetables user_id values ?";
		
		try (Connection con = DBCPUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setLong(1, userId);
			pstmt.executeUpdate();
		}
		
		catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
	public void update(long tableId, String tableName) {
		String sql = "update timetables set name = ? where table_id = ?";
		
		try (Connection con = DBCPUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, tableName);
			pstmt.setLong(2, tableId);
			pstmt.executeUpdate();
		}
		
		catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
	public void delete(long tableId) {
		String sql = "delete from timetables where table_id = ?";
		
		try (Connection con = DBCPUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setLong(1, tableId);
			pstmt.executeUpdate();
		}
		
		catch (SQLException se) {
			se.printStackTrace();
		}
	}
}
