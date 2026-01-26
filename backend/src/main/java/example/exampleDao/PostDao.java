package exampleDao;

import java.util.List;

import exampleModel.Post;

public interface PostDao {
	
	void insertPost(Post post);
	
	Post findById(/*@Param("id") */Long id); // 이건 또 뭔 어노니테이션?
	
	List<Post> findByBoardId(Long authorId,
											int offset,
											int limit);
	
	void updatePost(Post post);
	
	void deletePost(Long id);
	
	void incrementLikeCount(Long id);
	void decrementCommentCount(Long id);
	
	void updateImageCount(Long id, int count);
	
	int countByBoardId(Long boardId);
	
	List<Post> searchPosts(String keyword, int offset, int limit); //offset, limit은 뭐지?
	
	int countAllPosts();

}
