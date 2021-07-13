package org.kokochi.prj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/error")
public class ErrorController {
	private static boolean[] navbar_value = {false, false, false ,true,false,false,false,false,false,false};
	
	@RequestMapping(value="/accessError" , method=RequestMethod.GET)
	public String accessError(Model model) {
		return "error/accessError";
	}
}
