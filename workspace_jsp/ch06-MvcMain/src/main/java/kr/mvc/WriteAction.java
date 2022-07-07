package kr.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//request에 데이터 저장
		request.setAttribute("msg", "게시판에 글 작성 완료!!");
		
		return "/views/write.jsp";
	}

}
