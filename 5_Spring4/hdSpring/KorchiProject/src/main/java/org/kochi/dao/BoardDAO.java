package org.kochi.dao;

import java.util.List;

import org.kochi.entity.Board;

public interface BoardDAO {
	public void create(Board board) throws Exception;
	public Board read(Integer boardNo) throws Exception;
	public void update(Board board) throws Exception;
	public void delete(Integer boardNo) throws Exception;
	public List<Board> list() throws Exception;
}
