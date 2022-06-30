package kr.s10.abstractex;

//추상클래스
abstract class Car {
	protected int power;

	// 엔진의 성능을 셋팅하는 추상메서드
	public abstract void decEngine();

	public int getPower() {
		return power;
	}
}

//자식클래스
class Truck extends Car {
	// 추상메서드 구현
	@Override
	public void decEngine() {
		power = 100;
	}
}

//자식클래스
class SmallCar extends Car {
	@Override
	public void decEngine() {
		power = 30;
	}
}

public class AbstractMain03 {

	public static void main(String[] args) {
		Truck tr = new Truck();
		tr.decEngine();// 엔진 성능 셋팅
		System.out.println("트럭의 엔진 성능 : " + tr.getPower());

		SmallCar sc = new SmallCar();
		sc.decEngine();
		System.out.println("경차차의 엔진 성능 : " + sc.getPower());
	}

}
