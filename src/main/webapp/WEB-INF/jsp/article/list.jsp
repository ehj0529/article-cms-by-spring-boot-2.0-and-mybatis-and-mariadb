<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.*" %>
<%@ page import="com.sbs.starter.dto.Article" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티 사이트 - 게시물 리스트</title>
</head>
<body>
	<h1>게시물 리스트</h1>

	<c:forEach var="article" items="${list}"  >	
	<section>
		<td> 번호 : ${article.id}  </td>
		<td> 제목 : ${article.title} </td>
	</section>
	<hr>
	</c:forEach>

</body>
</html>