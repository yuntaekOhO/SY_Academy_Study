package kr.s10.abstractex;

//추상클래스
abstract class A2{
	//멤버변수
	private int x;
	//멤버메서드
	public void setX(int x) {
		this.x = x;
	}
	//일반적으로 추상클래스는 하나 이상의 추상 메서드 명시
	public abstract void make();
}
//일반클래스에 추상클래스 상속
//추상메서드가 포함되어 있으면 반드시 추상메서드를 자식클래스에 구현해주어야
//자식클래스 객체 생성이 가능함
class B2 extends A2{
	//추상메서드 구현
	@Override
	public void make() {
		System.out.println("make 메서드");
	}
	
}
public class AbstractMain02 {

	public static void main(String[] args) {
		B2 b = new B2();
		b.make();
		
	}

}
