package sample2.kokochi.hello.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SingletonTest {

    @Test
    void singletonBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);
        SingletonBean bean1 = ac.getBean(SingletonBean.class);
        SingletonBean bean2 = ac.getBean(SingletonBean.class);
        System.out.println("bean1 = " + bean1);
        System.out.println("bean2 = " + bean2);
        Assertions.assertThat(bean1).isSameAs(bean2);
        ac.close();
        // 싱글톤 패턴의 경우에는 생성한 두 객체가 동일한 객체임을 확인할 수 있다.
        // 일반적인 생성 구조로는 스프링은 싱글톤 패턴으로 생성된다.
    }

    @Scope("singleton")
    static class SingletonBean {
       @PostConstruct
       public void init() {
           System.out.println("singletonBean.init");
       }

       @PreDestroy
       public void destroy() {
           System.out.println("SingletonBean.destroy");
       }
    }

}
