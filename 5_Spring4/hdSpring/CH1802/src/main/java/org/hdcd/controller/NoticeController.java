package org.hdcd.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/notice")
@Controller
public class NoticeController {

	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);

	@RequestMapping("/list")
	public void list() {
		logger.info("list : access to all");
	}

	@RequestMapping("/register")
	public void registerForm() {
		logger.info("registerForm : access to admin");
	}

}
