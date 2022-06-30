package kr.s01.list;

import java.util.ArrayList;

class CartItem{
	private String code; // 상품코드
	private int num; // 수량
	private int price; // 단가
	
	public CartItem(String code, int num, int price) {
		this.code = code;
		this.num = num;
		this.price = price;
	}

	public String getCode() {
		return code;
	}

	public int getNum() {
		return num;
	}

	public int getPrice() {
		return price;
	}
	
}
public class ArrayListMain09 {

	public static void main(String[] args) {
		// 2차원 배열 형태를 ArrayList로 구현하기
		ArrayList<CartItem> list = new ArrayList<CartItem>();
		list.add(new CartItem("A1001",2,1000));
		list.add(new CartItem("B1001",1,7000));
		list.add(new CartItem("C1001",3,2500));
		
		System.out.println("상품코드\t수량\t가격");
		System.out.println("-------------------------");
		
		for(CartItem item : list) {
			System.out.printf("%s\t%d\t%,d%n", item.getCode(), item.getNum(), item.getPrice());
		}
		
	}

}
