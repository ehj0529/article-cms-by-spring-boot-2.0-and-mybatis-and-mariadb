package com.sbs.starter.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

//인터셉터 이름
@Component("needToLogoutInterceptor") //컴퍼넌트이름설정.
public class NeedToLogoutInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		boolean isLogined  = (boolean) request.getAttribute("isLogined") ;
		
		if( isLogined ) {
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().append("<script>");
			response.getWriter().append("history.back()");
			response.getWriter().append("</script>");
			return false;
		}
		
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

}
