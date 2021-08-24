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
	private Date dateOfBirth;
	private Address address;
	
}
