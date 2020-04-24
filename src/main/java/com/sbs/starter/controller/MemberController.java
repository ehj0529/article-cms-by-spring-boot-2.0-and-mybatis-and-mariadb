package com.sbs.starter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j   //롬복 로그 log.info 사용가능함.
public class MemberController {
	
	@RequestMapping("/member/join")
	public String showJoin() {
		return "member/join";
	}


	
}
