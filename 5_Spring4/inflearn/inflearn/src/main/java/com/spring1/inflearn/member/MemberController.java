package com.spring1.inflearn.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/member")
public class MemberController {
    /*
    *   일반적인 웹 어플리케이션 계층 구조
    *
    * 컨트롤러 -> 서비스 -> 리포지토리 -> DB
    * */

    // @Autowired를 생성자에 입력함을 통해서 자동주입
    private final MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // /member/list 멤버 리스트 가져오기
    @GetMapping(value = "/list")
    public String member(Model model) {
        System.out.println("/member/list GET");
        List<Member> members = memberService.findMembers();
        model.addAttribute("memberList", members);
        return "member/memberList";
    }

    @GetMapping(value="/add")
    public String memberAddGet(Model model) {
        System.out.println("/member/add GET");
        return "member/memberAdd";
    }

    @PostMapping(value = "/add")
    public String memberAddPost(Member member) {
        memberService.join(member);
        System.out.println("/member/add POST");
        return "redirect:/member/list";
    }

}
