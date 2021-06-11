package net.madvirus.spring4.chap04;

import java.io.IOException;

import net.madvirus.spring4.chap04.config.ConfigByEnv;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class MainByEnvOfJava {

	public static void main(String[] args) throws IOException {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

		ctx.register(ConfigByEnv.class);
		// 자바파일로 된 config 파일을 불러들인다.
		ctx.refresh();

		ConfigurableEnvironment env = ctx.getEnvironment();
		// 사용할 프로필을 선택하고, PropertySource를 추가하는 데 필요한 기능을 제공한다.
		
		String javaVersion = env.getProperty("java.version");
		// 이름이 java.version 인 프로퍼티의 값을 구하는 코드 -> 시스템 프로퍼티로서 사용중인 자바 버전을 값으로 가진다.
		
		String dbUser = env.getProperty("db.user");
		System.out.printf("java version is %s\n", javaVersion);
		System.out.printf("dbUser is %s\n", dbUser);

		ctx.close();
	}
}
