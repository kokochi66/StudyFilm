package org.kochi.service;

import java.util.List;

import org.kochi.domain.Board2;
import org.kochi.entity.Board;
import org.kochi.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardServiceImpl2 implements BoardService2 {
// Service를 구현하는 객체는 DAO와 직접적으로 통신하면서, 데이터베이스로부터 가져온 결과값을 컨트롤러로 반환해주는 역할을 한다.
// DAO는 Repository 어노테이션으로 이어져있으며, DAO와의 연결은 @Autowired 어노테이션을 통해서 자동으로 매핑되도록 한다.
	@Autowired
	private BoardRepository boardrepository;
	
	@Override
	@Transactional // 스프링의 트랜잭션 처리를 지원하는 선언적 트랜잭션, 해당 클래스에 트랜잭션 기능이 적용된 프록시 객체 생성으로 트랜잭션을 유지시켜준다.
	// 정상 여부에따라 Commit 또는 Rollback 해준다.
	public void register(Board2 board) throws Exception {
		// TODO Auto-generated method stub
		boardrepository.save(board);
	}

	@Override
	@Transactional(readOnly = true) // readOnly를 넣음으로써, 읽기만 가능한 트랜잭션이 적용된다.
	public Board2 read(Integer boardNo) throws Exception {
		// TODO Auto-generated method stub
		return boardrepository.findOne(boardNo);
	}

	@Override
	@Transactional
	public void modify(Board2 board) throws Exception {
		// TODO Auto-generated method stub
		Board2 boardEntity = boardrepository.findOne(board.getBoardNo());
		boardEntity.setTitle(board.getTitle());
		boardEntity.setContent(board.getContent());
	}

	@Override
	@Transactional
	public void remove(Integer boardNo) throws Exception {
		// TODO Auto-generated method stub
		boardrepository.delete(boardNo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Board2> list() throws Exception {
		// TODO Auto-generated method stub
		return boardrepository.findAll(new Sort(Direction.DESC, "boardNo"));
	}

}
