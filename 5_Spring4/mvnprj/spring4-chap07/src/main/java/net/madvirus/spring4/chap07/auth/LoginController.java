package net.madvirus.spring4.chap07.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/auth/login")
public class LoginController {

	private static final String LOGIN_FORM = "auth/loginForm";
	private Authenticator authenticator;

	@RequestMapping(method = RequestMethod.GET)
	public String loginForm(LoginCommand loginCommand) {
		return LOGIN_FORM;
	}

	@RequestMapping(method = RequestMethod.POST)
	// HttpSession을 파라미터로 직접 등록하면, 간단하게 HttpSession값을 사용할 수 있다.
	// HttpSession 타입의 파라미터가 존재하면, 스프링 MVC는 HttpSession을 생성하ㅎ여, 파라미터 값으로 전달한다.
	// 세션이 존재하면, 해당 세션을 전달하며, 세션이 존재하지 않으면, 새로운 세션을 생성하여 전달한다.
	public String login(@Valid LoginCommand loginCommand, Errors errors,
			// 커맨드 객체 파라미터에 @Valid 어노테이션을 적용함
			HttpServletRequest request) {
			// 상황에따라 세션을 받고싶은 경우에는, HttpServletRequest를 파라미터로 받아서 상황에따라 직접 세션을 설정해주어야 한다.
		if (errors.hasErrors()) {
			return LOGIN_FORM;
		}
		try {
			Auth auth = authenticator.authenticate(loginCommand.getEmail(), loginCommand.getPassword());
			HttpSession session = request.getSession();
			session.setAttribute("auth", auth);
			return "redirect:/index.jsp";
		} catch (AuthenticationException ex) {
			errors.reject("invalidIdOrPassword");
			return LOGIN_FORM;
		}
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		// WebDataBinter를 초기화하도록 하고있다. 스프링 MVC가 lgoin 메소드를 실행하기 전
		// 여기서 초기화한 Validator 객체를 이용해서 @Valid 어노테이션이 붙은 커맨드 객체를 검증한다.
		binder.setValidator(new LoginCommandValidator());
	}

	public void setAuthenticator(Authenticator authenticator) {
		this.authenticator = authenticator;
	}

}
