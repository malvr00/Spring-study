package board.configuration;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("classpath:/application.properties")	// 설정파일 사용할 수 있게해줌. 추가해서 다른것도 사용가능. @PropertySource
public class DatabaseConfiguration {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Bean	//application.properties에 설정했던 데이터베이스 관련 정보를 사용하도록 지정합니다.
	@ConfigurationProperties(prefix="spring.datasource.hikari")
	public HikariConfig hikariConfig() {
	  // 커넥션 풀 히카리CP 사용하는데 prefix가 spring.datasource.hikari로 설정되어있게 때문에 
	  // spring.datasource.hikari로 시작하는 설정을 이용해서 히카리CP의 설정 파일 만듬
		return new HikariConfig();
	}
	
	@Bean
	public DataSource dataSource() throws Exception{
		// 히카리CP의 설정 파일을 이용해서 데이터베이스와 연결하는 데이터 소스를 생성
		return new HikariDataSource(hikariConfig());
	}
	
	@Bean
	public SqlSessionFactory SqlSessionFactory(DataSource dataSource) throws Exception{
		// SqlSessionFactory를 생성하기 위해 SqlSessionFactoryBean을 사용 ( 마이바티스를 스프링이 아닌 단독으로 사용 할 경우는 SqlSessionFactoryBuilder)
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		// 데이터소스 설정
		sqlSessionFactoryBean.setDataSource(dataSource);	
		// 매퍼 파일의 위치를 설정.
		// 매퍼 : 애플리케이션에서 사용할 SQL을 담고있는 XML 파일을 의미
		// 매퍼 단일 선택해서 사용가능. 현제는 전체 선택해서 쓰고 있음.
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/**/sql-*/xml"));
		
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
