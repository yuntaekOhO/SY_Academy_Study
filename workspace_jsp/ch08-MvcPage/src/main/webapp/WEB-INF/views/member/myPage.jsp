<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MY페이지</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/member.js"></script>
</head>
<body>
<div class="page-main">
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<div class="content-main">
		<h2>회원정보</h2>
		<div class="mypage-div">
			<h3>프로필 사진</h3>
			<ul>
				<li>
					<%--DB상 photo에 저장된 데이터 없는 경우 --%>
					<c:if test="${empty member.photo}">
					<img alt="기본이미지" src="${pageContext.request.contextPath}/images/face.png" width="200" height="200" class="my-photo">
					</c:if>
					<%--DB상 photo에 저장된 데이터 있는 경우 --%>
					<c:if test="${!empty member.photo}">
					<img alt="사용자저장이미지" src="${pageContext.request.contextPath}/upload/${member.photo}" width="200" height="200" class="my-photo">
					</c:if>
				</li>
				<li>
					<div class="align-center">
						<input type="button" value="수정" id="photo_btn">
					</div>
					<div id="photo_choice" style="display:none;"> <!-- 위 수정버튼을 누르면 보여지게 member.js에서 처리 -->
						<input type="file" id="photo" accept="image/gif,image/png,image/jpeg">
						<input type="button" value="전송" id="photo_submit">
						<input type="button" value="취소" id="photo_reset">
					</div>
				</li>
			</ul>
			<h3>비밀번호 수정</h3>
			<ul>
				<li>
					<input type="button" value="비밀번호 수정" onclick="location.href='modifyPasswordForm.do'">
				</li>
			</ul>
			<h3>회원탈퇴</h3>
			<ul>
				<li>
					<input type="button" value="회원탈퇴" onclick="location.href='deleteUserForm.do'">
				</li>
			</ul>
		</div>
		<div class="mypage-div">
			<h3>연락처</h3>
			<ul>
				<li>이름 : ${member.name}</li>
				<li>전화번호 : ${member.phone}</li>
				<li>이메일 : ${member.email}</li>
				<li>우편번호 : ${member.zipcode}</li>
				<li>주소 : ${member.address1} ${member.address2}</li>
				<li>가입일 : ${member.reg_date}</li>
				<c:if test="${!empty member.modify_date}">
				<li>최근 정보 수정일 : ${member.modify_date}</li>
				</c:if>
				<li>
					<input type="button" value="연락처 수정" onclick="location.href='modifyUserForm.do'">
				</li>
			</ul>
			<h3>관심(좋아요) 게시물 목록</h3>
			<table>
				<tr>
					<th>제목</th>
					<th>작성자</th>
					<th>등록일</th>
				</tr>
				<c:forEach var="board" items="${boardList}">
				<tr><%-- target="_blank" : 새 탭으로 열기 --%>
					<td><a href="${pageContext.request.contextPath}/board/detail.do?board_num=${board.board_num}" target="_blank">${fn:substring(board.title,0,12)}</a></td>
					<td>${board.id}</td>
					<td>${board.reg_date}</td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<div class="mypage-end"></div>
	</div>
</div>
</body>
</html>