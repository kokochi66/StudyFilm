package net.madvirus.spring4.chap07.member;

import javax.validation.Valid;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class MemberModRequest {
// JSR303 어노테이션을 이용한 검증 처리, 값 검증 규칙을 설정한다.
// 각 어노테이션 별로 메세지 프로퍼티 파일에 규칙에 맞게 에러 메시지를 입력해주면, JSR 303의 기본 에러 메세지 대신 원하는 에러메시지를 출력할 수 있다.
// JSR303의 주요 어노테이션 - 333p , Hibernate Validator가 제공하는 추가 어노테이션
	@NotEmpty
	private String id;
	@NotEmpty
	private String name;
	@NotEmpty
	@Email
	private String email;
	private boolean allowNoti;
	@NotEmpty
	private String currentPassword;
	@Valid
	private Address address;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAllowNoti() {
		return allowNoti;
	}

	public void setAllowNoti(boolean allowNoti) {
		this.allowNoti = allowNoti;
	}

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
