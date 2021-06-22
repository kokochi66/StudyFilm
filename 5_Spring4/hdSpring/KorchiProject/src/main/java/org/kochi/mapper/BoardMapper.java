package org.kochi.mapper;

import java.util.List;

import org.kochi.domain.Board;

public interface BoardMapper {
	public void create(Board board) throws Exception;	// 게시판 작성하기
	public Board read(Integer boardNo) throws Exception; // 게시판 읽기
	public void update(Board  board) throws Exception; // 게시판 수정하기
	public void delete(Integer boardNo) throws Exception; // 게시판 삭제하기
	public List<Board> list() throws Exception; // 게시판 리스트 가져오기
}
