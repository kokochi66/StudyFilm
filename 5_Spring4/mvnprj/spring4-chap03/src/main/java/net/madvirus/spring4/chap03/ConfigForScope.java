package net.madvirus.spring4.chap03;

import net.madvirus.spring4.chap03.Work.WorkType;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ConfigForScope {

	@Bean
	@Scope("prototype")
	public Work workProto() {
		Work work = new Work();
		work.setTimeout(2000);
		work.setType(WorkType.SINGLE);
		return work;
	} // 자바에서 빈 객체의 범위를 설정하려면 @Scope 어노테이션을 활용하면 된다.

	@Bean
	public WorkRunner workRunner() {
		return new WorkRunner();
	}

	@Bean
	public WorkScheduler workScheduler() {
		WorkScheduler scheduler = new WorkScheduler();
		scheduler.setWorkRunner(workRunner());
		return scheduler;
	}
}
