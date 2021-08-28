package sample.kokochi.hellospring.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import sample.kokochi.hellospring.domain.Member;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryImplTest {
    MemoryMemberRepositoryImpl repository = new MemoryMemberRepositoryImpl();
    @AfterEach  // 각 메소드가 끝날 때 마다 호출되는 메소드
    public void afterEach() {
        repository.clearStore();
        // 각 메소드가 끝날 때 마다 repository 값을 초기화해주어야 테스트시 버그발생을 막을 수 있다.
    }
    @Test
    public void save() {
        Member member = new Member();
        member.setName("kokochi");
        repository.save(member);
        Member result = repository.findById(member.getId()).get();
//        Assertions.assertEquals(member, null);
        // 테스트를 위한 객체, 기대값과 결과값을 넣어서 원하는 값이 나오는지를 파악할 수 있다.
        // 실패가 나오는 경우에는 에러가 발생하게된다.

        assertThat(member).isEqualTo(result);
        // alt + enter 를 통해서 static import를 적용하면 객체 없이 바로 적용할 수 있다.
        // That에 목표값, result에 결과값을 넣어서 테스트를 확인할 수 있다.
    }
    // save 테스트 코드
    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("sp1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("sp2");
        repository.save(member2);

        Member res1 = repository.findByName("sp1").get();
        Member res2 = repository.findByName("sp2").get();
        assertThat(member1).isEqualTo(res1);
        assertThat(member2).isEqualTo(res2);
    }
    // findByName 테소트코드
    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("sp1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("sp2");
        repository.save(member2);

        Member member3 = new Member();
        member3.setName("sp3");
        repository.save(member3);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(3);
    }
    // findAll 테스트 코드
}
