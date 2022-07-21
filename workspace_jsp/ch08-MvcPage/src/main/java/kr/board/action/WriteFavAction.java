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

public class WriteFavAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String,Object> mapAjax = new HashMap<String,Object>();
		HttpSession session = request.getSession();
		Integer user_num = (Integer)session.getAttribute("user_num");
		if(user_num==null) {//로그인 안된경우
			mapAjax.put("result", "logout");
		}else {//로그인 된경우
			//전송된 데이터 인코딩 처리
			request.setCharacterEncoding("utf-8");
			
			int board_num = Integer.parseInt(request.getParameter("board_num"));
			BoardDAO dao = BoardDAO.getInstance();
			BoardFavVO boardFav = dao.selectFav(board_num, user_num);
			if(boardFav!=null) {//좋아요 등록된(눌려있는) 상태
				dao.deleteFav(boardFav.getFav_num());
				
				mapAjax.put("result", "success");
				mapAjax.put("status", "noFav");
				//mapAjax.put("count", dao.selectFavCount(board_num));
			}else {//좋아요 등록되지 않은(안누른) 상태
				dao.insertFav(board_num, user_num);
				
				mapAjax.put("result", "success");
				mapAjax.put("status", "yesFav");
				//mapAjax.put("count", dao.selectFavCount(board_num));
			}
		}
		
		//JSON 데이터 생성
		ObjectMapper mapper = new ObjectMapper();
		String ajaxData = mapper.writeValueAsString(mapAjax);
		
		request.setAttribute("ajaxData", ajaxData);
		
		return "/WEB-INF/views/common/ajax_view.jsp";
	}

}
