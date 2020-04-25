package com.sbs.starter.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbs.starter.dto.Member;
import com.sbs.starter.service.MemberService;
import com.sbs.starter.service.MemberServiceImpl;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class HomeController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/home/main")
	public String showMain(HttpSession session) {
		
		long loginedMemberId = 0;
		
		if ( session.getAttribute("loginedMemberId") != null) {
			loginedMemberId = (long) session.getAttribute("loginedMemberLoginId");  
		}
		
		Member loginedMember = memberService.getOne(loginedMemberId);
		
		log.info("loginedMember:: "+loginedMember);
		
		return "메인화면 호출 입니다.";
	}
	
	@RequestMapping("/")
	public String showMain2() {
		return "redirect:/home/main";
	}
	
	
	
}
