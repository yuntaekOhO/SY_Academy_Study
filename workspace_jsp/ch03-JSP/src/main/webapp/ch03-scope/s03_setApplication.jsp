<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>application 속성 지정</title>
</head>
<body>
<%
String name = "id";
String value = "dragon";

//application 기본 객체에 데이터 저장
application.setAttribute(name, value);
%>

application 기본 객체 속성 설정:
<%= name %> = <%= value %>

</body>
</html>