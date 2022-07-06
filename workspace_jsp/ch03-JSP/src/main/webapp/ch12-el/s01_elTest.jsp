<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
<table border="1" style="width:40%;">
	<tr>
		<th>표현식</th>
		<th>값</th>
	</tr>
	<tr>
		<td>\${2 + 5}</td>
		<td>${2 + 5}</td>
	</tr>
	<tr>
		<td>\${"10" + 5 }</td> <!-- 문자 + 숫자 형태도 숫자로 판단 -->
		<td>${"10" + 5 }</td> <!-- 15 -->
	</tr>
	<tr>
		<td>\${"10" + "5" }</td> <!-- 문자 + 문자 형태도 숫자로 판단 -->
		<td>${"10" + "5" }</td> <!-- 15 -->
	</tr>
	<tr>
		<td>\${"십" + "5" }</td>
		<td>에러발생(EL에서 +는 연산만 가능)</td>
	</tr>
	<tr>
		<td>\${4/5 }</td>
		<td>${4/5 }</td> <!-- 0.8 -->
	</tr>
	<tr>
		<td>\${2+=5}</td> <!-- 2와5를 연결함 -->
		<td>${2+=5}(문자열)</td> <!-- 25 -->
	</tr>
	<tr>
		<td>\${"한국"+="서울" }</td> <!-- 완전한 문자여도 +만 하면 에러발생 -->
		<td>${"한국"+="서울" }</td> <!-- 한국서울 -->
	</tr>
	<!-- EL로는 연산 하지 않는 것 추천, 출력만 하라 -->
</table>
</body>
</html>