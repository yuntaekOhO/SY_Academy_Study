<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 출력</title>
</head>
<body>
<% int dan = Integer.parseInt(request.getParameter("dan")); %>
<h3><%= dan %> 단</h3><br>
<hr>
<%
	for(int i=1;i<=9;i++){
		out.print(dan + " * " + i + " = " + (dan*i));
%>
<br>
<%
	}
%>
</body>
</html>