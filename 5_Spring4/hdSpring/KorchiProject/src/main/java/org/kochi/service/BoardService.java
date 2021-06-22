package org.kochi.service;

import java.util.List;

import org.kochi.domain.Board;

public interface BoardService {
	// 게시판 작성을 위한 서비스 객체를 구현한다.
	public void register(Board board) throws Exception;	// 게시판 작성하기
	public Board read(Integer boardNo) throws Exception; // 게시판 읽기
	public void modify(Board  board) throws Exception; // 게시판 수정하기
	public void remove(Integer boardNo) throws Exception; // 게시판 삭제하기
	public List<Board> list() throws Exception; // 게시판 리스트 가져오기
}
