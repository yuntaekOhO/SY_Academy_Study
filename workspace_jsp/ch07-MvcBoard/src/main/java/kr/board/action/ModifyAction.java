package kr.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.board.dao.BoardDAO;
import kr.board.vo.BoardVO;
import kr.controller.Action;

public class ModifyAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//전송된 데이터 인코딩 처리
		request.setCharacterEncoding("utf-8");
		
		//자바빈 생성
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(Integer.parseInt(request.getParameter("num")));
		boardVO.setTitle(request.getParameter("title"));
		boardVO.setName(request.getParameter("name"));
		boardVO.setPasswd(request.getParameter("passwd"));
		boardVO.setEmail(request.getParameter("email"));
		boardVO.setContent(request.getParameter("content"));
		boardVO.setIp(request.getRemoteAddr());
		
		BoardDAO dao = BoardDAO.getInstance();
		//비밀번호 인증을 위해 비교하기위한 DB에 저장된 한 건의 레코드를 자바빈에 담아서 반환 
		BoardVO db_board = dao.getBoard(boardVO.getNum());
		
		boolean check = false;
		
		if(db_board!=null) {
			//비밀번호 일치 여부 체크
			check = db_board.isCheckedPassword(boardVO.getPasswd());
		}
		if(check) {
			dao.update(boardVO);
		}
		
		request.setAttribute("check", check);
		//글수정 후 글상세로 갈 경우 사용
		request.setAttribute("num", boardVO.getNum());
		
		return "/WEB-INF/views/modify.jsp";
	}

}
