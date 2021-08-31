package sample2.kokochi.hello.discount;

import org.springframework.stereotype.Component;
import sample2.kokochi.hello.member.Grade;
import sample2.kokochi.hello.member.Member;

@Component
public class RateDiscountPolicyImpl implements DiscountPolicy {

    private final double discountRate = 0.2;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) return (int)(price * discountRate);
        else return 0;
    }
}
