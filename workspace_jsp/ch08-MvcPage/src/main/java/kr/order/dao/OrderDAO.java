package kr.order.dao;

public class OrderDAO {
	private static OrderDAO instance = new OrderDAO();
	
	public static OrderDAO getInstance() {
		return instance;
	}
	
	private OrderDAO() {}
	
	//주문 등록
	//관리자 - 전체 주문 수 / 검색 주문 수
	//관리자 - 전체 주문 정보/검색 주문 정보
	//사용자 - 전체 주문 수 / 검색 주문 수
	//사용자 - 전체 주문 정보/검색 주문 정보
	//개별 상품 목록
	//주문 삭제(삭제시 재고를 원상 복귀시키지 않고 주문 취소 일 때 원상 복귀)
	//관리자/사용자 주문 상세
	//주문 수정
	
	
}
