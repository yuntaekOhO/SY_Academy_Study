<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%
	Date time = new Date();
	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 정보</title>
</head>
<body>
세션 ID : <%= session.getId() %><br>
세션 생성 시간 : <%= session.getCreationTime() %> <br> <!-- long 타입 반환 -->
<%
	time.setTime(session.getCreationTime());
%>
세션 생성 시간 : <%= sf.format(time) %><br>
최근접근시간 : <%= session.getLastAccessedTime() %><br> <!-- long 타입 반환 -->
<%
	time.setTime(session.getLastAccessedTime());
%>
최근접근시간 : <%= sf.format(time) %><br>

세션유지시간 변경하기(기본 세션 유지 시간은 30분임)<br>
<%
	session.setMaxInactiveInterval(20*60);
	//web.xml에 50분으로 지정된 상태임(jsp에서 세팅한 정보가 현재 세션에 우선 반영됨)
%>

세션 유지시간 : <%= session.getMaxInactiveInterval() %>초
</body>
</html>