package Study.datajpa.repository;

import Study.datajpa.entity.Member;
import Study.datajpa.entity.MemberDto;
import Study.datajpa.entity.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
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

    @Test
    public void findTestNamedQuery2() {
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

        List<Member> result = memberRepository.findUser("kokochi1", 20);

        for (Member member : result) {
            System.out.println("TEST :: member = " + member);
        }
    }

    @Test
    public void findTestUserName() {
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

        List<String> result = memberRepository.findUsernameList();
        for (String res : result) {
            System.out.println("TEST :: " + res);
        }
    }

    @Autowired
    private TeamRepository teamRepository;

    @Test
    public void findTestMemberDto() {
        Team teamA = Team.createTeam("teamA");
        Team teamB = Team.createTeam("teamB");
        Team teamC = Team.createTeam("teamC");

        teamRepository.save(teamA);
        teamRepository.save(teamB);
        teamRepository.save(teamC);

        Member member1 = Member.createMember("kokochi1", 20, teamA);
        Member member2 = Member.createMember("kokochi2", 27, teamA);
        Member member3 = Member.createMember("kokochi3", 27, teamB);
        Member member4 = Member.createMember("kokochi4", 27, teamB);
        Member member5 = Member.createMember("kokochi5", 27, teamC);
        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);
        memberRepository.save(member4);
        memberRepository.save(member5);

        List<MemberDto> memberDto = memberRepository.findMemberDto();
        for (MemberDto dto : memberDto) {
            System.out.println("TEST :: dto = " + dto);
        }
    }

    @Test
    public void findByNamesForParameterBinding() {

        Member member1 = Member.createMember("kokochi1", 20);
        Member member2 = Member.createMember("kokochi2", 27);
        Member member3 = Member.createMember("kokochi3", 31);
        Member member4 = Member.createMember("kokochi4", 55);
        Member member5 = Member.createMember("kokochi5", 80);
        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);
        memberRepository.save(member4);
        memberRepository.save(member5);

        List<Member> byNames = memberRepository.findByNames(Arrays.asList("kokochi1", "kokochi2"));
        for (Member byName : byNames) {
            System.out.println("TEST :: name = " + byName);
        }
    }

    @Test
    public void findAllByNameOne() {

        Member member1 = Member.createMember("kokochi", 20);
        Member member2 = Member.createMember("kokochi", 27);
        Member member3 = Member.createMember("kokochi", 31);
        Member member4 = Member.createMember("kokochi", 55);
        Member member5 = Member.createMember("kokochi", 80);
        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);
        memberRepository.save(member4);
        memberRepository.save(member5);

        Member kokochi = memberRepository.findAllByName("kokochi");
        System.out.println("TEST :: kokochi = " + kokochi);
        // 여러개가 나오는 쿼리문인데 단일 리턴타입을 지정하면 IncorrectResultSizeDataAccessException이 발생한다.
        // 반드시 유니크한 조건에만 단건조회로 설정해야 한다.
    }

    @Test
    public void paging() {
        memberRepository.save(Member.createMember("kokochi1", 20));
        memberRepository.save(Member.createMember("kokochi2", 20));
        memberRepository.save(Member.createMember("kokochi3", 20));
        memberRepository.save(Member.createMember("kokochi4", 20));
        memberRepository.save(Member.createMember("kokochi5", 20));

        int age = 20;
        PageRequest pageRequest = PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "name"));


        Page<Member> page = memberRepository.findByAge(age, pageRequest);

        List<Member> members = page.getContent();
        for (Member member : members) {
            System.out.println("TEST :: member = " + member);
        }
        assertThat(members.size()).isEqualTo(3);
        assertThat(page.getTotalElements()).isEqualTo(5);
        assertThat(page.getNumber()).isEqualTo(0);
        assertThat(page.getTotalPages()).isEqualTo(2);
        assertThat(page.isFirst()).isTrue();
        assertThat(page.hasNext()).isTrue();

        // Page를 쉽게 DTO로 만들기
//        Page<MemberDto> map = page.map(member -> new MemberDto(member.getId(), member.getName(), null));
    }
}