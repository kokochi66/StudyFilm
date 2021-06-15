package net.madvirus.spring4.chap06.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class Profiler {

	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		// Around Advice를 구현한 메서드는 ProceedingJoinPoint타입을 첫번째 파라미터로 지정해야한다. 아니면 익셉션을 발생시킨다.
		String signatureString = joinPoint.getSignature().toShortString();
		System.out.println(signatureString + " 시작");
		long start = System.currentTimeMillis();
		try {
			Object result = joinPoint.proceed();
			return result;
		} finally {
			long finish = System.currentTimeMillis();
			System.out.println(signatureString + " 종료");
			System.out.println(signatureString + " 실행 시간 : " +
					(finish - start) + "ms");
		}
		// 대상 객체를 호출하기 전과 후의 시간을 구해서 해당 시간을 출력하는 역할을 하는 메소드다.
		// Around Advice를 구현한 것으로, 공통기능을 제공할 클래스이다.
	}

}
