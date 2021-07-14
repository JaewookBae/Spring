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
	<h1>회원 가입</h1>
	<form action="./joinMemberProcess.do" method="post">
		ID : <input type="text" name="member_id"><br>
		PW : <input type="password" name="member_pw"><br>
		Nickname : <input type="text" name="member_nick"><br>
		Gender : <input type="radio" name="member_gender" value="M">Male
			  <input type="radio" name="member_gender" value="F">Female<br>
		Birth : <input type="date" name="member_birth"><br>
		PhoneNumb : <input type="text" name="member_phone"><br>
		E-mail : <input type="email" name="member_email"><br>
		취미 : 
		<c:forEach items="${hobbyCategoryList }" var="xxxx">
			<input name="hobby_category_no" value="${xxxx.hobby_category_no }" type="checkbox">${xxxx.hobby_category_name }
		</c:forEach>	
		<br>
		
		
		<input type="submit" value="회원가입"> 
	</form>
</body>
</html>