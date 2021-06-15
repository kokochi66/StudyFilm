package net.madvirus.spring4.chap06.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ProfilingAspect {
// @Aspect 어노테이션을 이용해서 Aspect 클래스를 구현한다. 여기서, Advice 구현 메소드와 Pointcut을 포함한다.
// XML 설정에서 aop:aspectj-autoproxy를 설정한다. @configuration 기반 설정을 이용한다면 @EnableAspecjJAutoProxy를 설정한다.
	
	@Pointcut("execution(public * net.madvirus.spring4.chap06.board..*(..))")
//	PointCut을 구현한 모습이다. Pointcut을 정의하는 AspectJ표현식을 값으로 가지며, 리턴타입은 void여야한다.
	private void profileTarget() {
	// @Pointcut이 적용된 메소드는 몸체에 코드를 가져도 의미가 없다.
	}

	@Around("profileTarget()")
//	Around Advice를 구현한 모습이다. 어노테이션 값으로는 Pointcut 어노테이션을 적용한 메소드의 이름을 지정한다.
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
	// XML 설정때와 마찬가지로 첫번째 파라미터로 ProceedingJoinPoint을 설정해야한다.
		String signatureString = joinPoint.getSignature().toShortString();
		System.out.println("AroundAdvice 불러옴 :: " +signatureString + " 시작");
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
	}
}
