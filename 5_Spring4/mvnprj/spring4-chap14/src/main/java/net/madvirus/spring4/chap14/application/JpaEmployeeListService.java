package net.madvirus.spring4.chap14.application;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import net.madvirus.spring4.chap14.domain.Employee;

public class JpaEmployeeListService implements EmployeeListService {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Transactional
	@Override
	public List<Employee> getEmployee(String keyword, Long teamId) {
		// 상황에 따라서 다양한 조건을 조합해서 검색 조건을 생성해야 한다면, 사용해야 할 쿼리도 많아지고,
		// 결과적으로 리파지터리의 쿼리 메서드를 증가시킨느 상황을 만들게된다. 이런 문제를 해결시켜주는것이 Criteria API이다.
		
		CriteriaBuilder cb = entityManagerFactory.getCriteriaBuilder();

		CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
		Root<Employee> employee = query.from(Employee.class);
		query.select(employee);

		if (hasValue(keyword) || hasValue(teamId)) {
			if (hasValue(keyword) && !hasValue(teamId)) {
				query.where(cb.or(
						cb.equal(employee.get("name"), keyword),
						cb.equal(employee.get("employeeNumber"), keyword)));
			} else if (!hasValue(keyword) && hasValue(teamId)) {
				query.where(cb.equal(employee.get("team").get("id"), teamId));
			} else {

				query.where(cb.and(
						cb.or(
								cb.equal(employee.get("name"), keyword),
								cb.equal(employee.get("employeeNumber"), keyword)),
						cb.equal(employee.get("team").get("id"), teamId)
						));
			}
		} else {
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, -30);
			query.where(cb.greaterThan(employee.<Date> get("joinedDate"), cal.getTime()));
		}

		TypedQuery<Employee> typedQuery = entityManagerFactory.createEntityManager().createQuery(query);
		List<Employee> result = typedQuery.getResultList();
		return result;
	}
	// Specification 타입을 사용하면 Criteria API와 같이 검색 조건 조합을 만들 수 있으면서도,
	// 검색조건을 생성하는 코드에서 EntityManagerFactory, CriteriaBuilder 등 JPA 관련 코드를 직접 사용하지 않아도 되는 장점이 있다.

	private boolean hasValue(Object value) {
		return value != null;
	}

	private boolean hasValue(String value) {
		return value != null && !value.trim().isEmpty();
	}
}
