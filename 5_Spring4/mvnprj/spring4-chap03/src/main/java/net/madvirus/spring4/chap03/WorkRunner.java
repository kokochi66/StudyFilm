package net.madvirus.spring4.chap03;

import org.springframework.beans.factory.BeanNameAware;

public class WorkRunner implements BeanNameAware {

	private String beanId;

	@Override
	public void setBeanName(String name) {
		this.beanId = name;
	} // BeanNameAware에서 주어지는 setBeanName  메소드를 이용해서 Bean의 이름을 받아올 수 있다.

	public void execute(Work work) {
		System.out.printf("WorkRunner[%s] execute Work[%d]\n", beanId, work.getOrder());
		work.run();
	}

}
