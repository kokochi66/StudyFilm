package org.kokochi.prj.controller;

import org.kokochi.common.security.domain.CustomUser;
import org.kokochi.prj.domain.Board;
import org.kokochi.prj.domain.Member;
import org.kokochi.prj.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private static boolean[] navbar_value = {false, false, false,false,true,false,false,false,false,false};
	
	@Autowired
	private BoardService service;
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_MEMBER')")
	public void registerForm(Model model, Authentication authentication) throws Exception {
		CustomUser customUser = (CustomUser) authentication.getPrincipal();
		Member member = customUser.getMember();
		
		Board board = new Board();
		model.addAttribute("navbar_value", navbar_value);
		
		board.setWriter(member.getUserId());
		model.addAttribute(board);
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_MEMBER')")
	public String register(Board board, RedirectAttributes rttr) throws Exception {
		service.register(board);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/board/list";
	}
	
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void list(Model model) throws Exception {
		model.addAttribute("list", service.list());
		model.addAttribute("navbar_value", navbar_value);
	}
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public void read(Model model, int boardNo) throws Exception {
		model.addAttribute(service.read(boardNo));
		model.addAttribute("navbar_value", navbar_value);
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MEMBER')")
	public String remove(int boardNo, RedirectAttributes rttr) throws Exception {
		service.remove(boardNo);
		
		rttr.addFlashAttribute("msg","SUCCESS");
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MEMBER')")
	public void modifyForm(Model model, int boardNo) throws Exception {
		model.addAttribute(service.read(boardNo));
		model.addAttribute("navbar_value", navbar_value);
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MEMBER')")
	public String modify(Board board, RedirectAttributes rttr) throws Exception {
		service.modify(board);
		
		rttr.addFlashAttribute("msg","SUCCESS");
		return "redirect:/board/list";
	}
	
}
