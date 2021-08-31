package sample2.kokochi.hello.App;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sample2.kokochi.hello.config.AppConfig;
import sample2.kokochi.hello.member.Grade;
import sample2.kokochi.hello.member.Member;
import sample2.kokochi.hello.member.service.MemberService;
import sample2.kokochi.hello.order.Order;
import sample2.kokochi.hello.order.OrderService;


public class OrderApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("orderCalculate = " + order.calculatePrice());
    }
}
