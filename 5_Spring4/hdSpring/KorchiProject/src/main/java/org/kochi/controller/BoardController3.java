
package org.kochi.controller;

import org.kochi.domain.Board;
import org.kochi.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// 클래스 레벨에 경로를 지정하여서, 하위 메서드 레벨의 요청경로를 덧붙인 형태로 경로를 지정할 수 있다.

@Controller

@RequestMapping("/board3")
public class BoardController3 {

	private static final Logger logger = LoggerFactory.getLogger(BoardController3.class); // LoggerFactory를 이용해서 로그를 담는다.

	@Autowired
	private BoardService service; // 컨트롤러에서는 @Autowired를 통해서 서비스 구현객체와 자동매핑을 해준다.
	// 여기서 구현 객체는 @Service 어노테이션을 통해서 인터페이스를 구현한 객체와 매핑된다.

	@RequestMapping(value="/register", method = RequestMethod.GET) 
	public String registBoard(Model model) throws Exception {
		logger.info("board3/register 글쓰기");
		model.addAttribute("board", new Board());
		return "/board3/register"; // 글쓰기 Form이 있는 JSP를 View로 보낸다.
	}
  
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerBoardPost(Board board, Model model) throws Exception {
		logger.info("board3/register 글작성");
		logger.info("전달된 board = " + board.toString());

		service.register(board);

		return "redirect:/board3/list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String BoardList(Board board, Model model) throws Exception {
		logger.info("board3/list 글목록");

		model.addAttribute("list", service.list());

		return "/board3/list";
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String BoardRemove(@RequestParam("boardNo") int boardNo, Model model) throws Exception {
		logger.info("board3/remove 글 삭제 처리 완료");

		service.remove(boardNo);

		return "redirect:/board3/list";

	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String BoardRead(@RequestParam("boardNo") int boardNo, Model model) throws Exception {
		logger.info("board3/read 글보기");

		model.addAttribute("board", service.read(boardNo));

		return "/board3/read";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String BoardModify(@RequestParam("boardNo") int boardNo, Model model) throws Exception {
		logger.info("board3/modify 글수정");

		model.addAttribute("board", service.read(boardNo));

		return "/board3/modify";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String BoardModifyPost(Board board, Model model) throws Exception {
		logger.info("board3/modify 글수정 처리 완료");

		service.modify(board);

		return "redirect:/board3/list";
	}

}
