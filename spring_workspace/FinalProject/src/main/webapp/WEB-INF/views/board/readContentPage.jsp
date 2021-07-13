<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 보기</h1>
	
	<h2>제목 : ${content.boardVO.board_title }</h2><br>
	
	작성자 : ${content.memberVO.member_nick }<br>
	작성일 : <fmt:formatDate value="${content.boardVO.board_writedate }" pattern="yyyy년  MM월 dd일 hh시 mm분"/><br>
	조회수 : ${content.boardVO.board_readcount }<br>
	내용 : <br>
	${content.boardVO.board_content }
	<br><br>
	
	<a href="./mainPage.do">목록으로</a>
	<c:if test="${!empty sessionUser && sessionUser.member_no == content.memberVO.member_no }">
	<a href="delelteContentProcess.do?board_no=${content.boardVO.board_no }">삭제</a>
	<a href="updateContentPage.do?board_no=${content.boardVO.board_no }">수정</a>
	</c:if>
</body>
</html>