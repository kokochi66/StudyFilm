package net.madvirus.spring4.chap09.mc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mc/simple")
public class SimpleConverterController {

	@RequestMapping(method = RequestMethod.GET)
	public String simpleForm() {
		return "mc/simple";
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String simple(@RequestBody String body) {
		// 어노테이션 @RequestBody가 붙은 값을 파라미터로 전달한다.
		return body;
		// 어노테이션 @ResponseBody가 붙은 메소드는 리턴값으로 Http 응답 데이터로 사용한다.
		// HttpMessageConverter 구현 클래스 표 430p
	}

}