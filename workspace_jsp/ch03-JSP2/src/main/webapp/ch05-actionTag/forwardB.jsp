<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포워드 테스트</title>
</head>
<body>
forwardB.jsp 페이지 입니다.
<%
	String color = request.getParameter("color");
%>
request에 파라미터로 전송된 데이터 = <%= color %>
</body>
</html>