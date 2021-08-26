package com.kokochi.domain;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class ValidMember {
	/*
	 * 입력값 검증 :: 스프링 MVC는 Bean Validation 기능을 활용하여 파라미터 값이 바인딩 된 도메인 클래스의 입력값 검증을 한다.
	 * - 입력값 검증을 위해서 메서드 매개변수에 도메인 클래스를 정의하고 @Validated 를 지정한다.
	 * 
	 * 입력값 검증 결과 :: 입력값 검증 대상의 도메인 클래스 직후에 BindingResult를 정의하여, 검증 에러 정보가 저장되어 출력할 수 있다.
	 * 자세한 메소드는 해당 객체를 참조한다.
	 * 
	 * 입력값 검증 규칙 :: 입력값 검증 규칙은 Validaton 객체가 제공하는 제약 어노테이션을 이용하여 설정한다.
	 * @Notnull, @NotBlank, @Size, @Email, @Past, @Future 등이 있다.
	*/
	
	@NotBlank
	private String userId;
	@NotBlank
	private String password;
	
	@NotBlank
	@Size(max=3)
	private String userName;
	@Email
	private String email;
	private String gender;
	
	@Past
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateOfBirth;
	
	@Valid
	private Address address;
	@Valid
	private List<Card> cardList;
	// 중첩된 자바빈즈의 컬렉션에서 정의한 프로퍼티에 대해 입력값 검증을 추가로 할 때에는 @Valid를 필요로 한다.

}
