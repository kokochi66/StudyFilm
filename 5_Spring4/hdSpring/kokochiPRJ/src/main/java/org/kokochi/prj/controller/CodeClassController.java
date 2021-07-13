package org.kokochi.prj.controller;

import org.kokochi.prj.domain.CodeClass;
import org.kokochi.prj.service.CodeClassService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/codeclass")
@PreAuthorize("hasRole('ROLE_ADMIN')")	// 관리자 권한을 가진 사용자만 접근이 가능하도록 설정
public class CodeClassController {
	
	private static final Logger logger = LoggerFactory.getLogger(CodeClassController.class);
	private static boolean[] navbar_value = {true, false, false,false,false,false,false,false,false,false};
	
	@Autowired
	private CodeClassService service;
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public void registerForm(Model model) throws Exception {
		CodeClass codeClass = new CodeClass();
		model.addAttribute(codeClass);
		model.addAttribute("navbar_value", navbar_value);
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(CodeClass codeClass, RedirectAttributes rttr) throws Exception {
		service.register(codeClass);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/codeclass/list";
	}
	
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void list(Model model) throws Exception {
		logger.info("/list GET request");
		model.addAttribute("list", service.list());
		model.addAttribute("navbar_value", navbar_value);
	}
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public void read(String classCode, Model model) throws Exception {
		model.addAttribute(service.read(classCode));
		model.addAttribute("navbar_value", navbar_value);
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(String classCode, RedirectAttributes rttr) throws Exception {
		service.remove(classCode);
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/codeclass/list";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public void modifyForm(String classCode, Model model) throws Exception {
		model.addAttribute(service.read(classCode));
		model.addAttribute("navbar_value", navbar_value);
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(CodeClass codeClass, RedirectAttributes rttr) throws Exception {
		service.modify(codeClass);
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/codeclass/list";
	}
	
}
