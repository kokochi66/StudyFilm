package sample2.kokochi.hello.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SingletonWithPrototypeTest1 {

    @Test
    void prototypeFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeHBean.class);
        PrototypeHBean bean1 = ac.getBean(PrototypeHBean.class);
        bean1.addCount();
        Assertions.assertThat(bean1.getCount()).isEqualTo(1);
        PrototypeHBean bean2 = ac.getBean(PrototypeHBean.class);
        bean2.addCount();
        Assertions.assertThat(bean2.getCount()).isEqualTo(1);
    }

    @Test
    void singletonClientUsePrototype() {
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(ClientBean.class, PrototypeHBean.class);
        ClientBean bean1 = ac.getBean(ClientBean.class);
        int count1 = bean1.logic();
        Assertions.assertThat(count1).isEqualTo(1);

        ClientBean bean2 = ac.getBean(ClientBean.class);
        int count2 = bean2.logic();
        Assertions.assertThat(count2).isEqualTo(2);
        // 프로토타입 빈을 불러왔음에도 불구하고, 카운트가 겹쳐서 쌓이게 된다.
        // 싱글톤 빈 안에 프로토타입 빈을 생성하여도, 이미 싱글톤 빈은 한 번 생성되고, 다시한번 메소드를 호출하지 않기 때문에
        // 두 프로토타입 빈은 동일한 빈이 된다.
    }

    @Scope("singleton")
    static class ClientBean {
        private final PrototypeHBean prototypeBean;

        public ClientBean(PrototypeHBean prototypeBean) {
            this.prototypeBean = prototypeBean;
        }

        public int logic() {
            prototypeBean.addCount();
            int count = prototypeBean.getCount();
            return count;

        }
    }

    @Scope("prototype")
    static class PrototypeHBean {
        private int count = 0;

        public void addCount() {
            count++;
        }

        public int getCount() {
            return count;
        }

        @PostConstruct
        public void init() {
            System.out.println("PrototypeHBean.init " + this);
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeHBean.destroy");
        }

    }

}
