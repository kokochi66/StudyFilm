package com.spring1.inflearn.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping(value = "/hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello");
        return "hello";
    }

    @GetMapping(value = "/hello2")
    public String hello2(Model model, @RequestParam(name = "data") String data) {
        model.addAttribute("data", data);
        return "hello2";
        /*  View를 리턴하는 경우, ViewResolver가 해당 값을 Model 객체와 함께 받아와서 HTML로 변환하는 과정을 거친다.
        * */
    }

    @GetMapping(value = "/hello3")
    @ResponseBody
    public Hello hello3(@RequestParam(name = "data") String data) {
        Hello hello = new Hello(data);
        return hello;
        /* @ResposeBody를 사용하면, viewResolver를 거치지 않는다. 이 대신에 HttpMessageConverter 가 동작한다.
        *   이 대신, HTTP의 Body부분에 해당하는 문자 내용을 직접 입력한다.
        *   이를 기본 문자는 StringHttpMessageConverter가, 객체의경우 MappingJackson2HttpMessageConverter 가 동작하여 처리하게 된다.
         * */
    }

    static class Hello {
        private String name;

        public Hello(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
