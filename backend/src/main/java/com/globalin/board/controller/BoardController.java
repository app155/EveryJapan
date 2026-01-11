package com.globalin.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.globalin.board.model.PostVO;
import com.globalin.board.service.BoardService_;


@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired BoardService_ boardService;
	
	@GetMapping("main")
	public String boardMain(HttpServletRequest request) {
		List<PostVO> posts = boardService.getAllPosts();
		//Integer pageNum = Integer.parseInt(request.getParameter("pageNum"));
		
		//request.setAttribute("posts", posts);
		return "board/main";
	}
	
	@GetMapping("/createPostForm")
	public String createPostForm(HttpServletRequest request) {
		return "redirect:/board/createPostForm";
	}
}
