package board.board.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import board.board.dto.BoardDto;

@Mapper	// 마이바티스의 매퍼 인터페이스 선언
public interface BoardMapper {
	List<BoardDto> selectBoardList() throws Exception; // 인터페이스이기 때문에 메서드의 이름과 반화 형식만 지정.
	void insertBoard(BoardDto board) throws Exception;
	void updateHitCount(int boardIdx) throws Exception;
	BoardDto selectBoardDetail(int boardIdx) throws Exception;
	void updateBoard(BoardDto board) throws Exception;
	void deleteBoard(int boardIdx) throws Exception;
}
