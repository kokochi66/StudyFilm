package org.hdcd.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping("/login")	// 사용자가 지정한 로그인 화면으로 가도록 컨트롤러를 지정해준다.
	public String loginForm(String error, String logout, Model model) {
		logger.info("error = " + error);
		logger.info("logout = " + logout);
		
		if(error != null) model.addAttribute("error", "Login Error!");	// 에러가 발생했다면, 메시지로 로그인 에러를 띄운다.
		if(logout != null) model.addAttribute("logout", "Logout!");	// 로그아웃이 되었다면, 메시지로 로그아웃을 띄운다.
		
		
		return "loginForm";
	}
	
	@RequestMapping("/logout")
	public String logoutForm() {
		logger.info("logoutForm");
		return "logoutForm";
	}
}
