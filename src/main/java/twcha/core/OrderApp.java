package twcha.core;

import twcha.core.member.Grade;
import twcha.core.member.Member;
import twcha.core.member.MemberService;
import twcha.core.member.MemberServiceImpl;
import twcha.core.order.Order;
import twcha.core.order.OrderService;
import twcha.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
