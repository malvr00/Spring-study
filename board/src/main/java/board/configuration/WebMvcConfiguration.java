package board.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import board.interceptor.LoggerInterceptor;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer{
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 인터셉터를 등록합니다. addPathPatterns() 메소드와 excludePathPatterns() 메서드를 이용하여 요청 주소의 패턴과
		// 제외할 요청 주소의 패턴을 지정하여 선택적으로 적용할 수 있습니다. 여기서는 모든 요청에 대해서 인터셉터를 적용하기 때문에 특별한 패턴은 지정하지 않았음.
		registry.addInterceptor(new LoggerInterceptor());
	}
}
