package Study.datajpa.repository;

import Study.datajpa.entity.Member;
import Study.datajpa.entity.MemberDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;
import java.util.Collection;
import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {

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

    @Modifying(clearAutomatically = true)  // update 쿼리의 경우에는 이 어노테이션을 붙여줘야한다.
    // 벌크연산 후, 영속성 컨텍스트를 초기화 해주어야, 반영이 된다.
    @Query("update Member m set m.age = m.age + 1 where m.age >= :age")
    int bulkAgePlus(@Param("age") int age);

    @Query("select m from Member m left join fetch m.team")
    List<Member> findMemberFetchJoin();

    @Override
    @EntityGraph(attributePaths = {"team"})  // fetch join 대신에 여러 객체를 같이 조인하여 가져오도록 함
    List<Member> findAll();

    @EntityGraph(attributePaths = {"team"})
    @Query("select m from Member m")    // JPQL에 추가하는것도 가능함
    List<Member> findMemberEntityGraphJPQL();

    @EntityGraph(attributePaths = {"team"}) // Spring Data JPA 형식에도 적용이 가능함
    List<Member> findAllsByName(String name);

    @QueryHints(value = @QueryHint(name = "org.hibernate.readOnly", value = "true"))
    Member findReadOnlyByName(String name);

    // select for update - lock
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<Member> findLockByName(String name);
}
