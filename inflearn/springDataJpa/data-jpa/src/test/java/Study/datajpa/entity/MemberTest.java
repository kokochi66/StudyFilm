package Study.datajpa.entity;

import Study.datajpa.repository.MemberRepository;
import org.aspectj.weaver.NewMemberClassTypeMunger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
@Rollback(false)
public class MemberTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private EntityManager em;

    @Test
    public void JpaEventBaseEntity() throws InterruptedException {
        Member member = Member.createMember("kokochi", 123);
        memberRepository.save(member);

        Thread.sleep(100);
        member.setName("jaewon");

        em.flush();
        em.clear();

        Member findMember = memberRepository.findById(member.getId()).orElseThrow();
        System.out.println("TEST :: member = " + findMember);
        System.out.println("TEST :: createdDate = " + findMember.getCreatedDate());
        System.out.println("TEST :: updatedDate = " + findMember.getLastModifiedDate());
        System.out.println("TEST :: createdBy = " + findMember.getCreatedBy());
        System.out.println("TEST :: updatedBy = " + findMember.getLastModifiedBy());
    }
}
