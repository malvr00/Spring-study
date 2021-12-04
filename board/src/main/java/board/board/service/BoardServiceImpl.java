package board.board.service;

import board.board.dto.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service	// 해당 클래스가 스프링 MVC의 서비스임을 나타냄
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardMapper boardMapper;	// DAO 빈을 선언
	
	@Override
	public List<BoardDto> selectBoardList() throws Exception{
		return boardMapper.selectBoardList();
	}
}
