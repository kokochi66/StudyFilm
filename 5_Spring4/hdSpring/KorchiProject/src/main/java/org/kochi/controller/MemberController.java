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

@Controller
@RequestMapping("/member")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	// LoggerFactory를 이용해서 로그를 담는다.
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String register() {
		logger.info("register");
		return "registerForm";
	}
	
	// URL 경로 상의 쿼리 파라미터 정보로부터 요청 데이터를 취득할 수 있다.
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String registerByParameter(String userId, String password, int coin) {
		logger.info("registerByParameter");
		logger.info("userId = " + userId);
		logger.info("password = " + password);
		logger.info("coin = "+coin);
		return "success";
	}
	// URL 경로 상의 변수를 파라미터로 가져올 수 있다.
	// 폼 필드로 송신하는 경우, 매개변수 명이 일치하면 요청 데이터를 취득할 수 있다.
	// 타입이 다를경우, 타입 변환하여 요청 데이터를 취득한다. 타입변환이 불가능하면 익셉션을 일으킨다.
	@RequestMapping(value="/register/{userId}", method=RequestMethod.GET)
	public String registerByPath(String userId) {
		logger.info("registerByParameter");
		logger.info("userId = " + userId);
		return "success";
	}
	
}
