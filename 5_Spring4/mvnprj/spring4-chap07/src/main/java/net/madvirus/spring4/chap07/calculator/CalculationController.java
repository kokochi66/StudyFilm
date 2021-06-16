package net.madvirus.spring4.chap07.calculator;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculationController {

	@RequestMapping("/cal/add")
	public String add(
			@RequestParam("op1") int op1,
			@RequestParam("op2") int op2,
			Model model) {
		model.addAttribute("result", op1 + op2);
		return "cal/result";
	}

	@RequestMapping("/cal/divide")
	public String divide(Model model,
			@RequestParam("op1") int op1, @RequestParam("op2") int op2) {
		model.addAttribute("result", op1 / op2);
		return "cal/result";
	}

	@ExceptionHandler(RuntimeException.class)
	// 익셉션의 타입을 지정하면 해당 에러 타입의 하위 타입까지도 처리할 수 있다.
	// 익셉션 타입을 지정하지 않고ㅓ, 익셉션 타입의 파라미터를 메서드에 추가할 수도 있다. 351p
	public String handleException(HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		// 메소드 내에서 200 응답코드가 아닌, 다른 응답코드를 전송하고싶은 경우에는, HttpServletResponse를 파라미터로 추가하여 설정하면 된다.
		return "error/exception";
	}
	// 컨트롤러의 @RequestMapping 메소드 실행 과정에서. 익셉션이 발생할 때, 직접 익셉션을 처리하고 싶을때, @ExceptionHandler를 사용한다.
	// 이렇게 되면 반환값인 'error/exception'에 해당하는 JSP파일을 보여주게 된다.
	
}
