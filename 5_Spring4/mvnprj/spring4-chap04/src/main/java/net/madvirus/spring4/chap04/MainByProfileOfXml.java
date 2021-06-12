package net.madvirus.spring4.chap04;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainByProfileOfXml {

	public static void main(String[] args) {
		useBeansProfileXml();
		useNestedBeansProfile();
	}

	private static void useBeansProfileXml() {
		System.out.println("===== <beans> profile을 이용한 설정 ==== ");
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.getEnvironment().setActiveProfiles("prod");
		// dev값이 지정된 profile을 xml로 부터 가져오는 예시
		context.load(
				"classpath:/confprofile/prop-config.xml",
				"classpath:/confprofile/app-config.xml",
				"classpath:/confprofile/datasource-dev.xml",
				"classpath:/confprofile/datasource-prod.xml"
				);
		context.refresh();

		ChargeCalculator cal = context.getBean(ChargeCalculator.class);
		cal.calculate();
		context.close();
	}

	private static void useNestedBeansProfile() {
		System.out.println("===== 중첩 <beans> 태그를 이용한 profile 설정 ==== ");
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.getEnvironment().setActiveProfiles("prod");
		// profile로 'prod'가 지정된 XML을 가져오는 예시
		// 두개 이상의 프로필 활성화를 위해서는 setActiveProfiles("dev", "mysql") 방식을 사용할 수 있다.
		context.load("classpath:/confprofile/applicationContext.xml");
		context.refresh();

		ChargeCalculator cal = context.getBean(ChargeCalculator.class);
		cal.calculate();
		context.close();
	}
}
