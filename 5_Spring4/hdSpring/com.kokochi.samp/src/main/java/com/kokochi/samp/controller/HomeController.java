package com.kokochi.samp.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kokochi.samp.domain.Member;
import com.kokochi.samp.domain.User;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping(value="/")
	public String home(Locale locale, Model model) { // 메인 home 화면 매핑
		logger.info("/ - Home Mapping :: Locale = "+ locale);
		return "homes";
	}
	
	@RequestMapping(value="/post", method = RequestMethod.GET)
	public String postGET(Locale locale, Model model) { // 메인 home 화면 매핑
		logger.info("/post - POST TEST");
		return "posttest";
	}
	@RequestMapping(value="/post", method = RequestMethod.POST)
	public String postPOST(Locale locale, User user) { // 메인 home 화면 매핑
		logger.info("/post - POST TEST MEMBER = " + user.toString());
		return "GOOD";
	}
}
