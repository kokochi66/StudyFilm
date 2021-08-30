package sample2.kokochi.hello.member.service;

import sample2.kokochi.hello.member.Member;
import sample2.kokochi.hello.member.repository.MemberRepository;
import sample2.kokochi.hello.member.repository.MemoryMemberRepositoryImpl;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepositoryImpl();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
