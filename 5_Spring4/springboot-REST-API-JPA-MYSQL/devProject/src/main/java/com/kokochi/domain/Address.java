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
public class Address {
	private String postCode;
	private String location;
}
