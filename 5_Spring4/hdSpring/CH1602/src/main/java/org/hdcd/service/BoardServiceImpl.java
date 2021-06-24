package org.hdcd.service;

import java.util.List;

import org.hdcd.domain.Board;
import org.hdcd.exception.BoardRecordNotFoundException;
import org.hdcd.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper;

	@Override
	public void register(Board board) throws Exception {
		mapper.create(board);
	}

	@Override
	public Board read(Integer boardNo) throws Exception {
		Board board = mapper.read(boardNo);
		
		if (board == null) {
			throw new BoardRecordNotFoundException("Not Found boardNo = " + boardNo);
		}
		
		return board;
	}

	@Override
	public void modify(Board board) throws Exception {
		mapper.update(board);
	}

	@Override
	public void remove(Integer boardNo) throws Exception {
		mapper.delete(boardNo);
	}

	@Override
	public List<Board> list() throws Exception {
		return mapper.list();
	}

}
