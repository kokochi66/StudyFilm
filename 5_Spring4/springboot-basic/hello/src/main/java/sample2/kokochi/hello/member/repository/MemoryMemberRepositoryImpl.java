package sample2.kokochi.hello.member.repository;

import org.springframework.stereotype.Component;
import sample2.kokochi.hello.member.Member;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepositoryImpl implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();


    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}