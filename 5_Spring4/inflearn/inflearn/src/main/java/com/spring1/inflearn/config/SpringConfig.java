package com.spring1.inflearn.config;

import com.spring1.inflearn.member.MemberJpaRepositoryImpl;
import com.spring1.inflearn.member.MemberRepository;
import com.spring1.inflearn.member.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    // 자바 코드를 통해 직접 스프링 설정을 등록하는 방법

    private final DataSource dataSource;
    private final EntityManager entityManager;

    public SpringConfig(DataSource dataSource, EntityManager entityManager) {
        this.dataSource = dataSource;
        this.entityManager = entityManager;
    }


    @Bean
    public MemberRepository memberRepository() {
//        System.out.println("TEST :: 로그 :: MemberRepository 빈 등록");
        return new MemberJpaRepositoryImpl(entityManager);

    }

    @Bean
    public MemberService memberService() {
//        System.out.println("TEST :: 로그 :: MemberService 빈 등록");
        return new MemberService(memberRepository());
    }


}
