package net.madvirus.spring4.chap03;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class ConnPool1 implements InitializingBean, DisposableBean {
// InitailizingBean 인터페이스와 DisposableBean 인터페이스를 이용한 초기화/소멸과정
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("ConnPool1.afterPropertiesSet()");
	}
//	INitializingBean 인터페이스에서 구현하는 메소드로, 초기화과정을 거치는 작업을 한다. 

	@Override
	public void destroy() throws Exception {
		System.out.println("ConnPool1.destroy()");
	}
//	DisposableBean 인터페이스에서 구현하는 메소드로, 소멸과정을 처리하도록 한다.
}
