package com.kokochi.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kokochi.domain.Board;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="/board")
public class BoardController {
	
	@GetMapping("")
	public ResponseEntity<List<Board>>  list() {
		log.info("/board - list()");
		List<Board> boardList = new ArrayList<>();
		Board board = new Board();
		board.setBoardNo(1);
		board.setTitle("향수");
		board.setContent("넓은 벌 동쪽 끝으로");
		board.setWriter("kokochi");
		board.setRegDate(LocalDateTime.now());
		boardList.add(board);
		
		board = new Board();
		board.setBoardNo(2);
		board.setTitle("나나양");
		board.setContent("좀비게임 동아리");
		board.setWriter("nanayang");
		board.setRegDate(LocalDateTime.now());
		boardList.add(board);
		
		ResponseEntity<List<Board>> entity = new ResponseEntity<>(boardList, HttpStatus.OK);
		return entity;
	}
	// 리스트 테스트용 메소드
	
	@PostMapping
	public ResponseEntity<String> register(@RequestBody Board board) {
		log.info("/board/register - register(Board) :: board : " + board.toString());
		ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		return entity;
	}
	// /board/register - Board Register
	
	@GetMapping("/{boardNo}")
	public ResponseEntity<Board> read(@PathVariable("boardNo") int boardNo) {
		log.info("/board/read - read(boardNo) :: boardNo : "+boardNo);
		Board board = new Board();
		board = new Board();
		board.setBoardNo(1);
		board.setTitle("나나양");
		board.setContent("좀비게임 동아리");
		board.setWriter("nanayang");
		board.setRegDate(LocalDateTime.now());
		
		ResponseEntity<Board> entity = new ResponseEntity<>(board, HttpStatus.OK);
		return entity;
	}
	// /board/read - Board Read
	
	@DeleteMapping("/{boardNo}")
	public ResponseEntity<String> remove(@PathVariable("boardNo") int boardNo) {
		log.info("/board/register - remove(boardNo) :: boardNo : " + boardNo);
		ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		return entity;
	}
	// /board/remove - Board Remove
	
	@PutMapping("/{boardNo}")
	public ResponseEntity<String> modify(@PathVariable("boardNo") int boardNo,
			@RequestBody Board board) {
		log.info("/board/modifyr - modify(boardNo, board) :: boardNo : " + boardNo +" / board : " + board.toString());
		ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		return entity;
	}
	// /board/modify - Board Modify
}
