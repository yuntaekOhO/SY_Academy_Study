<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.board.dao.BoardDAO" %>
<%@ page import="kr.board.vo.BoardVO" %>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	BoardDAO dao = BoardDAO.getInstance();
	BoardVO board = dao.getBoard(num);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/board.js"></script>
</head>
<body>
<div class="page-main">
	<h1>글수정</h1>
	<form id="write_form" action="update.jsp" method="post">
		<input type="hidden" name="num" value="<%=num %>">
		<ul>
			<li>
				<label for="title">제목</label>
				<input type="text" name="title" id="title" size="30" value="<%=board.getTitle() %>" maxlength="50">
			</li>
			<li>
				<label for="name">이름</label>
				<input type="text" name="name" id="name" size="10" value="<%=board.getName() %>" maxlength="10">
			</li>
			<li>
				<label for="passwd">비밀번호</label>
				<input type="password" name="passwd" id="passwd" size="10" maxlength="12">
				*등록시 입력한 비밀번호
			</li>
			<li>
				<label for="content">내용</label>
				<textarea rows="5" cols="40" name="content" id="content"><%=board.getContent() %></textarea>
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="글수정">
			<input type="button" value="목록" onclick="location.href='list.jsp'">
		</div>
	</form>
</div>
</body>
</html>