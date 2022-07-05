<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.board.dao.BoardDAO"%>
<%@ page import="kr.board.vo.BoardVO"%>
<%
	//전송된 데이터 인코딩처리
	request.setCharacterEncoding("utf-8");
	
	int num = Integer.parseInt(request.getParameter("num"));
	String passwd = request.getParameter("passwd");
	
	BoardDAO dao = BoardDAO.getInstance();
	BoardVO db_board = dao.getBoard(num);
	boolean check = false;
	if(db_board!=null){
		check = db_board.isCheckedPassword(passwd);
	}
	
	if(check){//비밀번호 일치
		dao.delete(num);
%>
	<script>
		alert('글삭제를 완료했습니다.');
		location.href='list.jsp';	
	</script>
<%
	}else{//불일치
%>
	<script>
		alert('비밀번호 불일치');
		history.go(-1);
	</script>
<%
	}
%>