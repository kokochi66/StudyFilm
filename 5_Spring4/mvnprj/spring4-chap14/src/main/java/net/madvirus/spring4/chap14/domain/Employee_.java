package net.madvirus.spring4.chap14.domain;

import java.util.Date;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Employee.class)
public class Employee_ {
// 프로퍼티 이름을 문자열로 사용할 떄, 오타와 같은 실수를 방지하기 위한 JPA의 메타 모델 클래스이다.
// 메타 모델 크래스의 이름은 모델 클래스 이름 뒤에 언더바를 붙인것을 사용한다.
// 메타 모델 클래스는 정적 필드를 이용해서 실제 모델 클래스에 대한 프로퍼티 정보를 기술한다.
// 메타 모델 클래스를 이용하면 오타를 사전에 할 수 있고, 코드 자동완성 기능을 이용해서 빠르게 코드를 완성할 수 있게 된다.
	
	public static volatile SingularAttribute<Employee, Long> id;
	public static volatile SingularAttribute<Employee, String> employeeNumber;
	public static volatile SingularAttribute<Employee, String> name;
	public static volatile SingularAttribute<Employee, Address> address;
	public static volatile SingularAttribute<Employee, Integer> birthYear;
	public static volatile SingularAttribute<Employee, Team> team;
	public static volatile SingularAttribute<Employee, Date> joinedDate;
}
