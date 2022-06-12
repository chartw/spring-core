package twcha.core.order;

import twcha.core.discount.DiscountPolicy;
import twcha.core.discount.FixDiscountPolicy;
import twcha.core.discount.RateDiscountPolicy;
import twcha.core.member.Member;
import twcha.core.member.MemberRepository;
import twcha.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    OCP 위반 : 기존 소스 코드를 수정해야함.
//    DIP 위반 : 인터페이스 discountPolicy와 구현체 FixDiscountPolicy에 의존함.
//    DIP 위반이 발생했기 때문에, OCP

//    추상화인 인터페이스만 의존(DIP해결), 그러나 구현체가 연결되어 있지 않아 NPE 발생.
    private DiscountPolicy discountPolicy;

//    DIP 완성. AppConfig가 OrderServiceImpl 생성시 구현객체를 주입함.
//    memberRepository, discountPolicy 인터페이스에만 의존
//    실행에만 집중할 수 있음.
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);

    }
}
