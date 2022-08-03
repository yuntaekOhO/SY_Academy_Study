package kr.cart.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;

import kr.cart.dao.CartDAO;
import kr.cart.vo.CartVO;
import kr.controller.Action;
import kr.item.dao.ItemDAO;
import kr.item.vo.ItemVO;

public class ModifyCartAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String,String> mapAjax = new HashMap<String,String>();
		
		HttpSession session = request.getSession();
		Integer user_num = (Integer)session.getAttribute("user_num");
		if(user_num == null) {
			mapAjax.put("result", "logout");
		}else {
			request.setCharacterEncoding("utf-8");
			int item_num = Integer.parseInt(request.getParameter("item_num"));
			int item_quantity = Integer.parseInt(request.getParameter("order_quantity"));
			
			//현재 구매하고자 하는 상품의 재고수를 구함
			ItemDAO itemDao = ItemDAO.getInstance();
			ItemVO item = itemDao.getItem(item_num);
			
			if(item.getStatus()==1) {//상품 미표시
				mapAjax.put("result", "noSale");
			}else if(item.getQuantity() < item_quantity) {
				//재고부족
				mapAjax.put("result", "noQuantity");
			}else {//상품 수량 변경가능
				CartVO cart = new CartVO();
				cart.setCart_num(Integer.parseInt(request.getParameter("cart_num")));
				cart.setOrder_quantity(item_quantity);
				
				CartDAO cartDao = CartDAO.getInstance();
				cartDao.updateCart(cart);
				
				mapAjax.put("result", "success");
			}
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String ajaxData = mapper.writeValueAsString(mapAjax);
		
		request.setAttribute("ajaxData", ajaxData);
		
		return "/WEB-INF/views/common/ajax_view.jsp";
	}

}
