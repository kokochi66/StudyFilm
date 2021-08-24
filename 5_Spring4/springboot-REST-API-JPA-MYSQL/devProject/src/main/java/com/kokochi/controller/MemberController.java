package com.kokochi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
// RestController : Controller 어노테이션과 ResponseBody 어노테이션을 합쳐놓은 어노테이션임.
@RequestMapping(value="/member")
public class MemberController {

}
