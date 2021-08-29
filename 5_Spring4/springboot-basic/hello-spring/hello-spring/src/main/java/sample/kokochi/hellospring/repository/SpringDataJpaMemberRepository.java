package sample.kokochi.hellospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.kokochi.hellospring.domain.Member;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    @Override
    Optional<Member> findByName(String name);
    // JPA가 자동으로 SQL을 작성해주는 기본적인 규칙이 존재한다.
    // 복잡한 쿼리는 조금 어렵지만, 간단한 쿼리는 메소드 이름만 변경해주어서 새로운 쿼리를 짤 수 있게 도움을 준다.
    // 나머지 기본적인 쿼리들은 또 지원해준다. (CRUD 등)
}
