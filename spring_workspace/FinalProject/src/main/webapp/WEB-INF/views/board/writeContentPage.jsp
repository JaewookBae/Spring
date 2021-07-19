<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 쓰기</h1>
	<!-- 메소드가 무조건 post 이여야함 -->
	<form action="./writeContentProcess.do" method="post"  enctype="multipart/form-data">
		작성자 : ${sessionUser.member_nick }<br>
		제목 : <input type="text" name="board_title"><br>
		내용 : <br>
		<textarea rows="10" cols="40" name="board_content"></textarea>
		<br>
		
		<input name="board_files" type="file" accept="image/*" multiple>
		<br>
		
		<input type="submit" value="저장">
		
		<!-- <button>저장</button> -->		
	</form>
	
</body>
</html>

















