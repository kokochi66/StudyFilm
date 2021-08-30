package sample2.kokochi.hello.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sample2.kokochi.hello.member.Grade;
import sample2.kokochi.hello.member.Member;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyImplTest {
    RateDiscountPolicyImpl discountPolicy = new RateDiscountPolicyImpl();

    @Test
    @DisplayName("VIP is discount 20%")
    void vip_o() {
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        int discount = discountPolicy.discount(member, 10000);
        Assertions.assertThat(discount).isEqualTo(2000);
    }
}