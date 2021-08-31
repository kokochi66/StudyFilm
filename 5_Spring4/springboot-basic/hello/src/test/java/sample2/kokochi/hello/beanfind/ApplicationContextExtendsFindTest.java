package sample2.kokochi.hello.beanfind;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sample2.kokochi.hello.discount.DiscountPolicy;
import sample2.kokochi.hello.discount.FixDiscountPolicyImpl;
import sample2.kokochi.hello.discount.RateDiscountPolicyImpl;
import sample2.kokochi.hello.member.repository.MemberRepository;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextExtendsFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("자식오류")
    void findBeanByParentDuplicate() {
        System.out.println("부모 타입을 조회시, 자식이 둘 이상 있으면 중복 오류가 발생한다.");
        assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(DiscountPolicy.class));
    }

    @Test
    @DisplayName("자식이름지정")
    void findBeanByNameParentDuplicate() {
        System.out.println("자식 중복 시에는 자식의 빈 이름을 지정하여 오류를 해결할 수 있다.");
        DiscountPolicy discountPolicy = ac.getBean("rateDiscountPolicy", DiscountPolicy.class);
        assertThat(discountPolicy).isInstanceOf(RateDiscountPolicyImpl.class);
    }

    @Test
    @DisplayName("특정타입조회")
    void findBeanBySubType() {
        System.out.println("자식 중복시에 자식의 구체적인 타입을 조회하여 오류를 해결할 수 있다.");
        DiscountPolicy discountPolicy = ac.getBean(RateDiscountPolicyImpl.class);
        assertThat(discountPolicy).isInstanceOf(RateDiscountPolicyImpl.class);
    }

    @Test
    @DisplayName("부모타입모두조회")
    void findBeanAllByParentType() {
        System.out.println("자식 중복시에 자식의 구체적인 타입을 조회하여 오류를 해결할 수 있다.");
        Map<String, DiscountPolicy> beanType = ac.getBeansOfType(DiscountPolicy.class);
        for(String key : beanType.keySet()) {
            System.out.println("key = " + key + " // value = " + beanType.get(key));
        }
    }

    @Test
    @DisplayName("부모타입모두조회(Object)")
    void findBeanAllByObjectType() {
        System.out.println("자식 중복시에 자식의 구체적인 타입을 조회하여 오류를 해결할 수 있다.");
        Map<String, Object> beanType = ac.getBeansOfType(Object.class);
        for(String key : beanType.keySet()) {
            System.out.println("key = " + key + " // value = " + beanType.get(key));
        }
    }

    @Configuration
    static class TestConfig {
        @Bean
        public DiscountPolicy rateDiscountPolicy() {
            return new RateDiscountPolicyImpl();
        }
        @Bean
        public DiscountPolicy fixDiscountPolicy() {
            return new FixDiscountPolicyImpl();
        }
    }
}
