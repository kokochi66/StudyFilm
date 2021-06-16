package net.madvirus.spring4.chap07.exhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("net.madvirus.spring4.chap07")
//@ControllerAdvice가 적용된 클래스는 지정한 범위의 컨트롤러에서 공통으로 사용될 설정을 적용한다.
// 이 클래스가 동작하려면, 해당 클래스릉 스프링에 빈으로 등록해야한다. 353p
// 같은 컨트롤러에도 익셉션을 처리하는 메소드가 정의되어있는게 있으면 그게 먼저 발동된다.
public class CommonExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public String handleException() {
		return "error/commonException";
	}
	// @ExceptionHandler 를 사용하여, 여러 컨트롤러에서 동일한 익셉션을 발생시키는 것을 처리하여, 익셉션 처리 메소드 중복을 없앨 수 있다.
}
