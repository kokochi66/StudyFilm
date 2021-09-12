package sample2.kokochi.hello.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sample2.kokochi.hello.config.AppConfig;
import sample2.kokochi.hello.discount.FixDiscountPolicyImpl;
import sample2.kokochi.hello.member.Grade;
import sample2.kokochi.hello.member.Member;
import sample2.kokochi.hello.member.repository.MemoryMemberRepositoryImpl;
import sample2.kokochi.hello.member.service.MemberService;

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

    @Test
    void createOrderServiceImpl() {
        MemoryMemberRepositoryImpl memberRepository = new MemoryMemberRepositoryImpl();
        memberRepository.save(new Member(1L, "name", Grade.VIP));
        OrderServiceImpl orderServiceImpl  = new OrderServiceImpl(memberRepository,
                new FixDiscountPolicyImpl());   // 생성자 주입을 사용하면, 객체를 부여할 수 있도록 표시가 나서 쉽게 확인이 가능하다.
        orderServiceImpl.createOrder(1L, "itemA", 10000);
        // 생성자 주입으로 인해서, 각 변수에 상수값인 final을 사용할 수 있다.
        // final을 사용하면 오류를 빠르게 잡을 수 있도록 컴파일 오류를 유도할 수 있다
        // 컴파일 오류가 세상에서 가장 빠르고, 좋은 오류다!
    }

}
