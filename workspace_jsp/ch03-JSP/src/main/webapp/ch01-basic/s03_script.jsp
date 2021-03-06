<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립트</title>
</head>
<body>
<h2>배열의 내용 출력 - 선언부,스크립트릿</h2>
<%! 
	//선언부 : 변수 선언, 메서드 정의
	String[] str = {"JSP가","정말","재미","있다"};
%>
<table border="1">
	<tr>
		<th>배열의 인덱스</th>
		<th>배열의 내용</th>
	</tr>
<%
	//스크립트릿 : 변수 선언, 연산, 제어문, out.println() 메서드를 이용한 출력
	for(int i=0;i<str.length;i++){
		out.println("<tr>");
		out.println("	<td>" + i + "</td>");
		out.println("	<td>" + str[i] + "</td>");
		out.println("</tr>");
	}
%>
</table>
<br>
<h2>배열의 내용 출력 - 선언부,스크립트릿,표현식</h2>
<table border="1">
	<tr>
		<th>배열의 인덱스</th>
		<th>배열의 내용</th>
	</tr>
<%
	for(int i=0;i<str.length;i++){
%>
	<tr>
		<td><%= i %></td>
		<td><%= str[i] %></td>
	</tr>
<%	
	}
%>
</table>
<br>
<h2>배열의 내용 출력 - 확장 for문 사용</h2>
<table border="1">
	<tr>
		<th>배열의 내용</th>
	</tr>
<%
	for(String s : str) {
%>
	<tr>
		<!-- HTML 주석 : 브라우저 소스에서 볼 수 있다 -->
		<%-- JSP 주석 : 브라우저 소스에서 볼 수 없다--%>
		<%-- 표현식 : 변수의 값 출력, 메서드의 반환값을 출력, 연산의 결과값 출력 --%>
		<td><%= s /*표현식 주석은 여러줄 주석 사용가능, 한줄 주석은 오류*/ %></td>
	</tr>
<%
	}
%>
</table>
</body>
</html>