package sample.kokochi.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/test")
public class HomeController {

    @RequestMapping(value="/home", method = RequestMethod.GET)
    public String home(Model model) {
        System.out.println("/home :: 홈 매핑");
        model.addAttribute("data", "kokochi");
        return "home.html";
    }

}
