<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 처리</title>
</head>
<body>
<!-- 
[출력예시]
이름 : 홍길동
ID : dragon
비밀번호 : 1234
전화번호 : 010-1234-4321
취미 : 영화감상,등산
자기소개 :
 -->
 이름 : <%= request.getParameter("name") %><br>
 ID : <%= request.getParameter("id") %><br>
 비밀번호 : <%= request.getParameter("password") %><br>
 전화번호 : <%= request.getParameter("phone") %><br>
  취미 : 
 <%
 	String[] hobbies = request.getParameterValues("hobby");
 	for(int i=0;i<hobbies.length;i++){
 		out.print(hobbies[i]);
 		if(i<(hobbies.length-1)) out.println(","); 
 	}
 %>
 <br>
 
 자기소개 : <%= request.getParameter("content") %>
 
</body>
</html>