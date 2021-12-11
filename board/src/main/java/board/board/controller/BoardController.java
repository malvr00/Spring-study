package board.board.controller;

import java.util.List;

import board.board.dto.BoardDto;
import board.board.service.BoardService;

import org.slf4j.Logger;	// slf4j 로거 사용
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;
import lombok.extern.slf4j.Slf4j;

@Slf4j		// 어노베이션을 사용하면 로거를 따로 생성할 필요가 없음.
@Controller	// 스프링 MVC의 컨트롤러 의미, 해당 클래스를 컨트롤러로 동작하게 함
public class BoardController {
	@Autowired	// 해당 변수 및 메서드에 스프링이 관리하는 Bean을 자동으로 매핑
	private BoardService boardService;	// 비즈니스 로직을 처리하는 서비스 빈을 연결
	
//	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	// 어노테이션의 값으로 주소를 지정
	// /board/openBoardList.do라는 주소를 호출하면 스프링 디스패처는 호출된 주소와
	// @RequestMappin 어노테이션의 값이 동일한 메서드를 찾아 실행
	// 즉 클라이언트에서 호출한 주소와 그것을 수행할 메서드를 연결
	@RequestMapping("/board/openBoardList.do")
	public ModelAndView openBoardList() throws Exception{
		log.debug("openBoardList");
		// ModelAndView <-- 호출된 요청의 결과를 보여 줄 뷰를 지정.
		ModelAndView mv = new ModelAndView("/board/boardList"); // 보여줄 View 지정	// resources -> templates -> board
		
		List<BoardDto> list = boardService.selectBoardList(); // 게시글 목록을 조회하는 메소드 호출
		mv.addObject("list", list);	// 로직의 결과를 key = list, value = list 지정하여 저장

		return mv;
	}
	
	@RequestMapping("/board/openBoardWrite.do")
	public String openBoardWrite() throws Exception{
		// 게시글 작성화면 호출
		return "/board/boardWrite";
	}
	
	@RequestMapping("/board/insertBoard.do")
	public String insertBoard(BoardDto board) throws Exception{
		boardService.insertBoard(board);
		return "redirect:/board/openBoardList.do";
	}
	
	@RequestMapping("/board/openBoardDetail.do")
	public ModelAndView openBoardDetail(@RequestParam int boardIdx) throws Exception{
		// @RequestParam는 Get Parameter 에 전송된 변수 값 가져옴
		ModelAndView mv = new ModelAndView("/board/boardDetail");
		
		BoardDto board = boardService.selectBoardDetail(boardIdx);
		mv.addObject("board", board);
		
		return mv;
	}
	
	@RequestMapping("/board/updateBoard.do")
	public String updateBoard(BoardDto board) throws Exception{
		boardService.updateBoard(board);
		return "redirect:/board/openBoardList.do";
	}
	
	@RequestMapping("/board/deleteBoard.do")
	public String deleteBoard(int boardIdx) throws Exception{
		boardService.deleteBoard(boardIdx);
		return "redirect:/board/openBoardList.do";
	}
}
