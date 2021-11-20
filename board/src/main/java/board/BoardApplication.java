package board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
// Description:
//Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured.
//Reason: Failed to determine a suitable driver class
// 이슈 해결 어노베이션 - 빈파일로 되있을때 해결 방안
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class BoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardApplication.class, args);
	}

}
