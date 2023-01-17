package Study.datajpa.repository;

import Study.datajpa.entity.Member;
import Study.datajpa.entity.MemberDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByNameAndAgeGreaterThan(String name, int age);

    List<Member> findTop3By();

//    @Query(name = "Member.findByName") NamedQuery는 이게 없어도 알아서 우선순위가 먼저 찾아서 안해줘도 된다.
    List<Member> findByUserName(@Param("name") String name);

    @Query("select m from Member m where m.name = :name and m.age = :age")
    List<Member> findUser(@Param("name") String name, @Param("age") int age);

    @Query("select m.name from Member m")
    List<String> findUsernameList();

    @Query("select new Study.datajpa.entity.MemberDto(m.id, m.name, t.name) from Member m join m.team t")
    List<MemberDto> findMemberDto();

    @Query("select m from Member m where m.name in :names")
    List<Member> findByNames(@Param("names") Collection<String> names);

    Member findAllByName(String name);

    Page<Member> findByAge(int age, Pageable pageable);

//    @Query(value = "select m from Member m left join m.team t", countQuery = "select count(m.name) from Member m")     // 카운트 쿼리를 분리하여 조인되지 않도록 한다.
//    Page<Member> findByAge(int age, Pageable pageable);

}
