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

public class WriteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String,String> mapAjax = new HashMap<String,String>();
		
		HttpSession session = request.getSession();
		Integer user_num = (Integer)session.getAttribute("user_num");
		if(user_num==null) {//로그인 안된 경우
			mapAjax.put("result", "logout");
		}else {//로그인 된 경우
			CartVO cart = new CartVO();
			cart.setItem_num(Integer.parseInt(request.getParameter("item_num")));
			cart.setOrder_quantity(Integer.parseInt(request.getParameter("order_quantity")));
			cart.setMem_num(user_num);
			
			CartDAO dao = CartDAO.getInstance();
			CartVO cartItem = dao.getCart(cart);
			if(cartItem==null) {//로그인한 회원번호로 등록한 상품이 없음
				dao.insertCart(cart);
				mapAjax.put("result", "success");
			}else {//로그인한 회원번호로 등록한 상품이 있음
				//재고량 구하기 위해서 ItemDAO 호출
				ItemDAO itemDao = ItemDAO.getInstance();
				ItemVO item = itemDao.getItem(cartItem.getItem_num());
				
				//구매 수량 합산 (기존 구매 수량 + 새로 입력한 구매 수량)
				int order_quantity = cartItem.getOrder_quantity() + cart.getOrder_quantity();
				
				if(item.getQuantity()<order_quantity) {
					//상품 재고 수량보다 장바구니에 담은 구매 수량이 더 많음
					mapAjax.put("result", "overquantity");
				}else {
					//상품 재고 수량과 구매 수량이 일치하거나 구매 수량이 적을 때
					cart.setOrder_quantity(order_quantity);
					dao.updateCartByItem_num(cart);
					mapAjax.put("result", "success");
				}
			}
		}
		
		//JSON 데이터 생성
		ObjectMapper mapper = new ObjectMapper();
		String ajaxData = mapper.writeValueAsString(mapAjax);
		
		request.setAttribute("ajaxData", ajaxData);
		
		return "/WEB-INF/views/common/ajax_view.jsp";
	}

}
