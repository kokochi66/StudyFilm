package sample2.kokochi.hello.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample2.kokochi.hello.member.Member;
import sample2.kokochi.hello.member.repository.MemberRepository;

@Component
public class MemberServiceImpl implements MemberService {

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
