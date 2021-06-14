package net.madvirus.spring4.chap05;

import java.text.ParseException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.format.Formatter;

public class MoneyFormatter implements Formatter<Money> {

	@Override
	public String print(Money object, Locale locale) {
		// Formatter 구현에서 print 메소드는 객체를 출력하기위한 문자열로 변환시키는 역할을 한다.
		return object.getAmount() + object.getCurrency();
	}

	@Override
	public Money parse(String text, Locale locale) throws ParseException {
		// parse 메소드는 타입변환을 하는 역할을 하므로, Formatter 인터페이스를 이용해서도 타입변환이 가능하다.
		Pattern pattern = Pattern.compile("([0-9]+)([A-Z]{3})");
		Matcher matcher = pattern.matcher(text);
		if (!matcher.matches())
			throw new IllegalArgumentException("invalid format");

		int amount = Integer.parseInt(matcher.group(1));
		String currency = matcher.group(2);
		return new Money(amount, currency);
	}

}
