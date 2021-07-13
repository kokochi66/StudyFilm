package org.kokochi.prj.service;

import java.util.List;

import org.kokochi.prj.domain.Board;
import org.kokochi.prj.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper;
	
	@Override
	public void register(Board board) throws Exception {
		// TODO Auto-generated method stub
		mapper.create(board);
	}

	@Override
	public Board read(Integer boardNo) throws Exception {
		// TODO Auto-generated method stub
		return mapper.read(boardNo);
	}

	@Override
	public void modify(Board board) throws Exception {
		// TODO Auto-generated method stub
		mapper.update(board);
	}

	@Override
	public void remove(Integer boardNo) throws Exception {
		// TODO Auto-generated method stub
		mapper.delete(boardNo);
	}

	@Override
	public List<Board> list() throws Exception {
		// TODO Auto-generated method stub
		return mapper.list();
	}

}
