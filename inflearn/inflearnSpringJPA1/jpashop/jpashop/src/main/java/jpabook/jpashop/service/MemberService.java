package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.SpringDataMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

//    final private MemberRepository memberRepository;
    final private SpringDataMemberRepository memberRepository;

    // 회원 가입
    @Transactional
    public Long join(Member member) {
        valdiateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void valdiateDuplicateMember(Member member) {
        if (memberRepository.findAllByName(member.getName()).stream().findAny().isPresent()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        };
    }

    // 회원 전체 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId) {
        return memberRepository.findById(memberId).orElse(null);
    }

    @Transactional
    public void update(Long id, String name) {
        Member member = memberRepository.findById(id).orElse(null);
        member.setName(name);
    }
}
