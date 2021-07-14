<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div style="width:1200px; margin: 0 auto">
		<div class="container-fluid">
			<div class="row mt-5">
				<div class="col"></div>
				<div class="col-4">
					<div class="row mt-3"><!-- 배너 로우 -->
						<div class="col">
							<img class="img-fluid" src="../resources/image/3.jpg">
						</div>
					</div>
					<form action="./loginProcess.do" method="post">
					<div class="row mt-3"><!-- ID 로우 -->
						<div class="col">ID</div>
						<div class="col-10">
							<input name="member_id" type="text" class="form-control">
						</div>
					</div>
					<div class="row mt-2"><!-- PW 로우 -->
						<div class="col">PW</div>
						<div class="col-10">
							<input name="member_pw" type="password" class="form-control">
						</div>
					</div>
					<div class="row mt-4"><!-- 로그인버튼 로우 -->
						<div class="col d-grid">
							<input type="submit" value="로그인" class="btn btn-primary">
						</div>
					</div>
					</form>
					<div class="row mt-2"><!-- 회원 가입 링크 -->
						<div class="col">
							<a href="./joinMemberPage.do">회원 가입</a>
						</div>
					</div>
				</div>
				<div class="col"></div>
			</div>
		</div>
	</div>
	
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>