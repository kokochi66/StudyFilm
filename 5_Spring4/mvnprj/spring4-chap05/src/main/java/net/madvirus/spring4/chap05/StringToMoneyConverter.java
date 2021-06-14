package net.madvirus.spring4.chap05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.core.convert.converter.Converter;

public class StringToMoneyConverter implements Converter<String, Money> {
// GenericConverter 인터페이스를 구현하는 것보다 훨씬 간단하게 구현할 수 있다.
	@Override
	public Money convert(String source) {
		// 지정된 타입쌍이 하나밖에 없으므로, convert메소드만 구현하면 된다.
		Pattern pattern = Pattern.compile("([0-9]+)([A-Z]{3})");
		Matcher matcher = pattern.matcher(source);
		if (!matcher.matches())
			throw new IllegalArgumentException("invalid format");

		int amount = Integer.parseInt(matcher.group(1));
		String currency = matcher.group(2);
		return new Money(amount, currency); // 마찬가지로 입력된 값을 Money클래스 타입으로 변환하여 반환한다.
	}

}
