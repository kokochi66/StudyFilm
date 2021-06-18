package net.madvirus.spring4.chap13.store.dao;

import net.madvirus.spring4.chap13.store.model.Item;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class MyBatisItemDao2 extends SqlSessionDaoSupport implements ItemDao {
// SqlSessionDaoSupport 클래스를 상속받아서 DAO를 구현할 수도있다.
	// SqlSessioNDaoSupport 클래슨느 스프링과 연동된 SqlSession을 제공하는 getSqlSession(). 메소드를 포함한다.
	// 하위 클래스는 이 메소드를 이용해서, SqlSession 객체로 접근할 수 있다. 이 접근을 이용해서 구현이가능하다.
	@Override
	public Item findById(Integer itemId) {
		Item item = (Item) getSqlSession().selectOne(
				"net.madvirus.spring4.chap13.store.dao.ItemDao.findById",
				itemId);
		return item;
	}
	// SqlSessionDaoSupport 클래스가 정상동작하려면, SqlSessioNFactory나 SqlSessioNTemplate설정을 추가해주어야한다. store.xml 참조
}
