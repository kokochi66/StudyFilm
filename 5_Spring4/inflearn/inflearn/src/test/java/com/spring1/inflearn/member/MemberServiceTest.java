package com.spring1.inflearn.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
        // MemberService를 선언할 때, Repository를 같이 넣어준다.
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    public void 회원가입_Repository로찾아오기() throws Exception {
        Member member = new Member();
        member.setName("탬탬버린");

        Long saveId = memberService.join(member);
        Member res = memberRepository.findById(saveId).get();
        assertEquals(member.getName(), res.getName());
    }

    @Test
    public void 회원가입_Service로찾아오기() throws Exception {
        Member member = new Member();
        member.setName("감블러");

        Long saveId = memberService.join(member);
        Member res = memberService.findOne(saveId).get();
        assertEquals(member.getName(), res.getName());
    }


    @Test
    public void 중복회원체크() throws Exception {
        Member member1 = new Member();
        member1.setName("탬탬버린");

        Member member2 = new Member();
        member2.setName("탬탬버린");

        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class ,
                () -> memberService.join(member2)); // 예외가 발생하는지를 체크한다.

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }





}
