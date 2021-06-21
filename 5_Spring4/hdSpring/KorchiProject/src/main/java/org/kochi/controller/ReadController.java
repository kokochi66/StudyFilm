package org.kochi.controller;

import java.util.Date;

import org.kochi.entity.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/read")
public class ReadController {
	
	private static final Logger logger = LoggerFactory.getLogger(ReadController.class);
	// LoggerFactory를 이용해서 로그를 담는다.
	
	@RequestMapping(value="/r01", method=RequestMethod.GET)
	public String read01(Model model) {
		logger.info("read01");
		Member member = new Member("korchi", "1234", new Date("2020/06/20") ,50 );
		logger.info("member = " + member.toString());
		model.addAttribute(member);
		return "read/read01";
	}
	
	@RequestMapping(value="/r02", method=RequestMethod.GET)
	public String read02(@ModelAttribute("userId") String userId ) {
	// @ModelAttribute 어노테이션을 지정하면, Model에 별도로 등록하지 않더라도 자동으로 파라미터를 등록해준다.
		logger.info("read02");
		return "read/read02";
	}
	
	@RequestMapping(value="/r03", method=RequestMethod.POST)
	public String read03(Member member, RedirectAttributes rtts) throws Exception {
		// RedirectAttribute는 일회성으로 데이터를 전달하는 용도로 사용된다.
		logger.info("read03");
		rtts.addFlashAttribute("msg", "success");
		
		return "read/read03";
	}
	
	
	
}
