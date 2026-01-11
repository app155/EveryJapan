package com.globalin.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dbcp.DBCPUtil;

@Repository
public class PostDAO {
	public boolean insert(String content, long author, String title, String category) {
		boolean result = false;
		String sql = "insert into posts (content, author, title, category, anonymous_id) values (?, ?, ?, ?, ?)";
		
		try (Connection con = DBCPUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, content);
			pstmt.setLong(2, author);
			pstmt.setString(3, title);
			pstmt.setString(4, category);
			pstmt.setString(5, null);
			
			pstmt.executeQuery();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public boolean insert(String content, long author, String title, String category, String anonymousId) {
		boolean result = false;
		String sql = "insert into posts (content, author, title, category, anonymous_id) values (?, ?, ?, ?, ?)";
		
		try (Connection con = DBCPUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, sql);
			pstmt.setLong(2, author);
			pstmt.setString(3, title);
			pstmt.setString(4, category);
			pstmt.setString(5, anonymousId);
			
			pstmt.executeQuery();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public List<PostVO> getAllPosts() {
		String sql = "select * from posts order by created_at desc";
		List<PostVO> posts = new ArrayList<>();
		ResultSet rs = null;
		
		try (Connection con = DBCPUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				PostVO post = new PostVO();
				post.setPostId(rs.getLong("post_id"));
				post.setContent(rs.getString("content"));
				post.setViewCount(rs.getInt("view_count"));
				post.setLikeCount(rs.getInt("like_count"));
				post.setAnonymous(rs.getBoolean("is_anonymous"));
				post.setAuthor(rs.getLong("author"));
				post.setCreatedAt(rs.getTimestamp("created_at"));
				post.setUpdatedAt(rs.getTimestamp("updated_at"));
				post.setTitle(rs.getString("title"));
				post.setCategory(rs.getString("category"));
				post.setAnonymousId(rs.getString("anonymous_id"));
				
				posts.add(post);
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
		
		return posts;
	}
	
	public PostVO getPost(long postId) {
		String sql = "select * from posts";
		PostVO post = null;
		ResultSet rs = null;
		
		try (Connection con = DBCPUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				post = new PostVO();
				post.setPostId(rs.getLong("post_id"));
				post.setContent(rs.getString("content"));
				post.setViewCount(rs.getInt("view_count"));
				post.setLikeCount(rs.getInt("like_count"));
				post.setAnonymous(rs.getBoolean("is_anonymous"));
				post.setAuthor(rs.getLong("author"));
				post.setCreatedAt(rs.getTimestamp("created_at"));
				post.setUpdatedAt(rs.getTimestamp("updated_at"));
				post.setTitle(rs.getString("title"));
				post.setCategory(rs.getString("category"));
				post.setAnonymousId(rs.getString("anonymous_id"));
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
		
		return post;
	}
}
