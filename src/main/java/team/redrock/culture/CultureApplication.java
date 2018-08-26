package team.redrock.culture;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
@MapperScan("team.redrock.culture.mapper")
public class CultureApplication {

	public static void main(String[] args) {
		SpringApplication.run(CultureApplication.class, args);
	}
}
