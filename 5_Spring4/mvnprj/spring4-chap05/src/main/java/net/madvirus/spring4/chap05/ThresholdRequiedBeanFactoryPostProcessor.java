package net.madvirus.spring4.chap05;

import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class ThresholdRequiedBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	private int defaultThreshold;

	public void setDefaultThreshold(int defaultThreshold) {
		this.defaultThreshold = defaultThreshold;
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		String[] beanNames = beanFactory.getBeanDefinitionNames(); // 빈 이름 목록을 구함
		for (String name : beanNames) {
			BeanDefinition beanDef = beanFactory.getBeanDefinition(name);
			// 지정한 이름을 가진 빈의 설정 정보를 구함
			Class<?> beanClass = getClassFromBeanDef(beanDef);
			// 설정 정보를 통해서 빈의 클래스 타입을 구한다
			if (beanClass != null && ThresholdRequired.class.isAssignableFrom(beanClass)) {
				// 빈의 클래스 타입이 ThresholdRequired를 구현했는지 검사한다.
				MutablePropertyValues prop = beanDef.getPropertyValues();
				// 빈의 프로퍼티 MutablePropertyValues를 구한다.
				if (!prop.contains("threshold")) {
					prop.add("threshold", defaultThreshold);
					// threshold 프로퍼티 값이 없다면, defaultThreshold로 설정된 프로퍼티를 추가한다.
				}
			}
		}
	}

	private Class<?> getClassFromBeanDef(BeanDefinition beanDef) {
		System.out.println(beanDef.toString());
		if (beanDef.getBeanClassName() == null)
			return null;
		try {
			return Class.forName(beanDef.getBeanClassName());
		} catch (ClassNotFoundException e) {
			throw new FatalBeanException(e.getMessage(), e);
		}
	}

}
