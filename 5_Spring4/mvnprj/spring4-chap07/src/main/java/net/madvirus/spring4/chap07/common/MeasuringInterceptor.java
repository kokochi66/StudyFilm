package net.madvirus.spring4.chap07.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MeasuringInterceptor extends HandlerInterceptorAdapter {
// HandlerInterceptor 인터페이스를 재정의하여 컨트롤러 실행 전, 실행 후, 뷰를 실행 한 후에 각 처리할 메소드를 구현할 수 있다.
// 이 부분은 각 실행 메소드에서 공통적으로 처리해야하는 부분이 있을때, 중복코드를 줄이기 위해서 사용될 수 있다.
// 설정은 <mvc:interceptors>를 추가함으로써 해당 빈을 추가해줘야한다. 366p
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("MI: preHandle()");
		request.setAttribute("mi.beginTime", System.currentTimeMillis());
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		System.out.println("MI: afterCompletion()");
		Long beginTime = (Long) request.getAttribute("mi.beginTime");
		long endTime = System.currentTimeMillis();
		System.out.println(request.getRequestURI() + " 실행 시간: " + (endTime - beginTime));
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		System.out.println("MI: postHandle()");
	}

	
}
