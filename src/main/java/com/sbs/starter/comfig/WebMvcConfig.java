package com.sbs.starter.comfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

	//beforeActionInterceptor 인터셉터 불러오기.
	@Autowired
	@Qualifier("beforeActionInterceptor")
	HandlerInterceptor beforeActionInterceptor;
	
	//needToLoginInterceptor 인터셉터 불러오기.
	@Autowired
	@Qualifier("needToLoginInterceptor")
	HandlerInterceptor needToLoginInterceptor;

	//needToLogoutInterceptor 인터셉터 불러오기.
	@Autowired
	@Qualifier("needToLogoutInterceptor")
	HandlerInterceptor needToLogoutInterceptor;

	//인터셉터를 적용하는 역활.
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		// beforeActionInterceptor 를 모든액션(/**)에 연결. 단 /resource로 시작하는 액션은 제외
		registry.addInterceptor(beforeActionInterceptor).addPathPatterns("/**").excludePathPatterns("/resource/**");
		
		// /resource로 시작하는 URL
		// 메인, 로그인, 로그인처리, 가입, 가입처리 게시물 리스트 게시물 상세 빼고는 모두 로그인 상태로 접근가능.
		registry.addInterceptor(needToLoginInterceptor).addPathPatterns("/**").excludePathPatterns("/resource/**")
				.excludePathPatterns("/").excludePathPatterns("/member/login").excludePathPatterns("/member/doLogin")
				.excludePathPatterns("/member/Join").excludePathPatterns("/member/doJoin")
				.excludePathPatterns("/member/list").excludePathPatterns("/member/detail");
		
		//로그인, 로그인처리, 가입, 가입처리는 로그인 상태에서 접근 불가.
		registry.addInterceptor(needToLogoutInterceptor).addPathPatterns("/member/login")
				.addPathPatterns("/member/doLogin").addPathPatterns("/member/Join").addPathPatterns("/member/doLogin");
		
		;
		
		
		
		
		
		
		
	}
}
