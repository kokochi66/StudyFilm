package sample2.kokochi.hello.App;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sample2.kokochi.hello.config.AppConfig;
import sample2.kokochi.hello.member.Grade;
import sample2.kokochi.hello.member.Member;
import sample2.kokochi.hello.member.service.MemberService;


public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("member = " + member.getName());
        System.out.println("findmember = " + findMember.getName());
    }
}
