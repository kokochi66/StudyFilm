package com.kokochi.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class ValidMember {
	@NotBlank
	private String userId;
	private String password;
	
	@NotBlank
	@Size(max=3)
	private String userName;
	private String email;
	private String gender;
	
	
	/*
	 * 입력값 검증 :: 스프링 MVC는 Bean Validation 기능을 활용하여 파라미터 값이 바인딩 된 도메인 클래스의 입력값 검증을 한다.
	 * - 입력값 검증을 위해서 메서드 매개변수에 도메인 클래스를 정의하고 @Validated 를 지정한다.
	 * 
	*/
}
