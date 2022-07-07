<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View</title>
</head>
<body>
<h1>Hello MVC</h1>
MVC 패턴으로 구성된 웹어플리케이션의 view를 담당<br>
결과 : <%= request.getAttribute("result") %><br>
결과 : ${result}

</body>
</html>