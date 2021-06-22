package org.hdcd.mapper;

import java.util.List;

import org.hdcd.domain.Board;

public interface BoardMapper {

	public void create(Board board) throws Exception;

	public Board read(Integer boardNo) throws Exception;

	public void update(Board board) throws Exception;

	public void delete(Integer boardNo) throws Exception;

	public List<Board> list() throws Exception;

}
