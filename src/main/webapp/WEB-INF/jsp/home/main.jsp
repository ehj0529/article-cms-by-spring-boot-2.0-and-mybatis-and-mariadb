<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="pageName" value="메인"/>
    
<%@ include file="../part/head.jspf" %>



	<script >
		function submitMainLogoutForm(form){

			var loginedMember  = '${loginedMember}';
			
			if( loginedMember != null ){
				alert('로그인아웃 하시겠습니까?');
				form.submit();
			}

		}
	
	</script>


	<form class="con common-form" action="./doLogout" method="POST" onsubmit="submitMainLogoutForm(this); return false;">
	
	<div>
		테스트 넘버 : ${testNumber}
	</div>
	
	<c:if test="${loginedMember != null}">
		<div class="con"> 회원 로그인ID : ${loginedMember.loginId} </div>
		
<!-- 		<div>
			<span> 로그아웃 </span>
			<div>
				<input type="submit" value="로그아웃" > 
			</div>
		</div> -->
	</c:if>
		

	</form>	
<%@ include file="../part/foot.jspf" %>