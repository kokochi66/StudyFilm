package sample.kokochi.hellospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import sample.kokochi.hellospring.service.MemberService;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        /* 자바 빈을 등록하는 방법(2)
         *  1. 컴포넌트 스캔 (컴포넌트 어노테이션으로 등록하여, 모든 컴포넌트가 알아서 등록되어, 빈을 서로 연결하여 사용할 수 있도록 해준다)
         * 원하는 패키지 아무데나 구성하여, 컴포넌트를 등록한다고 스캔이 가능한 것은 아니다.
         * HelloSpringApplication의 하위 패키지에서만 기본적으로 스캔 대상으로 지정될 수 있다. (별도로 등록하면 다른 곳에 적용하여도 가능하다)
         * 스프링은 스프링 컨테이너에 스프링 빈을 등록할 때에, 싱글톤을 기본으로 하여 등록한다.
         * 같은 스프링 빈이면 모두 같은 인스턴스를 사용하도록 되어있다. (특별한 케이스로 설정하지 않는 한)
         * */
        this.memberService = memberService;
        /* memberService를 적용하는 방법에는 필드주입(필드에직접 주입), 생성자 주입, Setter 주입이 있다.
        필드 직접 주입은 자유도가 떨어져서 단점이 있고, Setter주입은 추후에 오류발생의 여지를 남겨둘 수 있다.
        그래서 기본적으로 생성자 주입을 사용하는것이 좋다. (생성자 주입은 상황에 따라서 쉽게 구현을 변경할 수 있다)
        * */
    } //    스프링이 관리하여, 스프링에서 가져다 쓰도록 해야한다. (스프링 컨테이너에 등록함)

}
