<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1부터 100까지의 합</title>
</head>
<body>
<h1>1부터 100까지의 합</h1>
<% //스크립트릿 : 자바코드를 실행 - 변수 선언, 연산, 제어문 사용, 출력 등
	int total = 0;
	for(int i=0;i<=100;i++){
		//누적
		total += i;
	}
	//출력
	out.println("1부터 100까지의 합은 " + total);
%>
</body>
</html>