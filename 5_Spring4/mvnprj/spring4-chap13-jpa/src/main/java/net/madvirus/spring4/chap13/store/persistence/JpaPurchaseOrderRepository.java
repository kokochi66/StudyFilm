package net.madvirus.spring4.chap13.store.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.madvirus.spring4.chap13.store.domain.PurchaseOrder;
import net.madvirus.spring4.chap13.store.domain.PurchaseOrderRepository;

public class JpaPurchaseOrderRepository implements PurchaseOrderRepository {

	@PersistenceContext
	private EntityManager entityManager;
	// 현재 진행중인 트랜잭션 범위에서 EntittyManager가 동작하게 하려면 EntityManager.joinTransaction()메소드를 사용해야한다.
	// 혹은 위와같이 @PersistenceContext 어노테이션을 사용하면 트랜잭션에 이미 연동된 EntityManager를 사용할 수 있다.
	// 어노테이션 등록을 위해서는 마찬가지로 PersistenceAnnotationBeanPostProcessor 클래스나, annotation-config 태그를 설정해주어야한다.

	@Override
	public void save(PurchaseOrder order) {
		entityManager.persist(order);
		// persist 메소드를 실행하면, 스프링이 제공한 프롯기 객체의 persist() 메소드가 호출되며,
		// 프록시의 persistt() 메소드는 현재 진행중인 트랜잭션과 연동된 EntityManager의 persist()메소드를 호출시켜준다.
	}

}
