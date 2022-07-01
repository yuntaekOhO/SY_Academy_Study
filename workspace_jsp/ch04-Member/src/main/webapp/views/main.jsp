<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리 메인</title>   <%-- /ch04-Member - 컨텍스트 경로 (아래 방법을 권장) --%>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css" type="text/css">
</head>
<body>
<%
	String user_id = (String)session.getAttribute("user_id");
%>
<div class="page-main">
	<h1>회원관리 메인</h1>
	<div class="align-right">
		<%
			if(user_id == null){ //로그인되지 않은 상태
		%>
				<a href="registerUserForm.jsp">회원가입</a>
				<a href="loginForm.jsp">로그인</a>
		<%
			}else{ //로그인된 경우
		%>
				<a href="myPage.jsp">MyPage</a>
				[<b><%=user_id %></b>님 로그인 중]
				<a href="logout.jsp">로그아웃</a>
		<%
			}
		%>
	</div>
</div>
</body>
</html>