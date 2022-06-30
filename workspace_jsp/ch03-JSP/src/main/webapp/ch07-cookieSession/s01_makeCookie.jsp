<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 생성</title>
</head>
<body>
<%
	//쿠키 생성
	Cookie cookie = new Cookie("name",URLEncoder.encode("홍길동","UTF-8"));

	//쿠키 유효시간 지정(단위:초)
	//쿠키 유효시간을 지정하면 클라이언트 영역에 파일을 생성해서 쿠키 정보를 보관
	//쿠키 유효시간을 미지정시 메모리에 쿠키 정보 보관 <- 브라우저 종료시 소멸
	//cookie.setMaxAge(30*60);
	//cookie.setMaxAge(-1);//메모리에 쿠키 정보 보관 (명시하지 않았을 경우와 동일)
	
	//생성한 쿠키를 클라이언트에 전송
	response.addCookie(cookie);
%>

<%= cookie.getName()%> 쿠키의 값은 <%= cookie.getValue() %>
</body>
</html>