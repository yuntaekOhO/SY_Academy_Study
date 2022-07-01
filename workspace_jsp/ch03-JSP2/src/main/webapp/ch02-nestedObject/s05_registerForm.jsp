<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[실습]회원가입</title>
</head>
<body>
<form action="s06_register.jsp" method="post" id="myForm">
	이름 <input type="text" name="name"><br>
	ID <input type="text" name="id"><br>
	비밀번호 <input type="password" name="password"><br>
	전화번호 <input type="text" name="phone"><br>
	취미 
	<input type="checkbox" name="hobby" value="영화보기">영화보기
	<input type="checkbox" name="hobby" value="음악감상">음악감상
	<input type="checkbox" name="hobby" value="등산">등산
	<input type="checkbox" name="hobby" value="낚시">낚시
	<input type="checkbox" name="hobby" value="춤">춤<br>

	자기소개 <textarea rows="4" cols="20" name="content"></textarea><br>
	
	<input type="submit" value="전송">
</form>
</body>
</html>