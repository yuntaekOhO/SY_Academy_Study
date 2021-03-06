<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--/lib/cos.jar --%>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="java.io.File" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 처리</title>
</head>
<body>
<%
	//파일 업로드 경로
	String saveFolder = "/upload";
	String encType = "UTF-8";//인코딩 타입
	int maxSize = 5*1024*1024;//파일의 최대 업로드 사이즈, 5MB
	
	//파일 업로드 절대 경로 구하기
	String realFolder = application.getRealPath(saveFolder);
	
	out.println("파일 업로드 절대 경로 : " + realFolder + "<br>");
	out.println("----------------------------------------------<br>");
	try{
												//			  upload절대경로
		MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType,
								//이미 업로드된 파일과 동일한 파일명일 경우 파일명 교체	(파일명 뒤에 숫자 붙임)	
								new DefaultFileRenamePolicy()
										);
		out.println("작성자 : " + multi.getParameter("user") + "<br>");
		out.println("제목 : " + multi.getParameter("title") + "<br>");
		
		//파일 정보처리
		//전송전 원래의 파일 이름
		String original = multi.getOriginalFileName("uploadFile");
		
		//서버에 저장된 파일 이름 : DefaultFileRenamePolicy()로 인해 이미 서버에 
		//원래 파일이름이 있다면 뒤에 1,2,3..을 붙혀서 새로 저장함
		String filename = multi.getFilesystemName("uploadFile");
		
		//전송된 파일의 컨텐트 타입
		String type = multi.getContentType("uploadFile");
		
		out.println("전송전 원래의 파일 이름 : " + original + "<br>");
		out.println("서버에 저장된 파일 이름 : " + filename + "<br>");
		out.println("컨텐트 타입 : " + type + "<br>");
		
		//파일의 용량 구하기
		File file = multi.getFile("uploadFile");
		if(file!=null){
			out.println("파일 용량 : " + file.length() + "bytes");
		}
	}catch(Exception e){
		e.printStackTrace();
	}
%>
</body>
</html>