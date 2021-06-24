package org.hdcd.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class CommonExceptionHandler {
	private static Logger logger = LoggerFactory.getLogger(CommonExceptionHandler.class);
	
//	@ExceptionHandler(Exception.class)
//	public String handle(Exception e) {
//		logger.info(e.toString());
//		return "error/errorCommon";
//	}
	
//	@ExceptionHandler(Exception.class)
//	public String handle(Exception ex, Model model) {
//		logger.info("handle = "+ ex.toString());
//		model.addAttribute("exception", ex);
//		return "/error/errorCommon3";
//	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handle404(Exception e) {
		logger.info("404 error :: "+e.toString());
		return "error/error404";
	}
}
