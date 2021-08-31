package sample2.kokochi.hello.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sample2.kokochi.hello.member.service.MemberService;
import sample2.kokochi.hello.order.OrderService;

import static org.assertj.core.api.Assertions.*;

public class AutoAppConfigTest {

    @Test
    @DisplayName("AutoAppConfig 테스트")
    void basicScan() {
        ApplicationContext ac = new
                AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberService memberService = ac.getBean(MemberService.class);
        OrderService orderService = ac.getBean(OrderService.class);

        assertThat(memberService).isInstanceOf(MemberService.class);
        assertThat(orderService).isInstanceOf(OrderService.class);
    }

    /*
    * @ComponentScan은 @Component가 붙은 모든 클래스를 빈으로 등록한다.
    * 여기서 빈의 이름은 디폴트로는 특정 클래스의 첫글자를 소문자로 하여 생성된다.
    * 디폴트값을 사용하고싶지 않다면 원하는 값을 @Component에 등록할 수 있다.
    * */
}
