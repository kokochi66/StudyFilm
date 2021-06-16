package net.madvirus.spring4.chap07.member;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class MemberRegistValidator implements Validator {
// 서버측에서 요청받은 파라미터를 검사할 때, Validator 인터페이스를 사용할 수 있다.

	@Override
	public boolean supports(Class<?> clazz) {
		return MemberRegistRequest.class.isAssignableFrom(clazz);
		// MemberRegistRequest 타입의 객체를 지원하도록 메서드를 구현함.
	}

	@Override
	public void validate(Object target, Errors errors) {
		// 실제로 주어진 값을 검사하는 코드
		// target이 값을 검증할 객체이며, error는 값이 올바르지않을 경우그 값을 저장하기 위해 사용된다.
		MemberRegistRequest regReq = (MemberRegistRequest) target;
		if (regReq.getEmail() == null || regReq.getEmail().trim().isEmpty())
			errors.rejectValue("email", "required"); // email 프로퍼티가 잘못되었으며, 에러코드로 required를 사용한다는 의미이다.

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "required");
		// 각 프로퍼티 값이 null이거나 없으면, 에러가 있음을 저장한다.
		
		if (regReq.hasPassword()) {
			if (regReq.getPassword().length() < 5)
				errors.rejectValue("password", "shortPassword");
			else if (!regReq.isSamePasswordConfirmPassword())
				errors.rejectValue("confirmPassword", "notSame");
		}
		Address address = regReq.getAddress();
		if (address == null) {
			errors.rejectValue("address", "required");
		} else {
			errors.pushNestedPath("address");
			try {
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address1", "required");
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address2", "required");
			} finally {
				errors.popNestedPath();
			}
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birthday", "required");
	}

}
