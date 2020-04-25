<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="pageName" value="메인"/>
    
<%@ include file="../part/head.jspf" %>
	
	<c:if test="${loginedMember != null}">
		<div class="con"> 회원 로그인ID : ${loginedMember.loginId} </div>
	</c:if>
	
<%@ include file="../part/foot.jspf" %>