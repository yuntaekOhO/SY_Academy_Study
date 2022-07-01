<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	//선언부 : 변수선언, 메서드정의 , 거의 사용안함 메서드 재활용 불가
	public int multiply(int a, int b){
		return a * b;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선언부를 사용한 두 정수값의 곱</title>
</head>
<body>
	10 * 25 = <%= multiply(10,25) %>
</body>
</html>