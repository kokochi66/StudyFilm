package sample.kokochi.hellospring.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sample.kokochi.hellospring.domain.Member;
import sample.kokochi.hellospring.repository.MemoryMemberRepositoryImpl;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    // 테스트 만들기 단축키 => ctrl + shift + T
    MemoryMemberRepositoryImpl memberRepository;
    MemberService memberService = new MemberService(memberRepository);

    @BeforeEach // 각 메소드가 실행도기ㅣ 이전에 호출되는 메소드
    public void BeforeEach() {
        memberRepository = new MemoryMemberRepositoryImpl();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach  // 각 메소드가 끝날 때 마다 호출되는 메소드
    public void afterEach() {
        memberRepository.clearStore();
        // 각 메소드가 끝날 때 마다 repository 값을 초기화해주어야 테스트시 버그발생을 막을 수 있다.
    }

    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("sp1");
        // when
        Long saveId = memberService.join(member);
        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("sp1");
        Member member2 = new Member();
        member2.setName("sp1");
        // when
        memberService.join(member1);
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        // 함수 실행시에 어떤 익셉션이 발생되는지를 확인해준다.
/*        try {
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
        예외를 잡기 위해서 try - catch 문을 이용해서 잡을 수도 있다.
        */
        // then
    }

    @Test
    void 사용자리스트() {
    }

    @Test
    void 사용자가져오기() {
    }
}