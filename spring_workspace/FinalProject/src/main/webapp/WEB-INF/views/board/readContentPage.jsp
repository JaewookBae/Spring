<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
</head>
<body>
	<h1>게시글 보기</h1>
	
	<h2>제목 : ${content.boardVO.board_title }</h2><br>
	
	작성자 : ${content.memberVO.member_nick }<br>
	작성일 : <fmt:formatDate value="${content.boardVO.board_writedate }" pattern="yyyy년  MM월 dd일 hh시 mm분"/><br>
	조회수 : ${content.boardVO.board_readcount }<br>
	
	<c:forEach items="${content.boardImageVOList }" var="boardImageVO">
		<img src="/upload/${boardImageVO.image_url }"><br>
	</c:forEach>
	
	내용 : <br>
	${content.boardVO.board_content }
	<br><br>
	
	<br>
	<i class="bi bi-heart text-danger fs-1"></i> 
	<!--  <i class="bi bi-heart-fill text-danger fs-1"></i> -->
	<br>
	좋아요 수 : 7
	
	<br>
	<br>
	<a href="./mainPage.do">목록으로</a>
	<c:if test="${!empty sessionUser && sessionUser.member_no == content.memberVO.member_no }">
	<a href="delelteContentProcess.do?board_no=${content.boardVO.board_no }">삭제</a>
	<a href="updateContentPage.do?board_no=${content.boardVO.board_no }">수정</a>
	</c:if>
	
	<hr>
	<c:if test="${!empty sessionUser }">
	<form>
		리플 : ${sessionUser.member_nick }<br>
		<textarea rows="4" cols="40"></textarea>
		<input type="submit" value="댓글작성">
	</form>
	</c:if>
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>	
</body>
</html>