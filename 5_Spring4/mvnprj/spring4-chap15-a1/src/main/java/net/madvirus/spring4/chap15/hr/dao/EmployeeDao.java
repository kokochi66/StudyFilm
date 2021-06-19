package net.madvirus.spring4.chap15.hr.dao;

import java.util.List;

import net.madvirus.spring4.chap15.hr.model.Employee;

public interface EmployeeDao {
	public Long insert(Employee emp);

	public Employee selectOne(Long id);

	public List<Employee> selectList(SearchCondition cond);
	// select는 필요한 기능에 따라 다양한 메소드가 존재할 수 있으며, 검색 조건과 사용하는 기술에 따라 달라진다.
	// 그래서 SearchCondition과 같은 이름의 클래스를 이용하여, 검색조건을 표현하고, 이를 파라미터로 사용할 수 있다.

	public Employee selectByEmployeeNumber(String number);
}
