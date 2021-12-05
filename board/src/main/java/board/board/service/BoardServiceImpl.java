package board.board.service;

import board.board.dto.BoardDto;
import board.board.mapper.BoardMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service	// 해당 클래스가 스프링 MVC의 서비스임을 나타냄
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardMapper boardMapper;	// DAO 빈을 선언
	
	@Override
	public List<BoardDto> selectBoardList() throws Exception{
		// 게시글 List
		return boardMapper.selectBoardList();
	}
	
	@Override
	public void insertBoard(BoardDto board) throws Exception{
		// 게시글 추가
		boardMapper.insertBoard(board);
	}
	
	@Override
	public BoardDto selectBoardDetail(int boardIdx) throws Exception {
		boardMapper.updateHitCount(boardIdx);	//  조회수 증가
		
		BoardDto board = boardMapper.selectBoardDetail(boardIdx);	// 게시글 내용 조회
		
		return board;
	}
	
	@Override
	public void updateBoard(BoardDto board) throws Exception{
		boardMapper.updateBoard(board);
	}
	
	@Override
	public void deleteBoard(int boardIdx) throws Exception{
		boardMapper.deleteBoard(boardIdx);
	}
}
