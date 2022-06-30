package kr.s02.packtwo;

import kr.s02.packone.People;

//자식 클래스
class Student extends People{
	public void print() {
		//private : 같은 클래스가 아님 error
		//System.out.println("a = " + a);
		
		//default : 같은 패키지가 아님 error
		//System.out.println("b = " + b);
		
		//protected : 상속 관계 or 같은 패키지만 가능
		System.out.println("c = " + c);
		
		//public : 접근 제한 없음
		System.out.println("d = " + d);
	}
}
public class AccessMain02 {

	public static void main(String[] args) {
		Student s = new Student();
		//private : 같은 클래스가 아님 error
		//System.out.println(s.a);
		
		//default : 같은 패키지가 아님 error
		//System.out.println(s.b);
		
		//protected : 상속 관계 or 같은 패키지만 가능
		//System.out.println(s.c);
		
		//public : 접근 제한 없음
		System.out.println(s.d);
		
		s.print();
	}

}
