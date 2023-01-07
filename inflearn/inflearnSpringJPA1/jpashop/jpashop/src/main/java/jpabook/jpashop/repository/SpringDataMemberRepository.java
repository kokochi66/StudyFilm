package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpringDataMemberRepository extends org.springframework.data.repository.Repository<Member, Long> {
    List<Member> findAllByName(String name);
}
