package com.kokochi.samp.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kokochi.samp.domain.User;

@Controller
@RequestMapping(value="/login")
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String login(@RequestParam String code, @RequestParam String scope, @RequestParam String state, Model model) {
		// 트위치 API에서 계정 인증 후에 로그인 경로로 응답을 받는다.
		// 응답 객체로 토큰 생성을 위한 인증코드인 code, 범위 값인 scope, 상태값인 state가 각각 String 형태로 들어오게 된다.
		logger.info("/login - GET Login code :: code = [" + code +"] :: scope = ["+scope+"] :: state = ["+state+"]");
		model.addAttribute("code", code);
		model.addAttribute("scope", scope);
		model.addAttribute("state", state);
		// 인증 코드를 받으면, 사용자의 엑세스 토큰을 얻기 위한 POST 요청을 보내야한다.
		// POST 요청을 담당하는 JSP파일로 이동시킨다.
		return "login/AuthCodeFlow_POST";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String loginPost(Model model, User user, HttpServletRequest request) {
		// 토큰을 이용해서 가져온 User 객체를 POST 요청상으로 가져와서 세션으로 적용시켜준다.
		// 파라미터로 전달되는 값은 User객체로 전달된다.
		logger.info("/login - POST getUSER :: "+user.toString());
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		// 세션 적용이 완료되었으면 메인 페이지로 이동시킨다.
		return "redirect:/";
	}
	
}
