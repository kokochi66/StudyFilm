package sample2.kokochi.hello.member.repository;

import sample2.kokochi.hello.member.Member;

public interface MemberRepository {
    void save(Member member);
    Member findById(Long memberId);
}
