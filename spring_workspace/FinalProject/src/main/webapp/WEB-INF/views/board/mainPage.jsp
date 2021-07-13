<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			${sessionUser.member_nick }님 환영합니다. <a
				href="../member/logoutProcess.do">로그아웃</a>
			<br>
		</c:when>
		<c:otherwise>
	비회원으로 접근하였습니다. <a href="../member/loginPage.do">로그인</a>
		</c:otherwise>
	</c:choose>

	<br>
	<br>

	<table border="1">
		<tr>
			<td>글 번호</td>
			<td>글 제목</td>
			<td>작성자</td>
			<td>조회수</td>
			<td>작성일</td>
		</tr>
		<c:forEach items="${contentlist }" var="data">
			<tr>
				<td>${data.boardVO.board_no }</td>
				<td>${data.boardVO.board_title }</td>
				<td>${data.memberVO.member_nick }</td>
				<td>${data.boardVO.board_readcount }</td>
				<td>${data.boardVO.board_writedate }</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	
	<c:if test="${!empty sessionUser }">
		<a href="./writeContentPage.do">글쓰기</a>
	</c:if>
	
	
	
	
	
	
	
	
	
	
</body>
</html>