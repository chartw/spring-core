package twcha.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//해당 어노테이션에 @ComponentScan이 포함되어 있다. 때문에 자동으로 컴포넌트 스캔이 일어남.
@SpringBootApplication
public class CoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}

}
