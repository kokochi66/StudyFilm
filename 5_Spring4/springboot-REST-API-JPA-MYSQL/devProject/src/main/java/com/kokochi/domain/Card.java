package com.kokochi.domain;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter @Setter
@ToString @Data
public class Card {
	@NotBlank
	private String no;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date validMonth;
}
