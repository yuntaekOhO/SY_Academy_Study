package kr.s06.poly;

//부모클래스
class Product{
	int price;// 제품의 가격
	int bonusPoint;// 제품 구매시 제공하는 보너스점수
	
	public Product(int price) {
		this.price = price;
		bonusPoint = price / 10;// 보너스점수는 제품가격의 10%
	}
	
	public String getName() {
		return "제품";
	}
	
}
//자식클래스
class Tv extends Product{

	public Tv() {
		super(100);
	}
	@Override
	public String getName() {
		return "Tv";
	}
}
//자식클래스
class Computer extends Product{

	public Computer() {
		super(200);
	}
	@Override
	public String getName() {
		return "Computer";
	}
}
class Audio extends Product{

	public Audio() {
		super(300);
	}
	@Override
	public String getName() {
		return "Audio";
	}
	
}
class Buyer{
	private int money = 1000;
	private int bonusPoint = 0;
	
	//구매하기
	public void buy(Product p) {
		if(money < p.price) {
			System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
			return;
		}
		
		// 보유하고 있는 돈에서 구입한 제품의 가격을 차감
		money -= p.price;
		// 보너스점수 추가
		bonusPoint += p.bonusPoint;
		
		System.out.println(p.getName() + "을/를 구입하셨습니다.");
		System.out.println("현재 남은 돈은 " + money + "만원입니다.");
		System.out.println("현재 보너스점수는 " + bonusPoint + "점 입니다.");
		
	}
	
}
public class PolyMain05 {

	public static void main(String[] args) {
		Buyer b = new Buyer();
		Tv tv = new Tv();
		Computer com = new Computer();
		Audio au = new Audio();
		//구매하기
		b.buy(tv); // Tv -> Product 형변환
		b.buy(com); // Computer -> Product 형변환
		b.buy(au);// Audio -> Product 형변환
		
	}

}
