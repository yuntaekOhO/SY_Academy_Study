package kr.s09.finaltest;

class A{
	//지정한 값은 변경 불가능
	final int NUM = 10;// 상수: 대문자로 명시함
	
	//static 상수
	public static final int NUMBER = 20;
}
public class FinalMain01 {

	public static void main(String[] args) {
		A a = new A();
		//상수는 변경 불가능
		//a.NUM = 100;
		System.out.println(a.NUM);
		
		//static 상수 호출
		System.out.println(A.NUMBER);
		System.out.println("-----------------------");
		
		//메서드 안에서 상수 정의
		final int NO = 30;
		System.out.println(NO);
		
		
	}

}
