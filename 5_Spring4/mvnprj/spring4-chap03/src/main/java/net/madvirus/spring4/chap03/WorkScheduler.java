package net.madvirus.spring4.chap03;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class WorkScheduler implements ApplicationContextAware {

	private WorkRunner workRunner;
	private ApplicationContext ctx;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.ctx = applicationContext;
	} // 객체에서 스프링 컨테이너 접근할 수 있도록 클래스의 ctx 변수로 전달받도록 구현되어있음

	public void makeAndRunWork() {
		for (long order = 1; order <= 10; order++) {
			Work work = ctx.getBean("workProto", Work.class);
			work.setOrder(order);
			workRunner.execute(work);
		}
	}

	public void setWorkRunner(WorkRunner workRunner) {
		this.workRunner = workRunner;
	}

}
