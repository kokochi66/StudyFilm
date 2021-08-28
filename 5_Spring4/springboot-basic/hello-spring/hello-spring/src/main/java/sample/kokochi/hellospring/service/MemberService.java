package sample.kokochi.hellospring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.kokochi.hellospring.domain.Member;
import sample.kokochi.hellospring.repository.MemberRepository;
import sample.kokochi.hellospring.repository.MemoryMemberRepositoryImpl;

import java.util.List;
import java.util.Optional;

//@Service
public class MemberService {

    @Autowired
    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    private final MemberRepository repository;

    public Long join(Member member) {
        validateDuplicatedName(member);
        repository.save(member);
        return member.getId();
    }   // 회원가입

    public List<Member> findMember() {
        return repository.findAll();
    }   // 회원 리스트 가져오기

    public Optional<Member> findOne(Long memberId) {
        return repository.findById(memberId);
    } // 특정 회원 가져오기(Id)

    private void validateDuplicatedName(Member member) {
        repository.findByName(member.getName()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }   // 이미 존재하는 이름이라면 익셉션을 반환
}
