package com.sbs.starter.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbs.starter.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j   //롬복 로그 log.info 사용가능함.
public class MemberController {
	@Autowired
	MemberService memberService;	
	
	@RequestMapping("/member/join")
	public String showJoin() {
		return "member/join";
	}

	@RequestMapping("/member/doJoin")
	@ResponseBody
	public Map<String, Object> doJoin(@RequestParam Map<String, Object> param) {

		Map<String, Object> checkLoginIdDupRs = memberService.checkLoginIdDup((String)param.get("loginId")); //로그인ID 중복 여부 체크.
		
		return checkLoginIdDupRs;
	}

	
}
