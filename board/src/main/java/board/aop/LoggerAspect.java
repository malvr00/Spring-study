package board.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component	// Bean Configuration 파일에 Bean을 따로 등록하지 않아도 사영할 수 있다. ( 빈 등록자체를 빈 클래스 자체에다가 할 수 있다는 의미)
@Aspect	// 자바코드에서 AOP를 설정. ( 공통적으로 적용될 기능 )
public class LoggerAspect {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	// Around 어노테이션으로 해당기능이 실행될 시점, 어드바이스를 정의. ( Advice )
	// 여기서는 메서드의 실행 전후 또는 예외 발생 시점에 사용할 수 있는 Around 어드바이스를 적용
	// execution은 포인트컷 표현식으로 적용할 메서드를 명시할 때 사용
	@Around("execution(* board..controller.*Controller.*(..)) or "
			+ "execution(* board..service.*Impl.*(..)) or "
			+ "execution(* board..dao.*Mapper.*(..))")
	public Object logPrint(ProceedingJoinPoint joinPoint) throws Throwable{
		// 실행되는 메서드의 이름을 이용해서 컨트롤러, 서빗그, 매퍼를 구분한 후 실행되는 메서드의 이름을 출력
		String type="";
		String name= joinPoint.getSignature().getDeclaringTypeName();
		if(name.indexOf("Controller") > -1) {
			type = "Controller \t :  ";
		}else if(name.indexOf("Service") > -1) {
			type = "ServiceImpl \t :  ";
		}else if(name.indexOf("Mapper") > -1) {
			type = "Mapper \t\t :  ";
		}
		
		log.debug(type + name + "." + joinPoint.getSignature().getName() + "()");
		
		return joinPoint.proceed();
	}
}
