package net.madvirus.spring4.chap14.domain;

import java.util.List;

import net.madvirus.spring4.chap14.common.NameFindableRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends Repository<Employee, Long>, NameFindableRepository<Employee>, EmployeeCustomRepository {
// 스프링 데이터 JPA 모듈은 Repository 린터페이스를 상속받은 인터페이스를 검색하여 리파지터리 구현 객체를 생성한다.
// 리파지터리의 첫번째 파라미터는 리파지터리가 다룰 엔티티 타입, 두번째 리파지터리는 엔티티의 식별값을 지정한다.
// 여기서 엔티티 타입은 JPA의 @Entity 어노테이션이 적용된 클래스에 해당되며, 식별값은 @Id 어노테이션이 적용된 프로퍼티 타입이다.
	
	public Employee save(Employee emp);

	public Employee findOne(Long id);

	public Iterable<Employee> findByBirthYear(int year);

	public Iterable<Employee> findByNameLike(String name);

	public Iterable<Employee> findByNameStartingWith(String name);

	public Iterable<Employee> findByNameEndingWith(String name);

	public Iterable<Employee> findByNameContaining(String string);

	public List<Employee> findByNameStartingWithOrderByNameAsc(String name);

	public List<Employee> findByTeamIdOrderByIdDesc(Long teamId);

	public List<Employee> findByBirthYearOrderByTeamNameAscNameAsc(int year);

	public long count();

	public long countByTeamId(Long teamId);

	public List<Employee> findAll(Sort sort);

	public List<Employee> findByTeam(Team team, Sort sort);

	public List<Employee> findByBirthYearLessThan(int birthYear, Pageable pageable);

	public List<Employee> findByTeamId(Long teamId, Pageable pageable);

	public Page<Employee> findByTeam(Team team, Pageable pageable);

	@Query("from Employee e where e.employeeNumber = ?1 or e.name like %?2%")
	public Employee findByEmployeeNumberOrNameLike(String empNum, String name);

	public Employee findByBirthYearGreaterThan(int birthYear);

	public Iterable<Employee> findByTeamIdOrderByNameDesc(Long teamId, Sort sort);

	public void delete(Long id);

	@Query("from Employee e where e.birthYear < :year order by e.birthYear")
	public List<Employee> findEmployeeBornBefore(@Param("year") int year);

	@Query("from Employee e where e.birthYear < :year")
	public List<Employee> findEmployeeBornBefore(@Param("year") int year, Sort sort);

	@Query("from Employee e where e.birthYear < :year order by e.birthYear")
	public Page<Employee> findEmployeeBornBefore(@Param("year") int year, Pageable pageable);

	public List<Employee> findAll(Specification<Employee> spec);
	// 리파지터리 인터페이스에 Specification 타입의 파라미터를 추가해줌으로써, Specification를 이용할 수 있다.
	// Sort나 Pageable 파라미터를 추가할 수 있으며, Pageable 파라미터를 가질 경우 리턴 타입으로 Page를 사용할 수 있다.
	
	
	public Option<Employee> getOption(Long id);
}
