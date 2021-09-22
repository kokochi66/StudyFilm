package sample2.kokochi.hello.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PrototypeTest {

    @Test
    void prototypeBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        System.out.println("find prototypeBean1");
        PrototypeBean bean1 = ac.getBean(PrototypeBean.class);
        System.out.println("find prototypeBean2");
        PrototypeBean bean2 = ac.getBean(PrototypeBean.class);
        Assertions.assertThat(bean1).isNotSameAs(bean2);
        ac.close();
        // 프로토타입 scope로 빈을 생성한 경우에는, 빈을 불러들일 때 마다 새로운 객체를 불러들이므로,
        // 두 객체는 별도의 객체로써 생성된다.
        // 만들고 버린 객체이므로, close를 해주어도 destroy 메소드가 실행되지 않는다.
        // 객체를 종료할 필요가 있다면. 직접 하나하나의 빈을 destroy 메소드를 실행해주어야한다.
    }

    @Scope("prototype")
    static class PrototypeBean {
        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy");
        }
    }
}
