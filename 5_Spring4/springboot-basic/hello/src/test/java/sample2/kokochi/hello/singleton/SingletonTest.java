package sample2.kokochi.hello.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sample2.kokochi.hello.config.AppConfig;
import sample2.kokochi.hello.member.service.MemberService;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    @Test
    @DisplayName("순수DI컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService = " + memberService);
        System.out.println("memberService = " + memberService2);

        // 두 객체는 서로 다른 객체이므로, 객체는 서로 다른 객체여야 한다.
        assertThat(memberService).isNotSameAs(memberService2);
    }   // 고객이 서비스를 호출할 때마다 객체를 계속 생성하기 때문에 메모리 낭비가 심각하게 발생하게된다.
    // 객체를 한개만 생성하고, 객체 하나로 공유해서 사용하도록 하는 것이 싱글톤 패턴이다.

    @Test
    @DisplayName("싱글톤패턴적용")
    void SingletonContainer() {
        SingletonService instance = SingletonService.getInstance();
        SingletonService instance2 = SingletonService.getInstance();
        System.out.println("싱글톤 패턴을 적용하면 객체를 새롭게 여러번 생성하더라도, 같은 객체가 생성된다.");
        assertThat(instance).isEqualTo(instance2);
        // same => ==를 이용해서 비교 (참조)
        // equal => Equals 메소드를 이용해서 비교
    }

    @Test
    @DisplayName("스프링적용")
    void SpringContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);
        System.out.println("스프링 컨테이너에서 싱글톤 패턴이 적용된다.");
        assertThat(memberService).isSameAs(memberService2);
    }

    /*  싱글톤 방식의 주의점
    *   싱글톤 객체는 상태를 유지하지않고, 무상태 상태로 설계해야한다.
    * 특정 클라이언트가 값을 변경할 수 있는 필드가 있어서는 안되며, 가급적 읽기만 가능하여야한다.
    * (공유되지 않는 변수, 파라미터, 쓰레드를 사용해야한다)
    * */
}
