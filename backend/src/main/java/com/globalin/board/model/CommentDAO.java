package com.globalin.board.model;

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
public class CommentDAO {
	@Autowired PostDAO postDAO;
	
	public List<CommentVO> getAllCommentsInPost(long postId) {
		String sql = "select * from comments where post_id = ?";
		List<CommentVO> comments = new ArrayList<>();
		ResultSet rs = null;
		
		try (Connection con = DBCPUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setLong(1, postId);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				CommentVO comment = new CommentVO();
				comment.setCommentId(rs.getLong("comment_id"));
				comment.setPostId(rs.getLong("post_id"));
				comment.setUserId(rs.getLong("user_id"));
				comment.setContent(rs.getString("content"));
				comment.setAnonymous(rs.getBoolean("is_anonymous"));
				comment.setParentCommentId(rs.getLong("parent_comment_id"));
				comment.setCreatedAt(rs.getTimestamp("created_at"));
				
				comments.add(comment);
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
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
		
		return comments;
	}
	
	public boolean insert(long postId, long userId, String content, boolean isAnonymous) {
		boolean result = false;
		String sql = "insert into comments (post_id, user_id, content, is_anonymous) values (?, ?, ?, ?)";
		
		try (Connection con = DBCPUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setLong(1, postId);
			pstmt.setLong(2, userId);
			pstmt.setString(3, content);
			pstmt.setBoolean(4, isAnonymous);
			
			pstmt.executeUpdate();
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
		
		return result;
	}
	
	public boolean delete(long commentId) {
		boolean result = false;
		String sql = "delete from comments where comment_id = ?";
		
		try (Connection con = DBCPUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setLong(1, commentId);
			
			pstmt.executeUpdate();
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
		
		return result;
	}
}
