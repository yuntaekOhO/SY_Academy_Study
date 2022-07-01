<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리다이렉트 테스트</title>
</head>
<body>
현재 페이지는 s09_responseA.jsp 입니다.
본 JSP에 s10_responseB.jsp로 리다이렉트하기 때문에
화면 출력을 하지 않음
</body>
</html>
<%
	response.sendRedirect("s10_responseB.jsp");
%>