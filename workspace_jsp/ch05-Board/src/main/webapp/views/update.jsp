<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.board.dao.BoardDAO" %>
<%@ page import="kr.board.vo.BoardVO" %><%-- db_board 만들려고 import함 --%>
<%
	//전송된 데이터 인코딩 처리
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="boardVO" class="kr.board.vo.BoardVO"/>
<jsp:setProperty property="*" name="boardVO"/>
<%
	BoardDAO dao = BoardDAO.getInstance();
	BoardVO db_board = dao.getBoard(boardVO.getNum());
	boolean check = false;
	if(db_board!=null){
		check = db_board.isCheckedPassword(boardVO.getPasswd());
	}
	
	if(check){
		boardVO.setIp(request.getRemoteAddr());
		dao.update(boardVO);
%>
	<script>
		alert('글수정을 완료했습니다.');
		location.href='detail.jsp?num=<%=boardVO.getNum() %>';
	</script>
<%
	}else{
%>
	<script>
		alert('비밀번호 불일치');
		history.go(-1);
	</script>
<%		
	}
%>
