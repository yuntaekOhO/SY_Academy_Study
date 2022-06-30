<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인/로그아웃 여부 체크</title>
</head>
<body>
<%
	String user_id = (String)session.getAttribute("user_id");
	if(user_id!=null){
%>
	아이디[<%=user_id %>]로 로그인 한 상태!
	<br>
	<input type="button" value="로그아웃" onclick="location.href='s09_sessionLogout.jsp'">
<%		
	}else{ //로그인이 되지 않은 경우
%>
	로그인 하지 않은 상태
	<br>
	<input type="button" value="로그인" onclick="location.href='s06_sessionLoginForm.jsp'">
<% 	} %>
</body>
</html>