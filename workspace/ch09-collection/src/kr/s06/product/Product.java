package kr.s06.product;

public class Product {
	/*
	 * [실습]
	 * 멤버변수: private 상품명(name), int 상품가격(price), String 상품식별번호(num),
	 * 			메이커(maker), int stock(재고수)
	 * 멤버메서드 : 상품명,상품가격,상품식별번호,메이커,재고수 get/set
	 */
	private String name;
	private int price;
	private String num;
	private String maker;
	private int stock;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
}
