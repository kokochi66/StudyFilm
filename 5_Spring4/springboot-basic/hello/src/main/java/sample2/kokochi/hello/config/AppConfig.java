package sample2.kokochi.hello.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sample2.kokochi.hello.discount.DiscountPolicy;
import sample2.kokochi.hello.discount.RateDiscountPolicyImpl;
import sample2.kokochi.hello.member.repository.MemberRepository;
import sample2.kokochi.hello.member.repository.MemoryMemberRepositoryImpl;
import sample2.kokochi.hello.member.service.MemberService;
import sample2.kokochi.hello.member.service.MemberServiceImpl;
import sample2.kokochi.hello.order.OrderService;
import sample2.kokochi.hello.order.OrderServiceImpl;
@Configuration
public class AppConfig {


    // Repository
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepositoryImpl();
    }

    // Service
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    // Policy
    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicyImpl();
    }
}
