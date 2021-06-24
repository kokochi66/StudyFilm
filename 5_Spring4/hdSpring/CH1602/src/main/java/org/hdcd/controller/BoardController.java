package org.hdcd.controller;

import org.hdcd.domain.Board;
import org.hdcd.exception.BoardRecordNotFoundException;
import org.hdcd.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService service;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerForm(Board board, Model model) throws Exception {
		
	}
	
//	@RequestMapping(value = "/register", method = RequestMethod.POST)
//	public String register(@Validated Board board, Model model) throws Exception {
//		service.register(board);
//
//		model.addAttribute("msg", "등록이 완료되었습니다.");
//
//		return "board/success";
//	}

	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(@Validated Board board, BindingResult result, Model model) throws Exception {
		// 입력값 검증 대상인 자바빈즈 메서드 매개변수에 @Validated를 지정하고, BindingResult를 저의하고, 바인딩 에러와 검사 에러를 확인한다.
		if(result.hasErrors()) return"board/register";
		service.register(board);
		model.addAttribute("msg", "등록이 완료되었습니다.");
		return "board/success";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model) throws Exception {
		model.addAttribute("list", service.list());
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(int boardNo, Model model) throws Exception {
		Board board = service.read(boardNo);
		
		model.addAttribute(board);
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(int boardNo, Model model) throws Exception {
		service.remove(boardNo);

		model.addAttribute("msg", "삭제가 완료되었습니다.");

		return "board/success";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyForm(int boardNo, Model model) throws Exception {
		model.addAttribute(service.read(boardNo));
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(Board board, Model model) throws Exception {
		service.modify(board);

		model.addAttribute("msg", "수정이 완료되었습니다.");

		return "board/success";
	}

}
