<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="pageName" value="회원가입"/>
    
<%@ include file="../part/head.jspf" %>


	<script >
		function submitJoinForm(form){
			
			form.loginId.value = form.loginId.value.trim();
			if( form.loginId.value.length == 0 ){
				alert('login ID 을 입력해 주세요.');
				form.loginId.focus();
				
				return false;
			}

			form.loginPw.value = form.loginPw.value.trim();
			if( form.loginPw.value.length == 0 ){
				alert('로그인 PW를 입력해 주세요.');
				form.loginPw.focus();
				
				return false;
			}

			form.loginPwConfirm.value = form.loginPwConfirm.value.trim();
			if( form.loginPwConfirm.value.length == 0 ){
				alert('로그인 PW확인을 입력해 주세요.');
				form.loginPwConfirm.focus();
				
				return false;
			}
			

			if( form.loginPw.value != form.loginPwConfirm.value ){
				alert('로그인PW가 일치하지 않습니다. 다시 입력해 주세요.');
				form.loginPw.focus();
				
				return false;
			}


			form.submit();
		}
	
	</script>
	
	
	<form class="con common-form" action="./doJoin" method="POST" onsubmit="submitJoinForm(this); return false;">
		<div>
			<span> 로그인ID </span>
			<div>
				<input name="loginId" type="text" placeholder="로그인"  autofocus="autofocus"  maxlength="30">
			</div>
		</div>
		
		<div>
			<span> 로그인PW </span>
			<div>
				<input name="loginPw" type="password" placeholder="로그인PW"  autofocus="autofocus"  maxlength="30">
			</div>
		</div>

		<div>
			<span> 로그인PW확인 </span>
			<div>
				<input name="loginPwConfirm" type="password" placeholder="로그인PW확인"  autofocus="autofocus"  maxlength="30">
			</div>
		</div>

		<div>
			<span> 가입 </span>
			<div>
				<input type="submit" value="가입" > 
				<input type="reset" value="취소" onclick="history.back();" > 
			</div>
		</div>

	</form>
	
<%@ include file="../part/foot.jspf" %>