package Study.datajpa.repository;

import Study.datajpa.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
@Transactional
@Rollback(false)
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void basicCRUD() {
        Member member1 = Member.createMember("kokochi", 20);
        Member member2 = Member.createMember("kushi", 27);
        memberRepository.save(member1);
        memberRepository.save(member2);

        // 단건 조회 검증
        Member findMember1 = memberRepository.findById(member1.getId()).orElseThrow();
        Member findMember2 = memberRepository.findById(member2.getId()).orElseThrow();
        assertThat(member1).isEqualTo(findMember1);
        assertThat(member2).isEqualTo(findMember2);

        // 리스트 검증
        List<Member> all = memberRepository.findAll();
        assertThat(all.size()).isEqualTo(2);

        // 카운트 검증
        long count = memberRepository.count();
        assertThat(count).isEqualTo(2);

        // 삭제 검증
        memberRepository.delete(member1);
        memberRepository.delete(member2);
        long deleteCount = memberRepository.count();
        assertThat(deleteCount).isEqualTo(0);
    }

    @Test
    public void findByUsernameAndAGeGreaterThen() {
        Member member1 = Member.createMember("kokochi1", 20);
        Member member2 = Member.createMember("kokochi2", 27);
        Member member3 = Member.createMember("kokochi3", 27);
        Member member4 = Member.createMember("kokochi4", 27);
        Member member5 = Member.createMember("kokochi5", 27);
        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);
        memberRepository.save(member4);
        memberRepository.save(member5);

        List<Member> result = memberRepository.findTop3By();

        for (Member member : result) {
            System.out.println("TEST :: member = " + member);
        }
    }

    @Test
    public void findTestNamedQuery() {
        Member member1 = Member.createMember("kokochi1", 20);
        Member member2 = Member.createMember("kokochi2", 27);
        Member member3 = Member.createMember("kokochi3", 27);
        Member member4 = Member.createMember("kokochi4", 27);
        Member member5 = Member.createMember("kokochi5", 27);
        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);
        memberRepository.save(member4);
        memberRepository.save(member5);

        List<Member> result = memberRepository.findByUserName("kokochi1");

        for (Member member : result) {
            System.out.println("TEST :: member = " + member);
        }
    }
}