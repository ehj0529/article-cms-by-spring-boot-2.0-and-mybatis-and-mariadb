<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티 사이트 - 게시물 리스트</title>
</head>
<body>
	<h1>게시물 리스트</h1>

	<h2>전체 게시물 개수 : ${totalCount}</h2>
	
	<a href="./add">게시물 추가</a>
	
	<c:forEach var="article" items="${list}"  >	
	<section>번호 : ${article.id} 제목 : ${article.title}    내용 : ${article.body}	</section>
	<hr>
	</c:forEach>

</body>
</html>