package sample2.kokochi.hello.member.service;

import sample2.kokochi.hello.member.Member;

public interface MemberService {
    void join(Member member);   // 회원가입
    Member findMember(Long memberId); // 회원 찾기
}
