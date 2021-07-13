package org.kokochi.prj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class LoginController {
	private static boolean[] navbar_value = {false, false, false ,true,false,false,false,false,false,false};
	
	@RequestMapping("/login")
	public String loginForm(String error, String logout, Model model) {
		
		if(error != null) model.addAttribute("error", "Login Error!!!");
		
		if(logout != null) model.addAttribute("logout", "Logout!!");
		
		model.addAttribute("navbar_value", navbar_value);
		
		return "auth/loginForm";
	}
	
	@RequestMapping("/logout")
	public String logoutForm() {
		return "auth/logoutForm";
	}
}
