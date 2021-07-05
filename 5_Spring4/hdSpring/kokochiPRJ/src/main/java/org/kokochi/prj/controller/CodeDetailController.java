package org.kokochi.prj.controller;

import java.util.List;

import org.kokochi.common.domain.CodeLabelValue;
import org.kokochi.prj.domain.CodeDetail;
import org.kokochi.prj.service.CodeDetailService;
import org.kokochi.prj.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/codedetail")
public class CodeDetailController {
	
	@Autowired
	private CodeDetailService codeDetailService;
	
	@Autowired
	private CodeService codeService;
	private static boolean[] navbar_value = {false, true, false,false,false,false,false,false,false,false};
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public void registerForm(Model model) throws Exception {
		CodeDetail codeDetail = new CodeDetail();
		model.addAttribute(codeDetail);
		model.addAttribute("navbar_value", navbar_value);
		
		List<CodeLabelValue> classCodeList = codeService.getCodeClassList();

		model.addAttribute("classCodeList", classCodeList);
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(CodeDetail codeDetail, RedirectAttributes rtts) throws Exception {
		codeDetailService.register(codeDetail);
		rtts.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/codedetail/list";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void list(Model model) throws Exception {
		model.addAttribute("list", codeDetailService.list());
		model.addAttribute("navbar_value", navbar_value);
	}
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public void read(CodeDetail codeDetail, Model model) throws Exception {
		model.addAttribute(codeDetailService.read(codeDetail));
		List<CodeLabelValue> classCodeList = codeService.getCodeClassList();
		model.addAttribute("classCodeList", classCodeList);
		model.addAttribute("navbar_value", navbar_value);
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(CodeDetail codeDetail, RedirectAttributes rtts) throws Exception {
		codeDetailService.remove(codeDetail);
		rtts.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/codedetail/list";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public void modifyForm(CodeDetail codeDetail, Model model) throws Exception {
		model.addAttribute(codeDetailService.read(codeDetail));
		List<CodeLabelValue> classCodeList = codeService.getCodeClassList();
		model.addAttribute("classCodeList", classCodeList);
		model.addAttribute("navbar_value", navbar_value);
	}
	
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(CodeDetail codeDetail, RedirectAttributes rtts) throws Exception {
		System.out.println("POST modify = " + codeDetail.toString());
		codeDetailService.modify(codeDetail);
		rtts.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/codedetail/list";
	}
}
