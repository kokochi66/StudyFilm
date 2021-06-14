package net.madvirus.spring4.chap05;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

public class MoneyGenericConverter implements GenericConverter {

	private Set<ConvertiblePair> pairs;

	public MoneyGenericConverter() {
		Set<ConvertiblePair> pairs = new HashSet<>();
		pairs.add(new ConvertiblePair(String.class, Money.class));
		this.pairs = Collections.unmodifiableSet(pairs);
	}

	@Override
	public Set<ConvertiblePair> getConvertibleTypes() {
		return pairs;
		// 변환 가능한 타입의 쌍 집합 ConvertiblePair를 리턴함.
	}

	@Override
	public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
		// TypeDescriptor 정보를 이용해서 대상을 원하는 타입으로 변환하여 리턴하는 역할을 하는 메소드다.
		if (targetType.getType() != Money.class) {
			throw new IllegalArgumentException("invalid targetType");
		}
		if (sourceType.getType() != String.class) {
			throw new IllegalArgumentException("invalid sourceType");
		}
		String moneyString = (String) source;	// xml으로부터 주어지는 값은 String으로 먼저 치환된다.
		Pattern pattern = Pattern.compile("([0-9]+)([A-Z]{3})");	// 정규패턴을 통해서 문자열을 패턴화 시킨다.
		Matcher matcher = pattern.matcher(moneyString);
		if (!matcher.matches())
			throw new IllegalArgumentException("invalid format");
		// 원하는 패턴과 매치되지 않으면 익셉션을 발생시킨다.
		int amount = Integer.parseInt(matcher.group(1));
		String currency = matcher.group(2);
		return new Money(amount, currency);	// Money타입으로 변환한 뒤에 변환한 값을 리턴한다.
	}

}
