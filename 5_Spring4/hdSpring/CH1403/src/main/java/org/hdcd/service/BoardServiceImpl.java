package org.hdcd.service;

import java.util.List;

import org.hdcd.domain.Board;
import org.hdcd.mapper.BoardMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);

	@Autowired
	private BoardMapper mapper;
	
	@Override
	public void register(Board board) throws Exception {
		logger.info("register");
		
		mapper.create(board);
	}

	@Override
	public Board read(Integer boardNo) throws Exception {
		logger.info("read");
		
		return mapper.read(boardNo);
	}

	@Override
	public void modify(Board board) throws Exception {		
		logger.info("modify");
		
		mapper.update(board);
	}

	@Override
	public void remove(Integer boardNo) throws Exception {
		logger.info("remove");
		
		mapper.delete(boardNo);
	}

	@Override
	public List<Board> list() throws Exception {
		logger.info("list");
		
		return mapper.list();
	}

}
