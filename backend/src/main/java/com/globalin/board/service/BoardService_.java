package com.globalin.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalin.board.model.CommentDAO;
import com.globalin.board.model.CommentVO;
import com.globalin.board.model.PostDAO;
import com.globalin.board.model.PostVO;

@Service
public class BoardService_ {
	@Autowired PostDAO postDAO;
	@Autowired CommentDAO commentDAO;
	
	public List<PostVO> getAllPosts() {
		return postDAO.getAllPosts(); 
	}
	
	public boolean createPost(String content, long loginId, String title, String category) {
		return postDAO.insert(content, loginId, title, category);
	}
	
	public PostVO getPost(long postId) {
		postDAO.increaseViewCount(postId);
		return postDAO.getPost(postId);
	}
	
	public List<CommentVO> getAllCommentsInPost(long postId) {
		return commentDAO.getAllCommentsInPost(postId);
	}
	
	public boolean saveComment(long postId, long userId, String content, boolean isAnonymous) {
		return commentDAO.insert(postId, userId, content, isAnonymous);
	}
	
	public boolean deleteComment(long commentId) {
		return commentDAO.delete(commentId);
	}
}
