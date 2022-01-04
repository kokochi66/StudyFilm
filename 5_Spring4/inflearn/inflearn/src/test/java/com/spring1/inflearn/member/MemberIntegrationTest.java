package com.spring1.inflearn.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
public class MemberIntegrationTest {


    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception {
        Member member = new Member("kokochi");

        Long saveId = memberService.join(member);

        Member res = memberService.findOne(saveId).get();

        Assertions.assertThat(res).isEqualTo(member);
    }

    @Test
    public void 중복회원체크() throws Exception {
        Member member1 = new Member();
        member1.setName("코렛트");

        Member member2 = new Member();
        member2.setName("코렛트");

        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class ,
                () -> memberService.join(member2)); // 예외가 발생하는지를 체크한다.

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

}
