package kr.s06.poly;

//부모 클래스
class Parent2{
	public void make() {
		System.out.println("부모클래스의 make");
	}
}
//자식 클래스
class Child2 extends Parent2{
	//메서드 오버라이딩(재정의)
	@Override
	public void make() { 
		System.out.println("자식클래스의 make");
	}
	
}

public class PolyMain03 {

	public static void main(String[] args) {
		Child2 ch = new Child2();
		ch.make();
		Parent2 p = ch;// 자식클래스타입 -> 부모클래스타입 형변환
						// 업캐스팅, 자동적으로 형변환
		// 재정의한 메서드는 자료형을 부모클래스타입으로 형변환하더라도
		// 재정의한 메서드가 호출됨 
		p.make();
		
	}

}
