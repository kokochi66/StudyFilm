package sample.kokochi.hellospring.repository;

import org.springframework.stereotype.Repository;
import sample.kokochi.hellospring.domain.Member;

import java.util.*;

//@Repository
public class MemoryMemberRepositoryImpl implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<Long, Member>();
    private static long sequence = 0L;  // 0,1,2 등의 키값을 생성해주는 역할
    // 실무에서는 동시성 문제를 고려해야함

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
        // 널값이 반환되게 되는 경우에, Optional.ofNullable로 감싸서 반환해주면, 클라이언트에서 작업이 가능하다.
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
    // 충돌방지를 위한 스토어를 비우는 메소드
}
