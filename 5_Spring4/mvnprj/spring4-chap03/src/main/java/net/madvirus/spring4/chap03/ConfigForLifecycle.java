package net.madvirus.spring4.chap03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigForLifecycle {

	@Bean
	public MyBean myBean() {
		MyBean myBean = new MyBean();
		myBean.setProperty1("prop");
		return myBean;
	}

	@Bean
	public ConnPool1 connPool1() {
		return new ConnPool1();
	}

	@Bean
	public ConnPool2 connPool2() {
		return new ConnPool2();
	}

	@Bean(initMethod = "init", destroyMethod = "destroy")
	public ConnPool3 connPool3() {
		return new ConnPool3();
	} // 커스텀 init/destroy 메소드를 활용, 자바기반 설정을 활용하여 빈에 속성을 적용하는 방법이다. (실제 클래스는 커스텀으로 지정)

	@Bean
	public MyExtension extention() {
		return new MyExtension();
	}
}
