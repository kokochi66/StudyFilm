package com.kokochi.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {

	@RequestMapping(value="", method=RequestMethod.GET)
	public String home(Model model) {
		log.info("/ - 홈 매핑");
		
		Date date = new Date();
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 M월 d일 (E) a h시 m분 s초");
		String formattedNow = now.format(formatter);
		
		model.addAttribute("serverTime", formattedNow);
		
		return "home";
	}
	// 홈 매핑
	
	@RequestMapping(value="/ajaxHome", method=RequestMethod.GET)
	public String ajaxHome(Model model) {
		log.info("/ajaxHome - ajaxHome 매핑");
		
		Date date = new Date();
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 M월 d일 (E) a h시 m분 s초");
		String formattedNow = now.format(formatter);
		
		model.addAttribute("serverTime", formattedNow);
		
		return "ajaxHome";
	}
	// /ajaxHome - ajaxHome 매핑
	
	@RequestMapping(value="/validajaxHome", method=RequestMethod.GET)
	public String validajaxHome(Model model) {
		log.info("/validajaxHome - validajaxHome 매핑");
		
		Date date = new Date();
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 M월 d일 (E) a h시 m분 s초");
		String formattedNow = now.format(formatter);
		
		model.addAttribute("serverTime", formattedNow);
		
		return "validajaxHome";
	}
	// /validajaxHome - validajaxHome 매핑
	
	/*
	 * @Slf4j 사용이 제대로 되지 않을 때 :: Maven Dependencies 에서 lombok을 install 해준다.
	 * 
	 * 자바 빈즈 : 자바로 작성된 소프트웨어 컴포넌트
	 * 자바 빈즈 클래스 작동을 위해, 객체 클래슨느 명명법, 생성법, 행동에 관련도니 일련의 관례를 따라야함.
	 * 이러한 관례를 통해 개발 도구에서 자바빈즈와의 연결을 통한 클래스 재사용, 재배치를 가능하게 함
	 * 이 관례는 다음과 같음
	 * - 클래스는 직렬화 되어야 함(클래스 상태를 지속적으로 저장,복원 시키기 위함)
	 * - 클래스는 기본 생성자를 가지고 있어야 함
	 * - 클래스의 속성은 get, set 혹은 표준 명명법을 따르는 메소드를 사용해 접근할 수 있어야 함
	 * - 클래스는 필요한 이벤트 처리 메소드를 포함하고 있어야 함.
	*/
}
