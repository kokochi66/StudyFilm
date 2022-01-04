package com.spring1.inflearn.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    // 테스트가 시작하기 전에, 메모리를 비워주게 한다.
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("kokochi1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("kokochi2");
        repository.save(member2);

        Member result = repository.findByName("kokochi1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("kokochi1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("kokochi2");
        repository.save(member2);

        List<Member> res = repository.findAll();
        assertThat(res.size()).isEqualTo(2);
    }


    @Test
    public void duplicateName() {
        Member member1 = new Member();
        member1.setName("kokochi1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("kokochi1");
        repository.save(member2);

        Member res = repository.findByName("kokochi1").get();
        assertThat(res).isEqualTo(member1);
    }
}
