package kr.s07.instanceoftest;

class Car{
	public void drive() {
		System.out.println("주행하다");
	}
	public void stop() {
		System.out.println("정지하다");
	}
}
class FireEngine extends Car{
	public void getWater() {
		System.out.println("물을 뿌리다");
	}
}
public class InstanceofMain02 {

	public static void main(String[] args) {
		FireEngine fe = new FireEngine();
		// 객체               타입
		if(fe instanceof FireEngine) {
			System.out.println("This is a FireEngine Instance");
		}
		
		if(fe instanceof Car) {
			System.out.println("This is a Car Instance");
		}
		
		if(fe instanceof Object) {
			System.out.println("This is an Object Instance");
		}
		System.out.println("-----------------------------------");
		
		Car car = new Car();
		
		//Car는 FireEngine 타입을 사용할 수 없음
		if(car instanceof FireEngine) {
			System.out.println("This is a FireEngine Instance");
		}
		
		if(car instanceof Car) {
			System.out.println("This is a Car Instance");
		}
		
		if(car instanceof Object) {
			System.out.println("This is an Object Instance");
		}
		
	}

}
