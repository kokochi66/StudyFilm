package org.hdcd.controller;

import org.hdcd.domain.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() {
		logger.info("loginForm");

		return "loginForm";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Member member, Model model) {
		logger.info("login");

		logger.info("login userId = " + member.getUserId());
		logger.info("login userPw = " + member.getUserPw());

		model.addAttribute("result", "로그인 되었습니다.");

		return "success";
	}

}
