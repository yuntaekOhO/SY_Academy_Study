package kr.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.member.dao.MemberDAO;
import kr.member.vo.MemberVO;

public class MyPageAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Integer user_num = (Integer)session.getAttribute("user_num");
		
		if(user_num==null) {//로그인 안한 경우
			return "redirect:/member/loginForm.do";
		}
		
		//로그인 된 경우
		MemberDAO dao = MemberDAO.getInstance();
		//로그인이 된 경우 세션에 user_num이 저장되어있다
		//user_num을 식별자로 사용해 멤버의 데이터를 불러와 request Attribute에 저장
		MemberVO member = dao.getMember(user_num);
		request.setAttribute("member", member);
		
		return "/WEB-INF/views/member/myPage.jsp";
	}

}
