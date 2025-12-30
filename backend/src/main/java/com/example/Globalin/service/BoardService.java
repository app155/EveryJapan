package com.example.Globalin.service;

import com.example.Globalin.model.Post;
import com.example.Globalin.model.HotPost;
import com.example.Globalin.model.Board;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BoardService {

    public List<Post> getRecentPosts(String boardType, int limit) {
        // TODO: 실제 데이터베이스 연동 시 구현
        // 임시로 목 데이터 반환
        List<Post> posts = new ArrayList<>();

        if ("humanities".equals(boardType)) {
            Post post1 = new Post();
            post1.setId(1L);
            post1.setTitle("일본 대학 생활 적응 팁 공유합니다");
            post1.setContent("안녕하세요! 일본 대학에 온 지 1년이 되어서 제가 느낀 점들을 공유하려고 합니다...");
            post1.setAuthor("김유학");
            post1.setAuthorId(2L);
            post1.setCreatedAt(new Date());
            post1.setViewCount(156);
            post1.setCommentCount(23);
            post1.setLikeCount(45);
            post1.setBoardId(1L);
            post1.setBoardName("인문학");
            posts.add(post1);

            Post post2 = new Post();
            post2.setId(2L);
            post2.setTitle("일본어 공부 방법 추천");
            post2.setContent("효과적인 일본어 학습법에 대해 이야기해봅시다.");
            post2.setAuthor("박일본");
            post2.setAuthorId(3L);
            post2.setCreatedAt(new Date());
            post2.setViewCount(89);
            post2.setCommentCount(12);
            post2.setLikeCount(28);
            post2.setBoardId(1L);
            post2.setBoardName("인문학");
            posts.add(post2);
        } else if ("free".equals(boardType)) {
            Post post1 = new Post();
            post1.setId(3L);
            post1.setTitle("도쿄 맛집 추천해주세요");
            post1.setContent("이번 주말에 도쿄 여행 가는데 맛집 추천 부탁드립니다!");
            post1.setAuthor("이여행");
            post1.setAuthorId(4L);
            post1.setCreatedAt(new Date());
            post1.setViewCount(234);
            post1.setCommentCount(31);
            post1.setLikeCount(18);
            post1.setBoardId(2L);
            post1.setBoardName("자유게시판");
            posts.add(post1);

            Post post2 = new Post();
            post2.setId(4L);
            post2.setTitle("기숙사 vs 원룸 어떤게 나을까요?");
            post2.setContent("내년부터 자취를 고민중인데 조언 부탁드립니다.");
            post2.setAuthor("최고민");
            post2.setAuthorId(5L);
            post2.setCreatedAt(new Date());
            post2.setViewCount(178);
            post2.setCommentCount(26);
            post2.setLikeCount(15);
            post2.setBoardId(2L);
            post2.setBoardName("자유게시판");
            posts.add(post2);
        }

        return posts;
    }

    public List<HotPost> getHotPosts(int limit) {
        // TODO: 실제 데이터베이스 연동 시 구현
        List<HotPost> hotPosts = new ArrayList<>();

        HotPost hot1 = new HotPost();
        hot1.setId(5L);
        hot1.setTitle("일본 대학 장학금 정보 총정리");
        hot1.setAuthor("정보왕");
        hot1.setViewCount(892);
        hot1.setCommentCount(67);
        hot1.setLikeCount(134);
        hot1.setCreatedAt(new Date());
        hot1.setIsHot(true);
        hotPosts.add(hot1);

        HotPost hot2 = new HotPost();
        hot2.setId(6L);
        hot2.setTitle("유학생 아르바이트 추천");
        hot2.setAuthor("알바왕");
        hot2.setViewCount(645);
        hot2.setCommentCount(45);
        hot2.setLikeCount(89);
        hot2.setCreatedAt(new Date());
        hot2.setIsHot(true);
        hotPosts.add(hot2);

        HotPost hot3 = new HotPost();
        hot3.setId(7L);
        hot3.setTitle("비자 연장 후기");
        hot3.setAuthor("비자마스터");
        hot3.setViewCount(521);
        hot3.setCommentCount(38);
        hot3.setLikeCount(72);
        hot3.setCreatedAt(new Date());
        hot3.setIsHot(true);
        hotPosts.add(hot3);

        return hotPosts;
    }

    public List<Board> getBestBoards(int limit) {
        // TODO: 실제 데이터베이스 연동 시 구현
        List<Board> boards = new ArrayList<>();

        Board board1 = new Board();
        board1.setId(1L);
        board1.setName("인문학");
        board1.setDescription("문학, 철학, 역사 등");
        board1.setPostCount(234);
        board1.setCategory("학술");
        board1.setIcon("📚");
        boards.add(board1);

        Board board2 = new Board();
        board2.setId(2L);
        board2.setName("자유게시판");
        board2.setDescription("자유로운 주제의 게시판");
        board2.setPostCount(567);
        board2.setCategory("일반");
        board2.setIcon("💬");
        boards.add(board2);

        Board board3 = new Board();
        board3.setId(3L);
        board3.setName("취업/진로");
        board3.setDescription("취업 및 진로 정보");
        board3.setPostCount(189);
        board3.setCategory("진로");
        board3.setIcon("💼");
        boards.add(board3);

        return boards;
    }
}
