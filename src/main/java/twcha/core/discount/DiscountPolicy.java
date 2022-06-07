package twcha.core.discount;

import twcha.core.member.Member;

public interface DiscountPolicy {

    /**
     *
     * @return 할인 대상 금액액     */
    int discount(Member member, int price);


}
