package kr.s10.abstractex;

/*
 * 추상클래스 :
 * 미완성된 개념으로 단독으로 객체 생성이 불가능하고
 * 일반적으로 자식클래스에 상속되어져서 사용됨.
 * 
 */
abstract class A{
	private int x;
	public void setX(int x) {
		this.x = x;
	}
	public int getX() {
		return x;
	}
}

//추상클래스를 일반클래스에 상속
class B extends A{
	int b = 200;
}
public class AbstractMain01 {

	public static void main(String[] args) {
		//추상클래스는 객체 생성 불가능
		//A a = new A();
		
		B b = new B();
		b.setX(100);
		System.out.println(b.getX());
		System.out.println(b.b);
	}

}
