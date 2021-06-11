package net.madvirus.spring4.chap04.config;

import net.madvirus.spring4.chap04.ConnectionProvider;
import net.madvirus.spring4.chap04.JdbcConnectionProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

@Configuration
@PropertySources(
	@PropertySource(
			value= {"classpath:/db.properties", "classpath:/app.properties"},
			ignoreResourceNotFound=true
	)
)

// PropertySource 자체를 두개 이상 설정한다면 @PropertySources 어노테이션을 사용하면 된다.
// 두개 이상의 프로퍼티 파일을 사용하고 싶다면 @PropertySource의 설정을 배열로 지정하면 된다.
// 자원이 없는경구 익셉션 발생 없이 무시하고 싶다면 IgnoreResourceNotFound 속성을 적용하면 된다.
public class ConfigByEnv {

	@Autowired
	private Environment env;

	@Bean(initMethod = "init")
	public ConnectionProvider connectionProvider() {
		JdbcConnectionProvider connectionProvider = new JdbcConnectionProvider();
		connectionProvider.setDriver(env.getProperty("db.driver"));
		connectionProvider.setUrl(env.getProperty("db.jdbcUrl"));
		connectionProvider.setUser(env.getProperty("db.user"));
		connectionProvider.setPassword(env.getProperty("db.password"));
		return connectionProvider;
	}
}
