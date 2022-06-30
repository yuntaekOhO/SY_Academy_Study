<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예외 발생</title>
</head>
<body>
요청 처리 과정에서 예외가 발생했습니다.
빠른 시간 내에 문제를 해결하다록 하겠습니다.
<p>
에러 타입 : <%= exception.getClass().getName() %><br>
에러 메시지 : <%= exception.getMessage() %>
</p>
</body>
</html>