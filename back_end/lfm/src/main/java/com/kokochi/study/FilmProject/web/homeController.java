package com.kokochi.study.FilmProject.web;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Log4j2
public class homeController {


    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView home(ModelAndView mav) {
        log.info("/ :: 홈 컨트롤러 매핑");
        mav.setViewName("home");
        return mav;
    }

    @RequestMapping(value="/layout", method = RequestMethod.GET)
    public String layoutTest() {
        log.info("/layout :: 레이아웃 테스트");
        return "layout/mainlayout";
    }

}
