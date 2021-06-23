package org.hdcd.common.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ServiceLoggerAdvice {

	private static final Logger logger = LoggerFactory.getLogger(ServiceLoggerAdvice.class);

	@Before("execution(* org.hdcd.service.BoardService*.*(..))")
	public void startLog(JoinPoint jp) {
		logger.info("Before Advice -> " + jp.getSignature());
	}
	
	@AfterReturning("execution(* org.hdcd.service.BoardService*.*(..))")
	public void  logReturning(JoinPoint  jp) {
		logger.info("AfterReturning Advice -> " + jp.getSignature());
	}
	
	@AfterThrowing(pointcut = "execution(* org.hdcd.service.BoardService*.*(..))", throwing = "e")
	public void  logException(JoinPoint  jp, Exception e) {
		logger.info("AfterThrowing Advice -> " + jp.getSignature());
		logger.info("log Exception -> " + e);
	}
	
	@After("execution(* org.hdcd.service.BoardService*.*(..))")
	public void  endLog(JoinPoint  jp) {
		logger.info("After Advice -> " + jp.getSignature());
	}
	
	@Around("execution(* org.hdcd.service.BoardService*.*(..))")
	public Object  timeLog(ProceedingJoinPoint pip) throws Throwable {
		
		long startTime = System.currentTimeMillis();
		logger.info("Around Advice1 ->  " + Arrays.toString(pip.getArgs()));
		
		Object result = pip.proceed();
		long endTime = System.currentTimeMillis();
		logger.info("Around Advice2 ->  " + pip.getSignature().getName() + " : " + (endTime  - startTime));
		return result;
	}

}
