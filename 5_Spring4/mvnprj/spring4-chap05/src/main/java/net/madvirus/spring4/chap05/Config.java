package net.madvirus.spring4.chap05;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	@Bean
	public static ThresholdRequiedBeanFactoryPostProcessor processor() {
		ThresholdRequiedBeanFactoryPostProcessor p = new ThresholdRequiedBeanFactoryPostProcessor();
		p.setDefaultThreshold(10);
		return p;
	}

	@Bean
	public DataCollector collector1() {
		DataCollector collector = new DataCollector();
		collector.setThreshold(5);
		return collector;
	}

	@Bean
	public DataCollector collector2() {
		DataCollector collector = new DataCollector();
		// default지정값인 10으로 threshold가 지정될 것처럼 보이지만 실제로는 적용되지 않는다.
		// @Configuration을 이용해서 생성하는 빈 객체는 빈 설정 정보를 만들지 않기 때문
		
		return collector;
	}
}
