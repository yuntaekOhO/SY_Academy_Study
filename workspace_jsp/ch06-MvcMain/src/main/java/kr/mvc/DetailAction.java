package kr.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DetailAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//request에 데이터 저장
		request.setAttribute("detail", "상세페이지 입니다.");
		
		//jsp 경로 반환
		return "/views/detail.jsp";
	}

}
