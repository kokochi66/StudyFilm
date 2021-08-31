package sample2.kokochi.hello.beanDefinition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sample2.kokochi.hello.config.AppConfig;

public class BeanDefinitionTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 설정 메타정보확인")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for(String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("beanDefinitionName = " + beanDefinitionName + " // beanDefinition = " + beanDefinition);
            }
        }
    }
    // 메타정보를 기반으로 실제 인스턴스를 생성한다.
    /*
    * BeanDefinition을 직접 생성해서 스프링 컨테이너에 등록할 수도 있음.
    * 하지만 실제로 실무에서 직접 정의하는 경우는 거의없음. 그러므로 스프링이 다양한 형태의 설정정보를 BeanDefinition으로 추상화해서 정의한다는 정보만 이해하면 된다.
    *
    * */
}
