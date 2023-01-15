package Study.datajpa.repository;

import Study.datajpa.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByNameAndAgeGreaterThan(String name, int age);

    List<Member> findTop3By();

//    @Query(name = "Member.findByName") NamedQuery는 이게 없어도 알아서 우선순위가 먼저 찾아서 안해줘도 된다.
    List<Member> findByUserName(@Param("name") String name);
}
