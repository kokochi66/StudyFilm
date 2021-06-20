package org.kochi.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	// LoggerFactory를 이용해서 로그를 담는다.
	
	@RequestMapping(method=RequestMethod.GET)
	public String register() {
		logger.info("member");
		return "registerForm";
	}
	
	// URL 경로 상의 쿼리 파라미터 정보로부터 요청 데이터를 취득할 수 있다.
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String registerByParameter(String userId, String password, int coin) {
		logger.info("registerByParameter");
		logger.info("userId = " + userId);
		logger.info("password = " + password);
		logger.info("coin = "+coin);	// 타입변환은 자동으로 되지만, 타입이 알맞지 않은경우 ERR400-잘못된요청이 불려지게 된다.
		return "success";
	}
	// URL 경로 상의 변수를 파라미터로 가져올 수 있다.
	// 폼 필드로 송신하는 경우, 매개변수 명이 일치하면 요청 데이터를 취득할 수 있다.
	// 타입이 다를경우, 타입 변환하여 요청 데이터를 취득한다. 타입변환이 불가능하면 익셉션을 일으킨다.
	@RequestMapping(value="/register/{userId}", method=RequestMethod.GET)
	public String registerByPath(@PathVariable("userId")String userId) {
		//@PathVariable 어노테이션을 이용해서 Path상에 존재하는 변수값을 받아온다. 여러개여도 이러한 방식으로 받을 수 있다.
		logger.info("registerByPath");
		logger.info("userId = " + userId);
		return "success";
	}
	
	@RequestMapping(value="/register0202", method=RequestMethod.POST)
	public String register0202(@RequestParam("userId")String userId, @RequestParam("password")String password) {
		//@RequestParam 어노테이션은 form에 들어있는 동일한 name의 값을 파라미터로 받아올 수 있도록 해준다.
		logger.info("registerByPath");
		logger.info("userId = " + userId);
		logger.info("password = " + password);
		return "success";
	}
	
	@RequestMapping(value="register04", method=RequestMethod.POST)
	public String register04(Member member) {
		// 자바 빈즈 객체를 파라미터로 하여, 매개변수로 처리하게 할 수 있다.
		// 이렇게 하면 자바 빈즈 객체의 속성값은 자동으로 이름이 같은 것으로 매치되어 처리된다.
		// 순서와 상관없이 이름이 일치하는 것으로 알아서 매칭되기 때문에, 순서를 바꿔도 괜찮다.
		logger.info("register04");
		logger.info("Memer = " + member.toString());
		return "success";
	}
	
	// Date 타입을 처리하는 방법에는 여러가지가 있지만,
	// 특별한 처리를 해주지 않으면 기본 yyyy/MM/dd로 지정된다.
	@RequestMapping(value="register0501", method=RequestMethod.POST)
	public String register0501(Date dateofBirth) {
		logger.info("register0501 0.3");
		logger.info("date = " + dateofBirth);
		// 쿼리 파라미터로 2021-06-20을 받아도, 날짜 문자열 형식이 맞지 않아서 변환에 실패한다.
		// 파라미터로 2021/06/20과 같은 형태로 전달되어야 변환이 성공한다.
		return "success";
	}
	
	@RequestMapping(value="register0502", method=RequestMethod.POST)
	public String register0502(Member member) {
		logger.info("register0502 0.1");
		logger.info("member = " + member.toString());
		// Member 빈 객체의 birthday에서 @DateTimeFormat 어노테이션을 사용하여 타입을 지정해두었다.
		// 이렇게하면 원하는 타입을 지정하여 받아올 수 있다 이 경우, yyyyMMdd 로 지정해두었다.
		return "success";
	}
	
	@RequestMapping(value="register07", method=RequestMethod.POST)
	public String register07(String id, String pwd, String radio, String select,
			String mSelect, String[] mSelect2, ArrayList<String> mSelect3, 
			String check, String[] check2) {
		String mSelect3_str = "";
		for(int i=0;i<mSelect3.size();i++) mSelect3_str += mSelect3.get(i)+" ";
		
		// form 객체에서 전달되는 값들이 어떤 형태로 전달되는지 파악한다.
		logger.info("register07 0.1");
		logger.info("id = " + id);
		logger.info("pwd = " + pwd);
		logger.info("radio = " + radio);
		logger.info("select = " + select);
		logger.info("mSelect = " + mSelect);
		logger.info("mSelect2 = " + Arrays.toString(mSelect2));
		logger.info("mSelect3 = " + mSelect3.size());
		logger.info("check = " + check);
		logger.info("check2 = " + Arrays.toString(check2));
		return "success";
	}
	
	// 파일 업로드 폼 파일 요소 값을 스프링에서 지원해주는 MultipartFile 매개변수로 처리한다.
	@RequestMapping(value="register08", method=RequestMethod.POST)
	public String register08(MultipartFile picture) throws Exception {
		logger.info("register08");
		
		logger.info("originalName = " + picture.getOriginalFilename());
		logger.info("size = " + picture.getSize());
		logger.info("contentType = " + picture.getContentType());
		
		return "success";
	}
}
