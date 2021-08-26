package com.kokochi.test.controller;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value="/message")
public class MessageTestController {

	private final MessageSource messageSource;
	
	@PostMapping(value="/test/welcome", produces="text/plain;charset=UTF-8")
	public ResponseEntity<String> welcomeMessage() {
		log.info("/message/test/welcome POST :: ");
		
		String[] args = {"꼬꼬치꼬치"};
//		String message = messageSource.getMessage("greeting", args, Locale.KOREAN);
		
		ResourceBundleMessageSource messageSources = new ResourceBundleMessageSource();
		messageSources.setBasename("message");
		messageSources.setDefaultEncoding("UTF-8");
		
		String message = messageSources.getMessage("greeting", args, Locale.KOREAN);
		
		return new ResponseEntity<String>(message, HttpStatus.OK);

	}
	// /valid/member/register POST
}
