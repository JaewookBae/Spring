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
</head>
<body>

<jsp:include page="../commons/globalNav.jsp"></jsp:include>

	<div style="width:1200px; margin: 0 auto">
		<div class="row">
			<div class="col"></div>
			<div class="col-8">
				<div class="row mt-5"><!-- 배너 -->
					<div class="col">배너 공간</div>
				</div>
				<form action="./mainPage.do" method="get">
				<div class="row mt-2"><!-- 검색 -->
					<div class="col">
						<select name="search_type" class="form-select">
							<option value="title">제목</option>
							<option value="content">내용</option>
							<option value="nick">닉네임</option>
						</select>
					</div>
					<div class="col-8">
						<input name="search_word" type="text" class="form-control">
					</div>
					<div class="col d-grid">
						<input type="submit" value="검색" class="btn btn-primary">
					</div>
				</div>
				</form>
				<div class="row mt-3"><!-- 데이터 로우 -->
					<div class="col">
						<table class="table">
							<tr>
								<td>글 번호</td>
								<td>제목</td>
								<td>작성자</td>
								<td>조회수</td>
								<td>작성일</td>
							</tr>
							<c:forEach items="${contentlist }" var="data">
								<tr>
									<td>${data.boardVO.board_no }</td>
									<td><a href ="./readContentPage.do?board_no=${data.boardVO.board_no }">${data.boardVO.board_title }</a></td>
									<td>${data.memberVO.member_nick }</td>
									<td>${data.boardVO.board_readcount }</td>
									<td><fmt:formatDate value="${data.boardVO.board_writedate }" pattern="MM.dd" /></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
				<div class="row mt-2"><!-- 페이징 및 글쓰기 버튼 -->
					<div class="col-2"></div>
					<div class="col">
						<nav aria-label="Page navigation example">
  							<ul class="pagination mb-0">
  							<c:choose>
  								<c:when test="${beginPage <=1 }">
		    						<li class="page-item disabled"><a class="page-link" href="./mainPage.do?page_num=${beginPage -1 }${addParam}">&lt;</a></li>  									
  								</c:when>
  								<c:otherwise>
		    						<li class="page-item"><a class="page-link" href="./mainPage.do?page_num=${beginPage -1 }${addParam}">&lt;</a></li>  									  								
  								</c:otherwise>
  							</c:choose>
  							
     						<c:forEach begin="${beginPage }" end="${endPage }" var="i">
    						<c:choose>
    							<c:when test="${currentPage == i }">
						    		<li class="page-item active"><a class="page-link" href="./mainPage.do?page_num=${i}${addParam}">${i}</a></li>    							    								    							
    							</c:when>
    							<c:otherwise>
						    		<li class="page-item"><a class="page-link" href="./mainPage.do?page_num=${i}${addParam}">${i}</a></li>    							    								
    							</c:otherwise>
    						</c:choose>
    						</c:forEach>
    						<c:choose>
    							<c:when test="${endPage >= totalPageCount }">
    								<li class="page-item disabled"><a class="page-link" href="./mainPage.do?page_num=${endPage +1 }${addParam}">&gt;</a></li>	
    							</c:when>
    							<c:otherwise>
    								<li class="page-item"><a class="page-link" href="./mainPage.do?page_num=${endPage +1 }${addParam}">&gt;</a></li>
    							</c:otherwise>
    						</c:choose>
    						
						  	</ul>
						</nav>
					</div>
					<div class="col-2 d-grid">
						<c:if test="${!empty sessionUser }">
						<a class="btn btn-primary" href="./writeContentPage.do">글 쓰기</a>
						</c:if>
					</div>
				</div>
			</div>
			<div class="col"></div>
		</div>
	</div>
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>