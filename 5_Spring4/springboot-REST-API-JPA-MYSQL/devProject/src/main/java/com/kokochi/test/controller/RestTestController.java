package com.kokochi.test.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kokochi.domain.Address;
import com.kokochi.domain.Board;
import com.kokochi.domain.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="/test")
public class RestTestController {
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
		log.info("/board/register - register(Board) POST :: board : " + board.toString());
		ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		return entity;
	}
	// /board/register - Board Register POST
	
	@GetMapping(value="/{boardNo}", produces="application/json")
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
	
//	@PutMapping(value="/{boardNo}", headers = "X-HTTP-Method-Override=PUT")
	@PutMapping(value="/{boardNo}", consumes = "application/json")
	public ResponseEntity<String> modify(@PathVariable("boardNo") int boardNo, @RequestBody Board board) {
		log.info("/board/modify - modify(boardNo, board) :: boardNo : " + boardNo +" / board : " + board.toString());
		ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		return entity;
	}
	// /board/modify - Board Modify
	
	@RequestMapping("/register")
	public void registerForm() {
		log.info("/board/register - registerForm GET");
	}
	// /registerForm
	
	@RequestMapping("/modify")
	public void modifyForm() {
		log.info("/board/modify - modifyForm GET");
	}
	// modifyForm
	
	@RequestMapping("/list")
	public void listForm() {
		log.info("/board/list - listForm GET");
	}
	// listForm
	
	@GetMapping("/member/register01")
	public void Memberregister01() {
		log.info("register01");
	}
	// /member/register01 - void GET test
	
	@GetMapping("/member/register02")
	public String Memberregister02() {
		log.info("register02");
		return "안녕하세요";
	}
	// /member/register02 - String GET test
	
	@GetMapping(value="/member/register03", produces="application/json")
	public Member Memberregister03() {
		log.info("register03");
		
		Member member = new Member();
		member.setAddress(new Address("kokochikochi","@gmail.com"));
		member.setCoin(10);
		member.setDateOfBirth(new Date());
		member.setPassword("1234");
		member.setUserId("kokochi");
		
		return member;
	}
	// /member/register03 - Java Beans GET test
	
	@GetMapping(value="/member/register04", produces="application/json")
	public List<Member> Memberregister04() {
		log.info("register04");
		
		List<Member> list = new ArrayList<Member>();
		Member member = new Member();
		list.add(member);
		
		return list;
	}
	// /member/register04 - List GET test
	
	@GetMapping(value="/member/register05", produces="application/json")
	public Map<String, Member> Memberregister05() {
		log.info("register05");
		
		Map<String, Member> map = new HashMap<>();
		Member member = new Member();
		map.put("key1", member);
		
		return map;
	}
	// /member/register05 - Map GET test
	
	@GetMapping(value="/member/register06", produces="application/json")
	public ResponseEntity<Void> Memberregister06() {
		log.info("register06");
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	// /member/register06 - ResponseEntity<Void> GET test
	
	@GetMapping(value="/member/register07", produces="application/json")
	public ResponseEntity<Member> Memberregister07() {
		log.info("register07");
		Member member = new Member();
		return new ResponseEntity<Member>(member, HttpStatus.OK);
	}
	// /member/register07 - ResponseEntity<Beans> GET test
	
	@GetMapping(value="/member/register08", produces="application/json")
	public ResponseEntity<List<Member>> Memberregister08() {
		log.info("register08");
		List<Member> list = new ArrayList<>();
		Member member = new Member();
		list.add(member);
		return new ResponseEntity<List<Member>>(list, HttpStatus.OK);
	}
	// /member/register08 - ResponseEntity<List> GET test
	
	@GetMapping(value="/member/register09", produces="application/json")
	public ResponseEntity<Map<String,Member>> Memberregister09() {
		log.info("register09");
		Map<String,Member> map = new HashMap<>();
		Member member = new Member();
		map.put("key1", member);
		return new ResponseEntity<Map<String,Member>>(map, HttpStatus.OK);
	}
	// /member/register09 - ResponseEntity<Map> GET test
	
	@GetMapping(value="/member/register10", produces="application/json")
	public ResponseEntity<byte[]> Memberregister10() throws Exception{
		log.info("register10");
		
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		try {
			HttpHeaders headers = new HttpHeaders();
			in = new FileInputStream("C:\\spring (2)\\a.png");
			headers.setContentType(MediaType.IMAGE_PNG);
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		
		return entity;
	}
	// /member/register10 - ResponseEntity<byte[]> GET test

	@PostMapping(value="/file/upload", produces="text/plain;charset=UTF-8")
	public ResponseEntity<String> FileUpload(MultipartFile file) throws Exception {
		log.info("/test/file/upload");
		String originalFilename = file.getOriginalFilename();
		ResponseEntity<String> entity = new ResponseEntity<String>("UPLOAD USCCESS :: " + originalFilename, HttpStatus.OK);
		return entity;
	}
	// /test/file/upload
}
