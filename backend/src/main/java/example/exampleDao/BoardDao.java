package exampleDao;

import java.util.List;

import exampleModel.Board;

@Mapper // 이건 뭔 어노니테이션 ? 
public interface BoardDao {
	
	List<Board> findAllBoards();
	Board findById(Long id);
	
}
