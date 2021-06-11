package net.madvirus.spring4.chap03;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class ConnPool2 {
//	어노테이션 @PostConstruct와 @PreDestroy를 이용한 초기화/소멸과정  
//	JSR250에 저장되어있기 때문에, 사용을 위해서는  CommonAnnotationBeanPostProcessor 전처리기를 스프링 빈에 등록해야한다.
//	<context:annotation-config>태그를 사용하여 등록할 수 있다.
//	초기화 소멸과정에서 사용되는 메소드는 파라미터를 가질 수 없다.
	@PostConstruct
	public void initPool() {
		System.out.println("ConnPool2.initPool()");
	}

	@PreDestroy
	public void destroyPool() {
		System.out.println("ConnPool2.destroyPool()");
	}
}
