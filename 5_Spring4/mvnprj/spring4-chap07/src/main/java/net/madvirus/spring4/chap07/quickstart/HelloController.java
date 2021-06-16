package net.madvirus.spring4.chap07.quickstart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/hello.do")
	public String hello(Model model) {
		model.addAttribute("greeting", "안녕하세요");
		return "hello";
	} // hello 메소드가 리턴한 객체는 ModelAndView 타입이 아닌, 일반 문자열 형식으로 리턴되었다.
	// 따라서 이 문자열을 누군가 중간에서 String 타입을 ModelAndVie졸 변경해주어야하는데, 이때 사용되는것이 HandlerAdapter이다.
	
	@RequestMapping("/hello-raw.do")
	public void hello(HttpServletResponse response) throws IOException {
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		writer.write("안녕하세요");
		writer.flush();
	}
}
