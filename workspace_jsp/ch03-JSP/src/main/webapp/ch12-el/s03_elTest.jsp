<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL - 기본 객체</title>
</head>
<body>
<%
	String str = "여행";

	//JSP 4개 영역에 데이터 저장
	pageContext.setAttribute("msg1", "봄");
	request.setAttribute("msg2", "여름");
	session.setAttribute("msg3", "가을");
	application.setAttribute("msg4", "겨울");
%>
<!-- 주의사항 : EL의 4가지 scope은 불러오기(get)만 가능하다 -->
<!-- scope 생략 가능하다 : 속성명만으로 사용가능
	 scope 생략시 scope 검색 순서 : page -> request -> session -> application -->

str : <%= str %><br>
str(el) : ${str}<br> <!-- 사용 불가 : 스크립트릿에서 setAttribute("str",str)로 넣어줘야 사용가능 -->
page scope(영역) : ${pageScope.msg1}, ${msg1 }<br>
request scope(영역) : ${requestScope.msg2}, ${msg2 }<br>
session scope(영역) : ${sessionScope.msg3}, ${msg3 }<br>
application scope(영역) : ${applicationScope.msg4}, ${msg4 }
</body>
</html>