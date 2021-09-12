package sample2.kokochi.hello.config;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sample2.kokochi.hello.member.Member;
import sample2.kokochi.hello.member.repository.MemberRepository;
import sample2.kokochi.hello.member.service.MemberService;
import sample2.kokochi.hello.member.service.MemberServiceImpl;
import sample2.kokochi.hello.order.OrderService;
import sample2.kokochi.hello.order.OrderServiceImpl;

import static org.assertj.core.api.Assertions.*;

public class ConfigTest {

    @DisplayName("싱글톤 적용확인")
    @Test
    void singletonCheck() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl memService = ac.getBean(MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean(OrderServiceImpl.class);
        MemberRepository memRepository = ac.getBean(MemberRepository.class);
        assertThat(memService.getMemberRepository()).isEqualTo(memRepository);
    }
}
