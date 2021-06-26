package com.kokochi.samp.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping(value="/")
	public String home(Locale locale, Model model) { // 메인 home 화면 매핑
		logger.info("/ - Home Mapping :: Locale = "+ locale);
		return "home";
	}
}
