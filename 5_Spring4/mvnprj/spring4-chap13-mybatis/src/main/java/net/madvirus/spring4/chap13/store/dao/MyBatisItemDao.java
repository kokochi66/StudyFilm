package net.madvirus.spring4.chap13.store.dao;

import net.madvirus.spring4.chap13.store.model.Item;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MyBatisItemDao implements ItemDao {
// DAO 클래스는 생성자나 프로퍼티를 통해서 SqlSessioNTemplate를 전달받아서 DB기능을 구현한다.
	private SqlSession sqlSession;
	// SQLSesstionTemplate는 SqlSession 인터페이스를 상속받고 있기 때문에, SqlSession 타입을 이용해도 된다.

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public Item findById(Integer itemId) {
		Item item = (Item) sqlSession.selectOne(
				"net.madvirus.spring4.chap13.store.dao.ItemDao.findById",
				itemId);
		return item;
	}

}
