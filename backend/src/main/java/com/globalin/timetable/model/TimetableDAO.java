package com.globalin.timetable.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dbcp.DBCPUtil;

@Repository
public class TimetableDAO {
	@Autowired
	private SubjectDAO subjectDAO;
	
	public int getTablesCount(long userId) {
		int count = 0;
		
		String sql = "select count(*) from timetables where user_id = ?";
		ResultSet rs = null;
		
		try (Connection con = DBCPUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setLong(1, userId);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				count = rs.getInt(1);
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
		
		return count;
	}
	
	public List<TimetableVO> getTimetables(long userId) {
		List<TimetableVO> timetables = new ArrayList<>();
		String sql = "select * from timetables where user_id = ?";
		ResultSet rs = null;
		
		try (Connection con = DBCPUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setLong(1, userId);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				TimetableVO timetable = new TimetableVO();
				
				timetable.setTimetableId(rs.getLong("timetable_id"));
				timetable.setUserId(rs.getLong("user_id"));
				timetable.setName(rs.getString("name"));
				timetable.setSemester(rs.getString("semester"));
				
				timetables.add(timetable);
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
				
				long tableId = rs.getLong("timetable_id");
				timetable.setTimetableId(rs.getLong("timetable_id"));
				timetable.setUserId(rs.getLong("user_id"));
				timetable.setName(rs.getString("name"));
				timetable.setSemester(rs.getString("semester"));
				timetable.setSubjects(subjectDAO.getAllSubjectsInTimetable(tableId));
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
	
	public void insert(long userId, String name) {
		String sql = "insert into timetables (user_id, name) values (?, ?)";
		
		try (Connection con = DBCPUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setLong(1, userId);
			pstmt.setString(2, name);
			pstmt.executeUpdate();
		}
		
		catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
	public void addSubjectToTimeTable(long timetableId, long subjectId) {
		String sql = "insert into timetables_subjects (timetable_id, subject_id) values (?, ?)";
		
		try (Connection con = DBCPUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setLong(1, timetableId);
			pstmt.setLong(2, subjectId);
			pstmt.executeUpdate();
		}
		
		catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
	public void update(long tableId, String tableName) {
		String sql = "update timetables set name = ? where timetable_id = ?";
		
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
		String sql = "delete from timetables where timetable_id = ?";
		
		try (Connection con = DBCPUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setLong(1, tableId);
			pstmt.executeUpdate();
		}
		
		catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
	public void deleteSubjectToTimeTable(long timetableId, long subjectId) {
		String sql = "delete from timetables_subjects where timetable_id = ? and subject_id = ?";
		
		try (Connection con = DBCPUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setLong(1, timetableId);
			pstmt.setLong(2, subjectId);
			pstmt.executeUpdate();
		}
		
		catch (SQLException se) {
			se.printStackTrace();
		}
	}
}
