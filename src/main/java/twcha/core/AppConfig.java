/*
애플리케이션의 실제 동작에 필요한 구현 객체를 생성 한다.
생성한 객체 인스턴스의 참조(레퍼렌스)를 생성자를 통해서 주입(연결)해준다.
구현체가 인터페이스에만 의존하게됨.

관심사의 분리 : 객체를 생성하고 연결하는 역할과 실행하는 역할 분리.
객체 생성 및 연결 : AppConfig
실행 : Impl 구현체
 */
package twcha.core;

import twcha.core.discount.FixDiscountPolicy;
import twcha.core.member.MemberService;
import twcha.core.member.MemberServiceImpl;
import twcha.core.member.MemoryMemberRepository;
import twcha.core.order.OrderService;
import twcha.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
