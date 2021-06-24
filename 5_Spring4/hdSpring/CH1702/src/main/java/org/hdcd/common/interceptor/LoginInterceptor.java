package org.hdcd.common.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	private static final String USER_INFO = "userinfo";
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//		logger.info("preHandle");
//		return true;
//	}
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//		logger.info("postHandle");
//	}
//	@Override
//	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//		logger.info("afterCompletion");
//	}
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.info("preHandle");
		String requestURL = request.getRequestURI();
		HandlerMethod method = (HandlerMethod) handler;
		Method methodObj = method.getMethod();
		HttpSession session = request.getSession();	// 세션을 가져온다
		if(session.getAttribute(USER_INFO) != null) {	// 세션에 userinfo가 이미 존재한다면
			session.removeAttribute(USER_INFO);	// userinfo 세션을 삭제해준다.
		}
		return true;
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		logger.info("postHandle");
		String requestURL = request.getRequestURI();
		HandlerMethod method = (HandlerMethod) handler;
		Method methodObj = method.getMethod();
		HttpSession session = request.getSession();
		ModelMap modelMap = modelAndView.getModelMap();
		Object member = modelMap.get("user");	// modelMap에서 user에 해당하는 객체를 가져온다.
		if(member != null) {
			session.setAttribute(USER_INFO, member);	// user 객체가 존재한다면, 해당 객체를 USER_INFO 세션으로 등록해준다.
			response.sendRedirect("/");
		}
	}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		logger.info("afterCompletion");
		String requestURL = request.getRequestURI();
		HandlerMethod method = (HandlerMethod) handler;
		Method methodObj = method.getMethod();
	}
}
