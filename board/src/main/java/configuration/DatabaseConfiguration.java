package configuration;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("classpath:/application.properties")	// 설정파일 사용할 수 있게해줌. 추가해서 다른것도 사용가능. @PropertySource
public class DatabaseConfiguration {

	@Bean
	@ConfigurationProperties(prefix="spring.datasource.hikari")
	public HikariConfig hikariConfig() {
	  // 커넥션 풀 히카리CP 사용하는데 prefix가 spring.datasource.hikari로 설정되어있게 때문에 
	  // spring.datasource.hikari로 시작하는 설정을 이용해서 히카리CP의 설정 파일 만듬
		return new HikariConfig();
	}
	
	
	@Bean
	public DataSource dataSource() throws Exception{
		// 히카리CP의 설정 파일을 이용해서 데이터베이스와 연결하는 데이터 소스를 생성
		DataSource dataSource = new HikariDataSource(hikariConfig());
		System.out.println(dataSource.toString());
		return dataSource;
	}
}
