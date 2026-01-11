package com.globalin.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalin.board.model.PostDAO;
import com.globalin.board.model.PostVO;

@Service
public class BoardService_ {
	@Autowired PostDAO postDAO;
	
	public List<PostVO> getAllPosts() {
		return postDAO.getAllPosts(); 
	}
	
	public boolean createPost(String content, long loginId, String title, String category) {
		return postDAO.insert(content, loginId, title, category);
	}
}
