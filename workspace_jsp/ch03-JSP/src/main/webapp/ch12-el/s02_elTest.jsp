<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//전송된 데이터 인코딩 처리
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
<h3>EL - 파라미터값 처리</h3>
<form action="s02_elTest.jsp" method="post">
	이름 <input type="text" name="name">
	<input type="submit" value="확인">
</form>
<br>
이름은 <%= request.getParameter("name") %><br> <!-- 파라미터가 없으면 null로 표현 -->
이름은 ${param.name } <!-- 파라미터가 없으면 공백으로 표현 -->
</body>
</html>