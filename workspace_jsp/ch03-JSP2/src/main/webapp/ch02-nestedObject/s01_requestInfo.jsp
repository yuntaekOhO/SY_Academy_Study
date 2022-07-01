<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>클라이언트 및 서버 정보</title>
</head>
<body>
클라이언트 IP = <%= request.getRemoteAddr() %><br>
요청정보 프로토콜 = <%= request.getProtocol() %><br>
<!-- GET / POST -->
요청정보 전송방식 = <%= request.getMethod() %><br>
<!-- 전체주소 : 서버 밖에서 요청할때 사용, 프로토콜부터 현재 페이지까지-->
요청 URL(Uniform Resource Locator) = <%= request.getRequestURL() %><br>
<!-- Context(프로젝트)명부터 현재 페이지까지의 주소, 같은 서버내에서 요청할때 사용-->
요청 URI(Uniform Resource Identifier) = <%= request.getRequestURI() %><br>
<!-- /컨텍스트 경로 , /프로젝트이름 -->
컨텍스트 경로 = <%= request.getContextPath()%> <br>

쿼리 문자열 = <%= request.getQueryString() %><br>
서버 이름 = <%= request.getServerName()%><br>
서버 포트 = <%= request.getServerPort() %>
</body>
</html>