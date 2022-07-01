<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//전송된 데이터 인코딩 처리
	request.setCharacterEncoding("UTF-8");
%>
<%-- 자바빈 객체 생성 --%>
<jsp:useBean id="member" class="kr.web.member.MemberVO"/>

<%-- 생성된 자바빈 객체에 전송된 데이터 저장 --%>
<%-- 
name="member" : 자바빈 식별자
property="*" : 모든 프로퍼티 = 모든 멤버 변수
<jsp:setProperty>는 request로 전송된 데이터를 자바빈의 프로퍼티에 자동으로 할당해준다
	(전제조건 : 파라미터 name과 프로퍼티 name이 같아야 자동 매치)
--%>
<jsp:setProperty name="member" property="*"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 처리</title>
</head>
<body>
아이디 : <jsp:getProperty property="id" name="member"/><br>
비밀번호 : <jsp:getProperty property="password" name="member"/><br>
이름 : <jsp:getProperty property="name" name="member"/><br>
이메일 : <jsp:getProperty property="email" name="member"/><br>
주소 : <jsp:getProperty property="address" name="member"/>
</body>
</html>