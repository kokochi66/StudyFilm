package net.madvirus.spring4.chap08.locale;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller
public class LocaleChangeController2 {

	@RequestMapping("/changeLanguage2")
	public String change(@RequestParam("lang") String language,
			HttpServletRequest request, HttpServletResponse response) {
		Locale locale = new Locale(language);
		LocaleResolver localeResolver = RequestContextUtils
                .getLocaleResolver(request);
		// RequestContextUtils 클래스가 웹 요청과 관련된 LocaleResolver를 구할 수 있는 메소드를 제공하여,
		// 위와 같은 방법으로도 스프링에서 Locale을 변경할 수 있다.

		localeResolver.setLocale(request, response, locale);
		return "redirect:/index.jsp";
	}

}
