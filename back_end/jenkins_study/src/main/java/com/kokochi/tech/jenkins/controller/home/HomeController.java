package com.kokochi.tech.jenkins.controller.home;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
@Slf4j
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        return "content";
    }
}
