package kr.s09.thistest;

public class LocalVariable {
	//멤버변수 : 클래스 블럭 내에서 정의된 변수
	int b = 200;
	
	public void make() {
		//지역변수 : 메서드, 생성자, 제어문 블럭 내에서 생성도니 변수
		//			해당 블러깅 종료되면 변수는 소멸함.
		int a = 100;
		System.out.println("a :"+a);
		System.out.println("b :"+b);
	}
	public void fun() {
		//fun메서드 안에 a변수가 정의되지 않아서 호출 불가능
		//System.out.println("a :"+a);
		System.out.println("b :"+b);
	}
	
	public static void main(String[] args) {
		for(int i=1;i<=5;i++) {//제어문 블럭안의 지역변수
								//제어문 내에서 선언한 지역변수(i)는 제어문이 끝나면 소멸
			System.out.print(i+"\t");
		}
		System.out.println("\n-----------------");
		//main 블럭 안에 i 변수가 없어서 오류
		//System.out.println(i);
		
		int a;
		for(a=1;a<=5;a++) {
			System.out.print(a+"\t");
		}
		System.out.println("\n-----------------");
		System.out.println(a);//제어문 밖에 선언 함 = main메서드 블럭 내에서 선언된 변수
	}
}
