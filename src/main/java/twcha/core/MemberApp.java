package twcha.core;

import twcha.core.member.Grade;
import twcha.core.member.Member;
import twcha.core.member.MemberService;
import twcha.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member =" + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
