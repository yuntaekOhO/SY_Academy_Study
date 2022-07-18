<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보(관리자 전용)</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
</head>
<body>
<div class="page-main">
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<div class="content-main">
		<h2>${member.id}의 회원정보 (관리자 전용)</h2>
		<form action="detailUser.do" method="post" id="detail_form">
			<%-- 현재 로그인은 관리자가 한것이기 때문에 세션에서 mem_num을 구하지 않고 아래의 방식으로 구함 --%>
			<input type="hidden" name="mem_num" value="${member.mem_num}">
			<ul>
				<li>
					<label>등급</label>
					<c:if test="${member.auth !=3}">
					<input type="radio" name="auth" value="1" id="auth1" 
							<c:if test="${member.auth==1}">checked</c:if> />정지
					<input type="radio" name="auth" value="2" id="auth2" 
							<c:if test="${member.auth==2}">checked</c:if> />일반
					</c:if>
					<c:if test="${member.auth == 3}">
					<input type="radio" name="auth" value="3" id="auth3" checked>관리
					</c:if>
				</li>
			</ul>
			<div class="align-center">
				<input type="submit" value="수정">
				<input type="button" value="목록" onclick="location.href='memberList.do'">
			</div>
			<ul>
				<li>
					<label>이름</label>${member.name}
				</li>
				<li>
					<label>전화번호</label>${member.phone}
				</li>
				<li>
					<label>이메일</label>${member.email}
				</li>
				<li>
					<label>우편번호</label>${member.zipcode}
				</li>
				<li>
					<label>주소</label>${member.address1} ${member.address2}
				</li>
			</ul>
		</form>
	</div>
</div>
</body>
</html>