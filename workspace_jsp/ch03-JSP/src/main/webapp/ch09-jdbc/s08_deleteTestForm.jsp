<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글삭제</title>
</head>
<body>
<%
	int num = Integer.parseInt(request.getParameter("num"));
%>
<div class="page-main">
	<h2>글삭제</h2>
	<p class="align-center">
		<span>정말 삭제하시겠습니까?</span>
	</p>
	<form action="s09_deleteTest.jsp" method="post">
		<input type="hidden" name="num" value="<%=num %>">
		<div class="align-center">
			<input type="submit" value="삭제">
			<input type="button" value="목록 보기" onclick="location.href='s02_selectTest.jsp'">
		</div>
	</form>
	
</div>
</body>
</html>