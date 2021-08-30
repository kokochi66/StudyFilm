package sample2.kokochi.hello;

import sample2.kokochi.hello.member.Grade;
import sample2.kokochi.hello.member.Member;
import sample2.kokochi.hello.member.service.MemberService;
import sample2.kokochi.hello.member.service.MemberServiceImpl;


public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("member = " + member.getName());
        System.out.println("findmember = " + findMember.getName());
    }
}
