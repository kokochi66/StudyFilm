package com.kokochi.study.FilmProject.memo.web;

import com.kokochi.study.FilmProject.memo.domain.MemoBoardMasterVO;
import com.kokochi.study.FilmProject.memo.domain.MemoBoardVO;
import com.kokochi.study.FilmProject.memo.service.MemoBoardMasterService;
import com.kokochi.study.FilmProject.memo.service.MemoBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value="/memo")
@Log4j2
@RequiredArgsConstructor
public class MemoController {

    private final MemoBoardService memoBoardService;
    private final MemoBoardMasterService memoBoardMasterService;

    // :: / :: 메모 메인 페이지
    @RequestMapping(value="", method = RequestMethod.GET)
    public String memoHome(Model model) {
        log.info("TEST :: 메모 홈페이지 접근");

        List<MemoBoardMasterVO> memoBoardMasterList = memoBoardMasterService.getMemoBoardMasterListOrderByABC();
        model.addAttribute("masterList", memoBoardMasterList);

        return "memo/memo_home";
    }

    // :: /add :: 메모 추가 페이지
    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String memoAddPage(Model model,
                              @RequestParam(name = "id") Long id) {
        log.info("/add :: 메모 추가 페이지");
        MemoBoardMasterVO master = memoBoardMasterService.getMemoBoardMaster(id);
        model.addAttribute("master", master);
        return "memo/memo_add";
    }

    // :: /edit :: 메모 수정 페이지
    @RequestMapping(value="/edit", method = RequestMethod.GET)
    public String memoEditPage(Model model,
                               @RequestParam(name = "id") Long id) {
        log.info("/memo/edit 메로 수정 페이지");
        MemoBoardVO board = memoBoardService.getMemoBoard(id);
        model.addAttribute("board", board);
        return "memo/memo_edit";
    }

    // :: /list :: 메모 리스트 페이지
    @RequestMapping(value="/list", method = RequestMethod.GET)
    public String memoListPage(Model model,
                               @RequestParam(name = "id") Long id) {
        log.info("/memo/list :: 메모 리스트 가져오기 :: " + id);
        MemoBoardMasterVO master = memoBoardMasterService.getMemoBoardMaster(id);
        List<MemoBoardVO> boardList = memoBoardService.getMemoBoardListFromMasterId(id);
        model.addAttribute("master", master);
        model.addAttribute("boardList", boardList);
        return "memo/memo_list";
    }

    // :: /list :: 메모 상세보기 페이지
    @RequestMapping(value="/view", method = RequestMethod.GET)
    public String memoViewPage(Model model,
                               @RequestParam(name = "id") Long id) {
        log.info("/memo/view 메모 홈페이지 접근");
        MemoBoardVO board = memoBoardService.getMemoBoard(id);
        model.addAttribute("board", board);
        return "memo/memo_view";
    }



    // :: /add/process :: 메모 추가 처리
    @RequestMapping(value="/add/process", method = RequestMethod.POST)
    public String memoAddProcess(Model model,
                                 @ModelAttribute MemoBoardVO memoBoardVO,
                                 @RequestParam(name = "masterId") Long masterId) {
        log.info("/add/process POST :: 메모 추가 처리");
        MemoBoardMasterVO memoBoardMasterVO = new MemoBoardMasterVO();
        memoBoardMasterVO.setId(masterId);
        memoBoardVO.setMaster(memoBoardMasterVO);
        memoBoardService.addMemoBoard(memoBoardVO);

        return "redirect:/memo/list?id="+masterId;
    }

    // :: /edit/process :: 메모 수정 처리
    @RequestMapping(value="/edit/process", method = RequestMethod.POST)
    public String memoEditProcess(Model model,
                                 @ModelAttribute MemoBoardVO memoBoardVO) {
        log.info("/edit/process POST :: 메모 수정 처리");
        memoBoardService.updateMemoBoard(memoBoardVO);

        return "redirect:/memo/view?id="+memoBoardVO.getId();
    }

    // :: /delete/process :: 메모 삭제 처리
    @RequestMapping(value="/delete/process", method = RequestMethod.POST)
    public String memoDeleteProcess(Model model,
                                    @RequestParam(name = "id") Long id,
                                  @RequestParam(name = "masterId") Long masterId) {
        log.info("/delete/process POST :: 메모 삭제 처리");
        memoBoardService.deleteMemoBoard(id);

        return "redirect:/memo/list?id="+masterId;
    }




    // :: /master/add :: 게시판 추가 페이지
    @RequestMapping(value="/master/add", method = RequestMethod.GET)
    public String memoMasterAddPage(Model model) {
        log.info("/memo/master/add :: 게시판 추가 페이지");
        return "memo/master/memo_master_add";
    }

    // :: /master/add/process POST :: 게시판 추가 처리
    @RequestMapping(value = "/master/add/process", method = RequestMethod.POST)
    public String memoMasterAddProcess(@ModelAttribute MemoBoardMasterVO memoBoardMasterVO,
                                       Model model) {
        log.info("/memo/master/add/process :: 게시판 추가 처리");
        memoBoardMasterService.addMemoBoardMaster(memoBoardMasterVO);

        return "redirect:/memo/list?id="+memoBoardMasterVO.getId();
    }

    // :: /master/delete/process POST :: 게시판 삭제 처리
    @RequestMapping(value = "/master/delete/process", method = RequestMethod.POST)
    public String memoMasterDelete(@RequestParam(name="id") Long id,
                                   Model model) {
        log.info("/master/delete/process :: 게시판 삭제 처리");
        memoBoardMasterService.deleteMemoBoardMaster(id);

        return "redirect:/memo";
    }
}
