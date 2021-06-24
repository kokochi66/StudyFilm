package org.hdcd.common.security;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@RequestMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		logger.info("access Denied : " + auth);
		model.addAttribute("msg", "Access Denied");
	}
}
