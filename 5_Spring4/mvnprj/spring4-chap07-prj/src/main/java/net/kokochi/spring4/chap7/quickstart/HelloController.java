package net.kokochi.spring4.chap7.quickstart;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// 컨트롤러를 구현할 때, 먼저 클래스가 스프링 MVC의 컨트롤러임을 선언한다.
public class HelloController {
	
	@RequestMapping("/hello.do")
	// 현재 메소드가 /hello.do 로 들어오는 요청을 처리함을 지정한다.
	public String hello(Model model) {
		model.addAttribute("greeting", "안녕하세요");
		// 뷰에 greeting이라는 이름으로 안녕하세요 라는 데이터를 전달한다.
		return "hello";
		// 리턴값은 뷰의 이름으로 사용된다.
	}


}
