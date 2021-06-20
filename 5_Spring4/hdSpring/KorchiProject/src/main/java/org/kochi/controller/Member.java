package org.kochi.controller;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Member {
	
	private String userName = "kochi";
	private String password = "1234";
	@DateTimeFormat(pattern="yyyyMMdd") 
	// Date타입에 대해서 특정 타입을 지정할 수 있다. 지정하지않으면 기본타입은 yyyy/MM/dd 가 된다.
	private Date birthday;
	private int coin = 5;
	public int getCoin() {
		return coin;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public void setCoin(int coin) {
		this.coin = coin;
	}
	public String getUserName() {
		return userName;
	}
	public Member() {
	}
	@Override
	public String toString() {
		return "Member [userName=" + userName + ", password=" + password + ", birthday=" + birthday + ", coin=" + coin
				+ "]";
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
