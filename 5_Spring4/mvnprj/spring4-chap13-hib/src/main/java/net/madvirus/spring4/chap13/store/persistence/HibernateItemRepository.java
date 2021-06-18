package net.madvirus.spring4.chap13.store.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import net.madvirus.spring4.chap13.store.domain.Item;
import net.madvirus.spring4.chap13.store.domain.ItemRepository;

@Repository
//@Repository를 사용하면 하이버네이트와 JPA API가 발생시키는 익셈션을 스프링의 DataAccessException 으로 변환할 수 있다.
public class HibernateItemRepository implements ItemRepository {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Item findById(Integer itemId) {
		Item item = (Item) sessionFactory.getCurrentSession().get(Item.class, itemId);
		return item;
		// LocalSessiuonFactoryBean 클래스가 하이버네이트의 컨텍스트 세션을 지원하기 때문에,
		// SessionFactory.getCurrentSession() 메소드를 이용해서 SessionFactory를 구할 수 있다.
	}

}
