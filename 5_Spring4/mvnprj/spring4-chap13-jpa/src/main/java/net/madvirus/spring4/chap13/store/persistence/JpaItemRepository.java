package net.madvirus.spring4.chap13.store.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import net.madvirus.spring4.chap13.store.domain.Item;
import net.madvirus.spring4.chap13.store.domain.ItemRepository;

public class JpaItemRepository implements ItemRepository {
// JPA를 이용해서 DB 연동 코드를 작성하려면, EntityManagerFactory에서 EntityManager를 구해야한다.
	private EntityManagerFactory entityManagerFactory;

	public void setEntityManagerFactory(EntityManagerFactory emf) {
		this.entityManagerFactory = emf;
	}	// 설정 메소드를 통해서 EntityManagerFactory를 전달받도록 구현함
	// 스프링 설정 프로퍼티에서 EntityManagerFactory 빈을 itemRepositroy에 전달해주면 설정이 완료된다.

	@Override
	public Item findById(Integer itemId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.joinTransaction();
		return entityManager.find(Item.class, itemId);
	}

}
