package kr.s06.poly;

//부모 클래스
class Parent{
	int a = 100;
}
//자식 클래스
class Child extends Parent{
	int b = 200;
}
/*
 * 다형성(Polymorphism)
 * 객체지향개념에서 다형성이란 "여러 가지 형태를 가질 수 있는 능력"을 의미하며,
 * 자바에서는 한 타입의 참조변수로 여러 타입의 객체를 참조할 수 있도록 함으로써
 * 다형성을 프로그램적으로 구현
 */
public class PolyMain01 {

	public static void main(String[] args) {
		Child ch = new Child();
		System.out.println(ch.a);
		System.out.println(ch.b);
		System.out.println("-------------");
		
		Parent p = ch;// 자식 클래스 타입 -> 부모 클래스 타입 형변환
					  // 업캐스팅, 자동적으로 형변환
		System.out.println(p.a);
		//System.out.println(p.b);
		System.out.println("-------------");
		
		Child ch2 = (Child)p;// 부모 클래스 타입 -> 자식 클래스 타입 형변환
							 // 다운캐스팅, 명시적으로 형변환
		System.out.println(ch2.a);
		System.out.println(ch2.b);
		

	}

}
