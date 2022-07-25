package kr.board.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;

import kr.board.dao.BoardDAO;
import kr.board.vo.BoardFavVO;
import kr.controller.Action;

public class GetFavAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//전송된 데이터 인코딩 처리
		request.setCharacterEncoding("utf-8");
		//전송도니 데이터 반환
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		
		Map<String,Object> mapAjax = new HashMap<String,Object>();
		HttpSession session = request.getSession();
		Integer user_num = (Integer)session.getAttribute("user_num");
		BoardDAO dao = BoardDAO.getInstance();
		if(user_num==null) {//로그인이 되지 않은 상태
			mapAjax.put("status", "noFav");
			mapAjax.put("count", dao.selectFavCount(board_num));
		}else {//로그인이 된 상태
			//로그인된 아이디 세팅
			BoardFavVO boardFav = dao.selectFav(board_num, user_num);
			if(boardFav!=null) {//좋아요 누른 상태
				mapAjax.put("status", "yesFav");
				mapAjax.put("count", dao.selectFavCount(board_num));
			}else {//좋아요 안누른 상태
				mapAjax.put("status", "noFav");
				mapAjax.put("count", dao.selectFavCount(board_num));
			}
		}
		
		//JSON 데이터 생성
		ObjectMapper mapper = new ObjectMapper();
		String ajaxData = mapper.writeValueAsString(mapAjax);
		
		request.setAttribute("ajaxData", ajaxData);
		
		return "/WEB-INF/views/common/ajax_view.jsp";
	}

}
