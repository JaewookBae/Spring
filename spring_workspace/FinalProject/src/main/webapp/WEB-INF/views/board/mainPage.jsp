<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>자유 게시판</h1>

	<c:choose>
		<c:when test="${!empty sessionUser }">
			${sessionUser.member_nick }님 환영합니다. <a href="../member/logoutProcess.do">로그아웃</a><br>
		</c:when>
		<c:otherwise>
	비회원으로 접근하였습니다. <a href="../member/loginPage.do">로그인</a>
		</c:otherwise>
	</c:choose>
</body>
</html>