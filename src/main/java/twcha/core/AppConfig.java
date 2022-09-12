/*
애플리케이션의 실제 동작에 필요한 구현 객체를 생성 한다.
생성한 객체 인스턴스의 참조(레퍼렌스)를 생성자를 통해서 주입(연결)해준다.
구현체가 인터페이스에만 의존하게됨.

관심사의 분리 : 객체를 생성하고 연결하는 역할과 실행하는 역할 분리.
객체 생성 및 연결 : AppConfig
실행 : Impl 구현체
 */
package twcha.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import twcha.core.discount.DiscountPolicy;
//import twcha.core.discount.FixDiscountPolicy;
import twcha.core.discount.RateDiscountPolicy;
import twcha.core.member.MemberRepository;
import twcha.core.member.MemberService;
import twcha.core.member.MemberServiceImpl;
import twcha.core.member.MemoryMemberRepository;
import twcha.core.order.OrderService;
import twcha.core.order.OrderServiceImpl;

// Application의 구성정보를 저장하는 파일에 어노테이션 적용
@Configuration
public class AppConfig {
//    역할과 역할에 대한 구현체가 명시되도록 리팩터링 
//    -> 역할과 구현 클래스가 한눈에 들어옴 -> 
//    애플리케이션 전체 구성 빠르게 파악 가능
//    new MemoryMemberRepository() 중복 제거

    // @Bean 어노테이션 적용시 스프링 컨테이너에 등록됨
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        새로운 할인 정책을 적용하기 위해서는, 구체 클래스만 변경해주면 된다.
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
