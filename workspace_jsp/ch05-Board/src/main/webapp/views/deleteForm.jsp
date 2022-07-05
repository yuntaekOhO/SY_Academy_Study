<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//전송된 데이터 반환
	int num = Integer.parseInt(request.getParameter("num"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글삭제</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/board_delete.js"></script>
</head>
<body>
<div class="page-main">
	<h1>글삭제</h1>
	<form id="delete_form" action="delete.jsp" method="post">
		<input type="hidden" name="num" value="<%=num %>">
		<ul>
			<li>
				<label for="passwd">비밀번호</label>
				<input type="password" name="passwd" id="passwd" size="12" maxlength="12">
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="글삭제">
			<input type="button" value="목록보기" onclick="location.href='list.jsp'">
		</div>
	</form>
</div>
</body>
</html>