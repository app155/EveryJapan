package exampleService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import exampleModel.Board;
import exampleModel.HotPost;
import exampleModel.Post;

public class BoardService {
	
	public List<Post> getRecentPosts(String boardType, int limit){
		
		List<Post> posts = new ArrayList<>();
		
		if("humanities".equals(boardType)) {
			Post post1 = new Post();
			post1.setId(1L);
			post1.setTitle("일본의 대학생활에 관한 정보를 나눕니다.");
			post1.setContent("안녕하세요. 일본의 대학 1년 지나서 느낀걸 공유하려고요");
			post1.setAuthor("유학");
			post1.setAuthorId(2L);
			post1.setCreateAt(new Date());
			post1.setViewCount(156);
			post1.setCommentCount(23);
			post1.setLikeCount(45);
			post1.setBoardId(1L);
			post1.setBoardName("입문학");
			posts.add(post1);
			
			
			Post post2 = new Post();
			post2.setId(2L);
			post2.setTitle("일본어학습방법");
			post2.setContent("효과적인 일본어 방법에 대해 이야기합시다.");
			post2.setAuthor("학생B");
			post2.setAuthorId(2L);
			post2.setCreateAt(new Date());
			post2.setViewCount(89);
			post2.setCommentCount(12);
			post2.setLikeCount(28);
			post2.setBoardId(1L);
			post2.setBoardName("입문학");
			posts.add(post2);
			
		}else if("free".equals(boardType)) {
			Post post1 = new Post();
			post1.setId(3L);
			post1.setTitle("일본의 맛있는 음식점 추천");
			post1.setContent("이번 주말에 음식점 추천좀");
			post1.setAuthor("여행 좋아하는 사람");
			post1.setAuthorId(4L);
			post1.setCreateAt(new Date());
			post1.setViewCount(234);
			post1.setCommentCount(31);
			post1.setLikeCount(18);
			post1.setBoardId(2L);
			post1.setBoardName("자유계시판");
			posts.add(post1);
			
			
			Post post2 = new Post();
			post2.setId(2L);
			post2.setTitle("기숙사 VS 원룸");
			post2.setContent("어떤게 좋음?");
			post2.setAuthor("망성이른중");
			post2.setAuthorId(5L);
			post2.setCreateAt(new Date());
			post2.setViewCount(178);
			post2.setCommentCount(26);
			post2.setLikeCount(15);
			post2.setBoardId(2L);
			post2.setBoardName("자유계시판");
			posts.add(post2);
			
		}
		return posts;
	}
	
	public List<HotPost> getHotPosts(int limit){
		
		List<HotPost> hotPosts = new ArrayList<>();
		
		HotPost hot1 = new HotPost();
		hot1.setId(5L);
		hot1.setTitle("일본의 대학 정보");
		hot1.setAuthor("점마");
		hot1.setViewCount(892);
		hot1.setCommentCount(67);
		hot1.setLikeCount(134);
		hot1.setCreatedAt(new Date());
		hot1.setIsHot(true);
		hotPosts.add(hot1);
		
		
		HotPost hot2 = new HotPost();
		hot2.setId(2L);
		hot2.setTitle("유학생 알바 추천");
		hot2.setAuthor("달인");
		hot2.setViewCount(645);
		hot2.setCommentCount(45);
		hot2.setLikeCount(89);
		hot2.setCreatedAt(new Date());
		hot2.setIsHot(true);
		hotPosts.add(hot2);
		
		return hotPosts;
	}
	
	public List<Board> getBestBoards(int limit){
		
		List<Board> boards = new ArrayList<>();
		
		Board board1 = new Board();
		board1.setId(1L);
		board1.setName("입문학");
		board1.setDescription("문학, 역사 등");
		board1.setPostCount(234);
		board1.setCategory("학술");
		board1.setIcon("");
		boards.add(board1);
		
		Board board2 = new Board();
		board2.setId(2L);
		board2.setName("자유게시판");
		board2.setDescription("자유로운 테마 게시판");
		board2.setPostCount(567);
		board2.setCategory("일반");
		board2.setIcon("");
		boards.add(board2);
		
		Board board3 = new Board();
		board3.setId(3L);
		board3.setName("취직,진로");
		board3.setDescription("취직, 진로 정보");
		board3.setPostCount(189);
		board3.setCategory("진로");
		board3.setIcon("");
		boards.add(board3);
		
		return boards;
	}
	
}
