package net.madvirus.spring4.chap04.config;

import net.madvirus.spring4.chap04.ConnectionProvider;
import net.madvirus.spring4.chap04.JdbcConnectionProvider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class ConfigByProp {

	@Value("${db.driver}")
	private String driver;
	@Value("${db.jdbcUrl}")
	private String jdbcUrl;
	@Value("${db.user}")
	private String user;
	@Value("${db.password}")
	private String password;
	// @Value를 통해서 프로퍼티를 설정한다.
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		configurer.setLocation(new ClassPathResource("db.properties"));
		// 설정한 값을 dp.properties의 프로퍼티값으로 치환한다.
		return configurer;
	} // 정적 메소드로 지정하지 않으면 원하는 방식으로 동작하지 않는다.

	@Bean(initMethod = "init")
	public ConnectionProvider connectionProvider() {
		JdbcConnectionProvider connectionProvider = new JdbcConnectionProvider();
		connectionProvider.setDriver(driver);
		connectionProvider.setUrl(jdbcUrl);
		connectionProvider.setUser(user);
		connectionProvider.setPassword(password);
		return connectionProvider;
	}
}
