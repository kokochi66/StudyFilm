package com.kokochi.test.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kokochi.domain.ValidMember;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="/valid")
public class ValidTestController {
	
	@PostMapping(value="/member/register", produces="text/plain;charset=UTF-8")
	public ResponseEntity<String> register(@Validated @RequestBody ValidMember member , BindingResult result) {
		log.info("/valid/member/register POST");
		if(result.hasErrors()) {
			ResponseEntity<String> entity = new ResponseEntity<String>(result.toString(), HttpStatus.BAD_REQUEST);
			return entity;
		}
		
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;

	}
	// /valid/member/register POST
}
