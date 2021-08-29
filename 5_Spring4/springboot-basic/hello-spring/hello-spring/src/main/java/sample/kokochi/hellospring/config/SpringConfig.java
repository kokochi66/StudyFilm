package sample.kokochi.hellospring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sample.kokochi.hellospring.aop.TimeTraceAop;
import sample.kokochi.hellospring.repository.*;
import sample.kokochi.hellospring.service.MemberService;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

/*    private EntityManager em;
    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }*/

/*    private DataSource dataSource;
    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }*/

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }   // memberService 스프링 빈 선언

//    @Bean
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }   // 시간 계산 AOP
/*    @Bean
    public MemberRepository memberRepository() {
        return new JpaMemberRepository(em);
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JdbcMemberRepositoryImpl(dataSource);
//        return new MemoryMemberRepositoryImpl();
        // 자바 코드로 직접 스프링 빈을 등록하면, 추후에 다른 빈 코드를 사용하고 싶을 경우에, 해당 코드만 변경하면 가능하다는 장점이 있다.
    }   // memberRepository 스프링 빈 선언*/

    /*
    * 2. 자바 코드로 직접 스프링 빈 등록하기
    * @Configuration 어노테이션을 적용한 설정파일 내에서 스프링 빈을 등록할 수 있다.
    * */
}
