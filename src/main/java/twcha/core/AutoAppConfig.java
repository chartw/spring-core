package twcha.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


@Configuration
@ComponentScan(
        //base 지정안했을때 Default: @ComponentScan 이 붙은 설정 정보 클래스의 패키지가 시작 위치
        //컴포넌트 스캔 대상 지정, {}로 다수 지정 가능
        basePackages = "twcha.core.member",
        //지정한 클래스의 패키지를 탐색 시작위치로 지정(twcha.core)
        basePackageClasses = AutoAppConfig.class,
        //@Configuration이 붙은 AppConfig도 스프링빈에 등록되어 기존의 수동등록하는것과 달라지지 않음.
        //예제코드를 유지하기 위해 제외
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    // 수동 빈 등록으로 인해 충돌 발생
    // 스프링 자체에선 수동 빈이 오버라이딩 되어 오류 발생 x
    // 스프링 부트에선 오류로 처리
//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
}
