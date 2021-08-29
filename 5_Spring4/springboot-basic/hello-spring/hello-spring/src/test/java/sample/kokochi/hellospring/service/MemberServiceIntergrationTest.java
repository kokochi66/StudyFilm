package sample.kokochi.hellospring.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import sample.kokochi.hellospring.domain.Member;
import sample.kokochi.hellospring.repository.MemberRepository;
import sample.kokochi.hellospring.repository.MemoryMemberRepositoryImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional  // DB의 트랜잭션 개념이 반영, 커밋하기 전 까지는 DB에 반영되지 않음(다시 롤백함)
    // => DB에 데이터가 남지 않으므로 다음 테스트에 영향을 주지 않는다.
    // 이외에도 @Commit을 사용해서 커밋하도록 설정할 수 있는 등 다른 어노테이션도 제공한다.
class MemberServiceIntergrationTest {
    // 테스트 만들기 단축키 => ctrl + shift + T
    // 가능하면 스프링까지 합쳐서 통합테스트를 하는 것 보다 자잘한 단위테스트를 많이 만드는 것이 훨씬 좋다. (속도도 빠르고, 구조도 파악할 수 있음)

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
//    @Commit
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("s4");
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
}