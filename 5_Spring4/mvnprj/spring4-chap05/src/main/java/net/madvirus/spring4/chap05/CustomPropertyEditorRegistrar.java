package net.madvirus.spring4.chap05;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;

public class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {
// PropertyEditorRegistrar 인터페이스를 상속받은 클래스에서 PropertyEditor를 직접 생성하고 등록한다.
// 생성한 클래스를 빈으로 등록하고, CustomEditorConfigurer에 propertyEditorRegistrars프로퍼티로 등록한다.
	private String datePattern;

	@Override
	public void registerCustomEditors(PropertyEditorRegistry registry) {
		CustomDateEditor propertyEditor = new CustomDateEditor(new SimpleDateFormat(datePattern), true);
		registry.registerCustomEditor(Date.class, propertyEditor);
	}

	public void setDatePattern(String datePattern) {
		this.datePattern = datePattern;
	}

}
