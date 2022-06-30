<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- include 디렉티브는 JSP페이지에 또 다른 JSP페이지를 삽입 --%>
<%@ include file="include.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include 디렉티브</title>
</head>
<body>
이미지경로 : <%= img_path%><br>
파일경로 : <%= file_path %>
</body>
</html>