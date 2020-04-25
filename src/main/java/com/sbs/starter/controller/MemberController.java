package com.sbs.starter.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sbs.starter.dto.Member;
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


	@RequestMapping("/member/login")
	public String showLogin() {
		return "member/login";
	}
	
	@RequestMapping("/member/doLogout")
	public String doLogout( HttpSession session) {
		
		//세션에서 아이디를삭제한다.
		session.removeAttribute("loginedMemberId");
		
		return "redirect:/";
	}
	


	@RequestMapping("/member/doLogin")
	public String doLogin(@RequestParam Map<String, Object> param,Model model, HttpSession session) {

		//로그인 ID  존재 여부 체크
		Member getMatchedOne = memberService.getMatchedOne((String)param.get("loginId"), (String)param.get("loginPw"));
		
		//로그인ID 회원정보가 없는 경우 redirect 호출.
		if ( getMatchedOne == null) {
			model.addAttribute("alertMsg", "일치하는 회원이 존재하지 않습니다.");
			model.addAttribute("historyBack", true);
			return "common/redirect";
		}
		
		//세션정보에 로그인 아이디를 셋팅.
		session.setAttribute("loginedMemberId", getMatchedOne.getId());
		
		model.addAttribute("alertMsg", "로그인 되었습니다.");
		model.addAttribute("redirectUrl", "/");
		
		return "common/redirect";
		
	}	
	
	
	@RequestMapping("/member/doJoin")
	public String doJoin(@RequestParam Map<String, Object> param, Model model) {

		//로그인 ID의 중복성 체크
		Map<String, Object> checkLoginIdDupRs = memberService.checkLoginIdDup((String)param.get("loginId")); //로그인ID 중복 여부 체크.
		
		//로그인ID 체크 결과 값이  F-로 오는 경우 redirect 호출.
		if ( ((String)checkLoginIdDupRs.get("resultCode")).startsWith("F-")) {
			model.addAttribute("alertMsg", checkLoginIdDupRs.get("msg"));
			model.addAttribute("historyBack", true);
			return "common/redirect";
		}
		
		//회원가입 ID등록
		Map<String, Object> joinRs = memberService.join(param); //로그인ID 중복 여부 체크.
		
		//회원가입 결과 값이  F-로 오는 경우 redirect 호출.
		if ( ((String)joinRs.get("resultCode")).startsWith("F-")) {
			model.addAttribute("alertMsg", joinRs.get("msg"));
			model.addAttribute("historyBack", true);
			return "common/redirect";
		}
		
		model.addAttribute("alertMsg", joinRs.get("msg"));
		model.addAttribute("redirectUrl", "/member/login");
		
		return "common/redirect";
		
	}

	
}
