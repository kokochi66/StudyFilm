package org.kochi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 클래스 레벨에 경로를 지정하여서, 하위 메서드 레벨의 요청경로를 덧붙인 형태로 경로를 지정할 수 있다.
@Controller
@RequestMapping("/board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	// LoggerFactory를 이용해서 로그를 담는다.
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	// 경로 패턴 지정시에 value값과 method를 설정할 수 있다.
	// method에서 HTTP 메서드를 매핑 조건으로 지정할 수 있는데, GET, POST 두가지 방식을 사용할 수 있다.
	// 요청 파라미터를 매핑 조건으로 지정하는 경우 params 속성을 사용한다.
	public String registerForm() {
		logger.info("registerForm");
		return "success";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST, params = "register")
	public String register() {
		logger.info("register");
		return "success";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET, params = "modify")
	public String modifyForm() {
		logger.info("modifyForm");
		return "success";
	}
	@RequestMapping(value="/{boardNo}", method=RequestMethod.POST)
	public ResponseEntity<String> modify(@PathVariable("boardNo") int boardNo, @RequestBody Board board) {
		logger.info("modify");
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}
	// 요청 헤더를 매핑 조건으로 하는 경우에는 headers 속성을 지정한다.
	// 요청 본문의 미디어 타입을 지정하지 않으면 기본값인 application/json으로 지정된다.
	@RequestMapping(value="/{boardNo}", method=RequestMethod.PUT, headers = "X-HTTP-Method-Override=PUT")
	public ResponseEntity<String> modifyByHeader(@PathVariable("boardNo") int boardNo, @RequestBody Board board) {
		logger.info("modifyByHeader");
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}
	
	@RequestMapping(value="/{boardNo}", method=RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<String> modifyByJson(@PathVariable("boardNo") int boardNo, @RequestBody Board board) {
		logger.info("modifyByJson");
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}
	
	@RequestMapping(value="/{boardNo}", method=RequestMethod.PUT, consumes = "application/xml")
	public ResponseEntity<String> modifyByXml(@PathVariable("boardNo") int boardNo, @RequestBody Board board) {
		logger.info("modifyByXml board : "+board);
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}
	
	
	
	@RequestMapping(value="/read", method=RequestMethod.GET, params = "remove")
	public String removeForm() {
		logger.info("removeForm");
		return "success";
	}
	@RequestMapping(value="/read", method=RequestMethod.POST, params = "remove")
	public String remove() {
		logger.info("remove");
		return "success";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET, params = "list")
	public String list() {
		logger.info("list");
		return "success";
	}
	
	@RequestMapping(value="/read", method=RequestMethod.GET, params = "read")
	public String read() {
		logger.info("read");
		return "success";
	}
	
	// 경로 패턴을 지정한다.
	@RequestMapping("/read/{boardNo}")
	public String read(@PathVariable("boardNo") int boardNo) {
	// 경로 변수에 해당하는 값을 @PathVariable 어노테이션을 이용해서 파라미터 변수에 설정할 수 있다.
		logger.info("read boardNo: "+boardNo);
		return "board/read";
		// 경로가 변하기 때문에 뷰 이름을 지정한다.
	}
	
}
