package sample2.kokochi.hello.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClientFromAnnotation client = ac.getBean(NetworkClientFromAnnotation.class);
        //NetworkClientFromConfBean client = ac.getBean(NetworkClientFromConfBean.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig {
        @Bean
        // @Bean(initMethod = "init", destroyMethod = "close")
        public NetworkClientFromAnnotation networkClient() {
        //public NetworkClientFromConfBean networkClient() {
            NetworkClientFromAnnotation networkClient = new NetworkClientFromAnnotation();
            // NetworkClientFromConfBean networkClient = new NetworkClientFromConfBean();
            networkClient.setUrl("http://hello-spring.kokochikochi");
            return networkClient;
        }
    }

}
