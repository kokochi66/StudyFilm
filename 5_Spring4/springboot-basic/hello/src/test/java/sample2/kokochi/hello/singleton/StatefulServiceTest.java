package sample2.kokochi.hello.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    @DisplayName("상태값 적용된 싱글톤")
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService sf1 = ac.getBean(StatefulService.class);
        StatefulService sf2 = ac.getBean(StatefulService.class);

        // 쓰레드1에서 A사용자가 10000원을 주문
        int priceA = sf1.order("userA", 10000);
        // 쓰레드2에서 B사용자가 20000원을 주문
        int priceB = sf2.order("userB", 20000);

        System.out.println("userA가 사용한 비용 = " + priceA);
        assertThat(priceA).isNotEqualTo(priceB);
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}