package net.madvirus.spring4.chap13.store.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import net.madvirus.spring4.chap13.store.domain.PaymentInfo;
import net.madvirus.spring4.chap13.store.domain.PaymentInfoRepository;

public class JpaPaymentInfoRepository implements PaymentInfoRepository {
// EntityManagerFactory를 전달받는 또 하나의 방법으로, @PersistenceUnit 어노테이션을 활용하는 방법이다.
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	// @persistenceUnit 어노테이션이 적용된 대상에 등록된 EntityManagerFactory빈을 할당한다.
	// 어노테이션 적용으,ㄹ 위해서 PersistenceAnnotationBeanPostProcessor 클래스를 빈으로 등록해주어야한다.
	// 혹은 <context:annotation-config>를 사용해도 된다.

	@Override
	public void save(PaymentInfo paymentInfo) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.joinTransaction();
		entityManager.persist(paymentInfo);
	}

}
