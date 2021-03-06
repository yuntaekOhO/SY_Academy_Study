<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 다중 업로드 처리</title>
</head>
<body>
<%
	String saveFolder = "/upload"; //파일 업로드경로
	String encType = "utf-8";//인코딩 타입
	int maxSize = 10*1024*1024;//최대 업로드 파일 크기 10MB
	
	//upload 절대 경로
	String realFolder = application.getRealPath(saveFolder);
	out.println("파일 업로드 절대 경로 : " + realFolder + "<br>");
	
	MultipartRequest multi = new MultipartRequest(request,realFolder,maxSize,encType,
							new DefaultFileRenamePolicy());
	
	out.println("이름 : " + multi.getParameter("name") + "<br>");
	out.println("제목 : " + multi.getParameter("title") + "<br>");
	
	String img1 = multi.getFilesystemName("uploadFile1");
	String img2 = multi.getFilesystemName("uploadFile2");
%>
	<img src="/ch03-JSP/upload/<%= img1 %>"><br>
	<img src="/ch03-JSP/upload/<%= img2 %>"><br>
</body>
</html>