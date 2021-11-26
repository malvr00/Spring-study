package board;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// 테스트 도구 이용할 때 사용

@RunWith(SpringRunner.class)
@SpringBootTest
class BoardApplicationTests {
	
	@Autowired // 프로파일 전략을 사용 중이라면 원하는 프로파일 환경값 설정이 가능 하다.
	private SqlSessionTemplate sqlSession;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testSqlSession() throws Exception{
		System.out.println(sqlSession.toString());
	}

}
