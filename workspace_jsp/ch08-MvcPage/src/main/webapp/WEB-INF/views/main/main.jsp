<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
</head>
<body>
<div class="page-main">
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<div class="content-main">
		<h4>게시판 최신글</h4>
		<div class="board-space">
			<c:forEach var="board" items="${boardList}">
			<div class="horizontal-area">
				<a href="${pageContext.request.contextPath}/board/detail.do?board_num=${board.board_num}">
				<c:if test="${!empty board.filename}">
				<img class="board-image" src="${pageContext.request.contextPath}/upload/${board.filename}">
				</c:if>
				<c:if test="${empty board.filename}">
				<img class="board-image" src="${pageContext.request.contextPath}/images/blank.png">
				</c:if>
				<span>${fn:substring(board.title,0,12)}</span>
				</a>
				<div class="board-detail">
					<c:if test="${!empty board.photo}">
					<img src="${pageContext.request.contextPath}/upload/${board.photo}" width="25" height="25" 
																								class="my-photo">
					</c:if>
					<c:if test="${empty board.photo}">
					<img src="${pageContext.request.contextPath}/images/blank.png" width="25" height="25" class="my-photo">
					</c:if>
					<span>${board.id}</span>
				</div>
			</div>
			</c:forEach>
			<div class="float-clear">
				<hr width="100%" size="1" noshade="noshade">
			</div>
		</div>
	</div>
</div>
</body>
</html>