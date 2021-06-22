package org.kochi.service;

import java.util.List;

import org.kochi.dao.BoardDAO;
import org.kochi.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*@Service*/
public class BoardServiceImpl implements BoardService {
// Service를 구현하는 객체는 DAO와 직접적으로 통신하면서, 데이터베이스로부터 가져온 결과값을 컨트롤러로 반환해주는 역할을 한다.
// DAO는 Repository 어노테이션으로 이어져있으며, DAO와의 연결은 @Autowired 어노테이션을 통해서 자동으로 매핑되도록 한다.
	@Autowired
	private BoardDAO dao;
	
	@Override
	public void register(Board board) throws Exception {
		// TODO Auto-generated method stub
		dao.create(board);
	}

	@Override
	public Board read(Integer boardNo) throws Exception {
		// TODO Auto-generated method stub
		return dao.read(boardNo);
	}

	@Override
	public void modify(Board board) throws Exception {
		// TODO Auto-generated method stub
		dao.update(board);
	}

	@Override
	public void remove(Integer boardNo) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(boardNo);
	}

	@Override
	public List<Board> list() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("DAO Template 구현");
		return dao.list();
	}

}
