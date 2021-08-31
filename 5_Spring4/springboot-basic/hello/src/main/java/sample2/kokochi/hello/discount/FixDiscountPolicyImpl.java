package sample2.kokochi.hello.discount;

import org.springframework.stereotype.Component;
import sample2.kokochi.hello.member.Grade;
import sample2.kokochi.hello.member.Member;

public class FixDiscountPolicyImpl implements DiscountPolicy {

    private final int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) return discountFixAmount;
        else return 0;
    }
}
