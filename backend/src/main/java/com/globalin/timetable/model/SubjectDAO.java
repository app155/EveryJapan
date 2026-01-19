package com.globalin.timetable.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.dbcp.DBCPUtil;

@Repository
public class SubjectDAO {
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
