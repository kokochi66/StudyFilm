package org.kochi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kochi.entity.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl2 implements BoardDAO {
// MyBatis 구현을 위한 BoardDAO 두번째 구현 => SqlSession 객체를 이용해서 쿼리를 진행한다.
// 객체에 대한 자세한 설정은 BoardMapper.xml 에 기록되어있다. 링크를 namespace에 담아놓는다.
	@Autowired
	private SqlSession session;
	private static String namespace = "org.kochi.mapper.BoardMapper";
	
	@Override
	public void create(Board board) throws Exception {
		session.insert(namespace + ".create", board);
	}
	@Override
	public Board read(Integer boardNo) throws Exception {
		return session.selectOne(namespace + ".read", boardNo);
	}
	@Override
	public void update(Board board) throws Exception {
		session.update(namespace + ".update", board);
	}
	@Override
	public void delete(Integer boardNo) throws Exception {
		session.delete(namespace + ".delete", boardNo);
	}
	@Override
	public List<Board> list() throws Exception {
		return session.selectList(namespace + ".list");
	}
}
