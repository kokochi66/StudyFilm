package sample2.kokochi.hello.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sample2.kokochi.hello.config.AppConfig;
import sample2.kokochi.hello.member.Grade;
import sample2.kokochi.hello.member.Member;
import sample2.kokochi.hello.member.repository.MemoryMemberRepositoryImpl;
import sample2.kokochi.hello.member.service.MemberService;
import sample2.kokochi.hello.member.service.MemberServiceImpl;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(2000);
    }
}
