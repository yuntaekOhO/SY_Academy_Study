package kr.s06.poly;

//부모 클래스
class Car{
	String color;
	int door;
	
	public void drive() {
		System.out.println("주행하다");
	}
	public void stop() {
		System.out.println("정지하다");
	}
	public void getPower() {
		System.out.println("보통 자동차!!");
	}
}
//자식 클래스
class FireEngine extends Car{
	public void getWater() {
		System.out.println("물을 뿌리다!!");
	}
	@Override
	public void getPower() {
		System.out.println("소방설비를 갖춘 자동차!!");
	}
}
public class PolyMain04 {

	public static void main(String[] args) {
		FireEngine fe = new FireEngine();
		fe.drive();
		fe.stop();
		fe.getWater();
		fe.getPower();
		System.out.println("-----------------------");
		
		Car c = fe;// 업캐스팅, 자식클래스타입 -> 부모클래스타입 
		c.drive();
		c.stop();
		//c.getWater(); 호출 범위를 벗어나서 호출 불가능
		c.getPower();
		
	}

}
