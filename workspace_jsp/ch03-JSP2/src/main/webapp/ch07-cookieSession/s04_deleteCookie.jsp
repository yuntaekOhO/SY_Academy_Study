<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 삭제</title>
</head>
<body>
<%
	Cookie[] cookies = request.getCookies();
	if(cookies != null && cookies.length >0){
		for(int i=0;i<cookies.length;i++){
			//쿠키명이 name인 쿠키가 존재하는지 체크
			if(cookies[i].getName().equals("name")){
				Cookie cookie = new Cookie("name","");
				//쿠키 유효시간이 0으로 지정되어 있기 때문에
				//쿠키 정보가 바로 제거됨
				cookie.setMaxAge(0);
				
				//생성된 쿠키를 클라이언트로 전송
				response.addCookie(cookie);
				
				out.println("name 쿠키를 삭제합니다.");
			}
		}
	}else{
		out.println("쿠키가 존재하지 않습니다.");
	}
%>
</body>
</html>