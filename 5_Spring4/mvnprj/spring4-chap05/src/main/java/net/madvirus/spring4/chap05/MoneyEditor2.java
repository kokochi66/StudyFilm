package net.madvirus.spring4.chap05;

import java.beans.PropertyEditorSupport;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MoneyEditor2 extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Pattern pattern = Pattern.compile("([0-9]+)([A-Z]{3})");
		Matcher matcher = pattern.matcher(text);
		if (!matcher.matches())
			throw new IllegalArgumentException("invalid format");
		
		int amount = Integer.parseInt(matcher.group(1));
		String currency = matcher.group(2);
		setValue(new Money(amount, currency));
	} // 단순히 타입변환 기능만 필요한 경우, PropertyEditorSupport클래스를 상속받아, setAsText()메소드 정의만 해주면 된다.
	// 이 MoneyEditor크래스를 이용해서 Money타입의 프로퍼티 값을 문자열로 설정할 수 있다.
	
}
