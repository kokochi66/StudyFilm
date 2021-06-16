package net.madvirus.spring4.chap07.member;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class MemberRegistRequest {

	private String email;
	private String name;
	private String password;
	private String confirmPassword;
	private boolean allowNoti;
	private Address address;
	private Date birthday;
	// 입력받는 생일값을 java.util.Date 타입으로 사용한다.
	// 여기서 @DateTimeFormat(pattern="yyyyMMdd")와 같은 설정을 해주면, 간단하게 타입처리를 할 수 있다.
	// 그리고 잘못된 형식일 때 알맞은 메시지를 출력하고 싶다면, 메시지 프로퍼티 파일에 typeMismatch 메시지를 추가해주면 된다.
	// @DateTimeFormat의 속성 설정 339p

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public boolean isAllowNoti() {
		return allowNoti;
	}

	public void setAllowNoti(boolean allowNoti) {
		this.allowNoti = allowNoti;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public boolean isSamePasswordConfirmPassword() {
		if (password == null || confirmPassword == null)
			return false;
		return password.equals(confirmPassword);
	}

	public boolean hasPassword() {
		return password != null && password.trim().length() > 0;
	}

	public Date getBirthday() {
		return birthday;
	}

	@DateTimeFormat(pattern="yyyyMMdd")
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "MemberRegistRequest [email=" + email + ", name=" + name + ", password=" + password + ", confirmPassword=" + confirmPassword + ", allowNoti="
				+ allowNoti + "]";
	}

}
