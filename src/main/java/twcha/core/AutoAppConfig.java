package twcha.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        //@Configuration이 붙은 AppConfig도 스프링빈에 등록되어 기존의 수동등록하는것과 달라지지 않음.
        //예제코드를 유지하기 위해 제외
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
