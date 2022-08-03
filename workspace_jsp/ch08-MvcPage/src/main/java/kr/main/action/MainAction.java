package kr.main.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.board.dao.BoardDAO;
import kr.board.vo.BoardVO;
import kr.controller.Action;
import kr.item.dao.ItemDAO;
import kr.item.vo.ItemVO;

public class MainAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ItemDAO itemDao = ItemDAO.getInstance();
		List<ItemVO> itemList = 
				itemDao.getListItem(1, 16, null, null, 1);//표시 상품만 반환
		
		BoardDAO boardDao = BoardDAO.getInstance();
		List<BoardVO> boardList = boardDao.getListBoard(1, 8, null, null);
		
		request.setAttribute("itemList", itemList);
		request.setAttribute("boardList", boardList);
		
		return "/WEB-INF/views/main/main.jsp";
	}

}
