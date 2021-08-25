package com.kokochi.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString @NoArgsConstructor
@AllArgsConstructor
public class Member {
	private String userId;
	private String password;
	private int coin;
	@JsonFormat(pattern="yyyy-MM-dd")
//	JSONFormat 어노테이션으로 날짜형식을 지정하면, 해당 문자열 형식이 Date 타입으로 변환된다.
	private Date dateOfBirth;
	private Address address;
	
}
