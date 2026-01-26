package exampleService;

import exampleDao.PostDao;

public class PostService {

	private PostDao postDao;

	private PostImageDao postImageDao;

	private PostLikeDao postLikeDao;

	private UserDao userDao;

	private NotificationService notificationService;

	public PostResponse createPost(CreatePostRequest request, Long userId) {
		
		try {
			
			if(request.getBoardId() == null) {
				return new PostResponse(false, "게시판을 선택해주세요");
			}
			if(request.getTitle() == null || request.getTitle().trim().isEmpty()) {
				return new PostResponse(false, "타이틀을 입력해주세요");
			}
			if(request.getBoardId() == null || request.getContent().trim().isEmpty()) { // trim()이 뭐지?
				return new Postre(false, "내용을 입력해주세요");
			}
			
			Post post = new Post();
			post.setBoardId(request.getBoardId());
			post.setAutorId(userId);
			post.setTitle(request.getTitle());
			post.setContent(request.getContent());
			post.setIsAnonymous(request.getIsAnonymous() != null ? request.getIsAnonymous() : false);
			
			postDao.insertPost(post);
			
			// 화상 보존..? 뭐지? 이미지를 저장한다는건가 
			if(request.getImageUrls)
		}
	}
}
