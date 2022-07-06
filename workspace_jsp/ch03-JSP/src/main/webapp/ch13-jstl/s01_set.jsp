<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.web.member.MemberInfoVO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>set 태그</title>
</head>
<body>
<%--       속성명       속성값       영역 --%>
<c:set var="msg" value="봄" scope="page"/>
${pageScope.msg }, ${msg }<br>

<%
	MemberInfoVO member = new MemberInfoVO();
%>
<c:set var="member" value="<%=member %>"/> <!-- scope 속성 명시하지 않을시 default는 page -->
<%-- page영역에 저장된 MemberInfoVO의 프로퍼티(name)에 데이터(홍길동) 저장 --%>
<c:set target="${member}" property="name" value="홍길동"/> <!-- setName("홍길동")의 효과 -->
회원 이름 : ${member.name}<br> <!-- 권장 : 하위버전에서의 호환위해 -->
회원 이름 : ${member.getName()}
</body>
</html>