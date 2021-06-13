package net.madvirus.spring4.chap05;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		DataCollector collector1 = ctx.getBean("collector1", DataCollector.class);
		DataCollector collector2 = ctx.getBean("collector2", DataCollector.class);
		System.out.println("collector1.threshold = " + collector1.getThreshold());
		System.out.println("collector2.threshold = " + collector2.getThreshold());
		// applicationContext.xml에 defaultThreshold값이 10으로 지정되어있기때문에, 
		// Threshold를 지정하지않은 collector2의 threshold는 자동으로 10으로 지정된다.
		ctx.close();
	}
}
