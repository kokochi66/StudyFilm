package Study.datajpa.repository;

import Study.datajpa.entity.Member;
import Study.datajpa.entity.Team;
import Study.datajpa.repository.MemberJpaRepository;
import Study.datajpa.repository.MemberRepository;
import Study.datajpa.repository.TeamJpaRepository;
import Study.datajpa.repository.TeamRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class MemberJpaRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private TeamRepository teamRepository;

    @Test
    public void testEntity() {
        Team teamA = Team.createTeam("teamA");
        Team teamB = Team.createTeam("teamB");

        teamRepository.save(teamA);
        teamRepository.save(teamB);


        Member member1 = Member.createMember("kokochi", 10, teamA);
        Member member2 = Member.createMember("jaewon", 26, teamB);
        Member member3 = Member.createMember("minsub", 33, teamA);
        Member member4 = Member.createMember("jaeil", 99, teamB);

        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);
        memberRepository.save(member4);

        List<Member> members = memberRepository.findAll();
        for (Member member : members) {
            System.out.println("TEST :: member = " + member);
            System.out.println("TEST :: members Team = = " + member.getTeam());
            System.out.println("=================================================");
        }
    }

    @Autowired
    private MemberJpaRepository memberJpaRepository;
    @Autowired
    private TeamJpaRepository teamJpaRepository;

    @Test
    public void basicCRUD() {
        Member member1 = Member.createMember("kokochi", 20);
        Member member2 = Member.createMember("kushi", 27);
        memberJpaRepository.save(member1);
        memberJpaRepository.save(member2);

        // 단건 조회 검증
        Member findMember1 = memberJpaRepository.findById(member1.getId()).orElseThrow();
        Member findMember2 = memberJpaRepository.findById(member2.getId()).orElseThrow();
        assertThat(member1).isEqualTo(findMember1);
        assertThat(member2).isEqualTo(findMember2);

        // 리스트 검증
        List<Member> all = memberJpaRepository.findAll();
        assertThat(all.size()).isEqualTo(2);

        // 카운트 검증
        long count = memberJpaRepository.count();
        assertThat(count).isEqualTo(2);

        // 삭제 검증
        memberJpaRepository.delete(member1);
        memberJpaRepository.delete(member2);
        long deleteCount = memberJpaRepository.count();
        assertThat(deleteCount).isEqualTo(0);
    }

    @Test
    public void findByUsernameAndAGeGreaterThen() {
        Member member1 = Member.createMember("kokochi", 20);
        Member member2 = Member.createMember("kokochi", 27);
        memberJpaRepository.save(member1);
        memberJpaRepository.save(member2);

        List<Member> result = memberJpaRepository.findByUsernameAndAgeGreaterThen("kokochi", 21);
        assertThat(result.get(0).getName()).isEqualTo("kokochi");
        assertThat(result.get(0).getAge()).isEqualTo(27);

        for (Member member : result) {
            System.out.println("TEST :: member = " + member);
        }
    }

    @Test
    public void findTest1() {

        List<Member> result = memberJpaRepository.findByUsernameAndAgeGreaterThen("kokochi", 21);
        assertThat(result.get(0).getName()).isEqualTo("kokochi");
        assertThat(result.get(0).getAge()).isEqualTo(27);

        for (Member member : result) {
            System.out.println("TEST :: member = " + member);
        }
    }

    @Test
    public void findTestNamedQuery() {
        Member member1 = Member.createMember("AAA", 20);
        Member member2 = Member.createMember("BBB", 27);
        memberJpaRepository.save(member1);
        memberJpaRepository.save(member2);

        List<Member> result = memberJpaRepository.findByUsername("AAA");
        assertThat(result.get(0).getName()).isEqualTo("AAA");
        assertThat(result.get(0).getAge()).isEqualTo(20);

        for (Member member : result) {
            System.out.println("TEST :: member = " + member);
        }
    }

}