package com.example.Globalin.controller;

import com.example.Globalin.dto.MainPageDTO;
import com.example.Globalin.service.BoardService;
import com.example.Globalin.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/api/main")
public class MainPageController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private UserService userService;

    // 메인 페이지 데이터 통합 API
    @GetMapping("/dashboard")
    @ResponseBody
    public ResponseEntity<MainPageDTO> getMainPageData(
            HttpServletRequest request) {

        String userId = (String) request.getSession()
                .getAttribute("userId");

        MainPageDTO mainPage = new MainPageDTO();

        // 1. 사용자 정보
        mainPage.setUserProfile(userService.getUserProfile(userId));

        // 2. 인문학 게시판 최신글
        mainPage.setHumanitiesPosts(
                boardService.getRecentPosts("humanities", 5));

        // 3. 자유게시판 최신글
        mainPage.setFreePosts(
                boardService.getRecentPosts("free", 5));

        // 4. HOT 게시글
        mainPage.setHotPosts(
                boardService.getHotPosts(10));

        // 5. BEST 게시판
        mainPage.setBestBoards(
                boardService.getBestBoards(5));

        return ResponseEntity.ok(mainPage);
    }
}