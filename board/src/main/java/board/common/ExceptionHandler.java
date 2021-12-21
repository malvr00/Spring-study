package board.common;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice	// 예외처리 클래스임을 알려줌
public class ExceptionHandler {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	// 해당 메소드에서 처리할 예외를 지정한다. 여기서는 기능을 확인하기 위해 간단히 Exception.class로 설정해서 모든 예외처리를했다.
	// 그렇지만 실제 프로젝트에서는 다양한 예외를 처리하기 위한 각각의 예외처리가 필요하다.
	// NullPointerException, NumberFormatException 등 자바의 비노 예외 및 프로젝트에 필요한 커스텀 예외를 포함해서 각각의 예외에 맞는 적절한 예외처리가 필요.
	// 절때 Exception 클래스를 이용해 한번에 모든 예외처리를 처리하지 않도록 한다.
	public ModelAndView defaultExceptionHandler(HttpServletRequest request, Exception exception) {
		// 에외 발생 시 보여줄 화면을 지정.
		// 에러가 발생하면 그 에러에 따라 적절한 예외처리 화면을 사용자에게 보여주는것이 좋다.
		ModelAndView mv = new ModelAndView("/error/error_default");
		mv.addObject("exception", exception);
		
		log.error("exception", exception);
		
		return mv;
	}
}
