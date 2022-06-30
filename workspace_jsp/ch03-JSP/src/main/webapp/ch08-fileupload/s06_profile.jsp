<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로필 사진 업로드 처리</title>
</head>
<body>
<%
	String saveFolder = "/upload";//파일 업로드 경로
	String encType = "UTF-8"; //인코딩 타입
	int maxSize = 5*1024*1024; //최대 업로드 파일 크기 5MB
	//upload 절대경로
	String realFolder = application.getRealPath(saveFolder);
	
	MultipartRequest multi = new MultipartRequest(request,realFolder,maxSize,encType,
													new DefaultFileRenamePolicy());
	
	String file = multi.getFilesystemName("file");
%>
<img src="/ch03-JSP/upload/<%= file %>">
</body>
</html>