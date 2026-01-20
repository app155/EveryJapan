package com.globalin.timetable.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dbcp.DBCPUtil;

@Repository
public class SubjectDAO {
	public List<SubjectVO> getAllSubjectsInTimetable(long tableId) {
		List<SubjectVO> subjects = new ArrayList<SubjectVO>();
		
		String sql = "select * from subjects where subject_id in (select subject_id from timetables_subjects where table_id where ?)";
		ResultSet rs = null;
		
		try (Connection con = DBCPUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setLong(1, tableId);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				SubjectVO subject = new SubjectVO();
				subject.setSubjectId(rs.getLong("subject_id"));
				subject.setUniversityId(rs.getLong("university_id"));
				subject.setName(rs.getString("name"));
				subject.setStartTime(rs.getTime("start_time"));
				subject.setEndTime(rs.getTime("end_time"));
				subject.setDay(rs.getInt("day"));
				subject.setCredit(rs.getInt("credit"));
				subject.setProfessor(rs.getString("professor"));
				subject.setMaxCount(rs.getInt("max_count"));
				subject.setCurrentCount(rs.getInt("current_count"));
				subject.setCollege(rs.getString("college"));
				subject.setLectureType(rs.getString("lecture_type"));
				subject.setGrade(rs.getInt("grade"));
				
				subjects.add(subject);
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
		
		return subjects;
	}
	
	public List<SubjectVO> getAllSubjects() {
		List<SubjectVO> subjects = new ArrayList<SubjectVO>();
		
		String sql = "select * from subjects";
		ResultSet rs = null;
		
		try (Connection con = DBCPUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				SubjectVO subject = new SubjectVO();
				subject.setSubjectId(rs.getLong("subject_id"));
				subject.setUniversityId(rs.getLong("university_id"));
				subject.setName(rs.getString("name"));
				subject.setStartTime(rs.getTime("start_time"));
				subject.setEndTime(rs.getTime("end_time"));
				subject.setDay(rs.getInt("day"));
				subject.setCredit(rs.getInt("credit"));
				subject.setProfessor(rs.getString("professor"));
				subject.setMaxCount(rs.getInt("max_count"));
				subject.setCurrentCount(rs.getInt("current_count"));
				subject.setCollege(rs.getString("college"));
				subject.setLectureType(rs.getString("lecture_type"));
				subject.setGrade(rs.getInt("grade"));
				
				subjects.add(subject);
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
		
		return subjects;
	}
	
	public SubjectVO getSubject(long subjectId) {
		SubjectVO subject = null;
		
		String sql = "select * from subjects where subject_id = ?";
		ResultSet rs = null;
		
		try (Connection con = DBCPUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			
			pstmt.setLong(1, subjectId);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				subject = new SubjectVO();
				subject.setSubjectId(subjectId);
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
		
		return subject;
	}
}
