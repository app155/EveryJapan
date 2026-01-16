package com.globalin.board.controller;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.globalin.board.model.CommentVO;
import com.globalin.board.model.PostVO;
import com.globalin.board.service.BoardService_;


@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired BoardService_ boardService;
	
	@GetMapping("main")
	public String boardMain(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		
		List<PostVO> posts = boardService.getAllPosts();
		//Integer pageNum = Integer.parseInt(request.getParameter("pageNum"));
		
		request.setAttribute("posts", posts);
		return "board/main";
	}
	
	@GetMapping("/createPostForm")
	public String createPostForm(HttpServletRequest request) {
		return "board/createPostForm";
	}
	
	@PostMapping("/createPostProc")
	public String createPostProc(String content, long authorId, String title, String category, HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		boardService.createPost(content, authorId, title, category);
		return "redirect:main";
	}
	
	@GetMapping("/post")
	public String getPost(long postId, HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		
		PostVO post = boardService.getPost(postId);
		List<CommentVO> comments = boardService.getAllCommentsInPost(postId);
		
		request.setAttribute("post", post);
		request.setAttribute("comments", comments);
		
		return "/board/post";
	}
	
	@PostMapping("/modifyPostForm")
	public String modifyPostForm(long postId, String title, String content, long authorId, HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		
		request.setAttribute("title", title);
		request.setAttribute("postId", postId);
		request.setAttribute("content", content);
		request.setAttribute("authorId", authorId);
		
		return "redirect:modifyPostForm";
	}
	
	@PostMapping("/createCommentProc")
	public String createComment(long postId, long userId, String content, boolean isAnonymous, HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("paramcheck : postId = " + postId + " userId=" + userId + " content=" + content + " isA=" + isAnonymous);
		
		boardService.saveComment(postId, userId, content, isAnonymous);
		
		return "redirect:main";
	}
	
	@PostMapping("/commentDelProc")
	public String deleteComment(long commentId) {
		return "";
	}
}
