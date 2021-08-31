package sample2.kokochi.hello.beanfind;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sample2.kokochi.hello.config.AppConfig;
import sample2.kokochi.hello.discount.DiscountPolicy;
import sample2.kokochi.hello.member.repository.MemberRepository;
import sample2.kokochi.hello.member.repository.MemoryMemberRepositoryImpl;
import sample2.kokochi.hello.member.service.MemberService;
import sample2.kokochi.hello.member.service.MemberServiceImpl;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextSameBeanFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("타입중복")
    void findBeanByTypeDuplicate() {
        System.out.println("타입으로 조회 시, 같은 타입이 둘 이상 있으면 중복 오류 발생");
        assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(MemberRepository.class));
    }

    @Test
    @DisplayName("빈이름지정")
    void findBeanByNameDuplicate() {
        System.out.println("타입으로 조회 시, 같은 타입이 둘 이상 있으면 이름을 지정하여 해결가능함");
        MemberRepository memberRepository = ac.getBean("memberRepository1", MemberRepository.class);
    }

    @Test
    @DisplayName("타입전조회")
    void findALlBeanByTypeDuplicate() {
        System.out.println("같은 타입의 모든 빈을 조회하기");
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        for(String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " // value = " + beansOfType.get(key));
        }
        System.out.println("beansofType = " + beansOfType);
        assertThat(beansOfType.size()).isEqualTo(2);

    }

    @Configuration
    static class SameBeanConfig {
        @Bean
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepositoryImpl();
        }
        @Bean
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepositoryImpl();
        }
    }
}
