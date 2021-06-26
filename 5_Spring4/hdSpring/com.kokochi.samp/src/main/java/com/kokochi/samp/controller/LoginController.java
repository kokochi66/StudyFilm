package com.kokochi.samp.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/login")
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String login(Locale locale, Model model) { // 메인 home 화면 매핑
		logger.info("/login - login Mapping :: Locale = "+ locale);
		
		return "login/login";
	}
}
