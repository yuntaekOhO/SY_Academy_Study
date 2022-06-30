package kr.s05.overloading;

public class OverloadingMain01 {
	/*
	 * Method Overloading(중복 정의)은 하나의 클래스 내에서 같은 이름을 가지는 메서드가
	 * 여러 개 정의되는 것을 말한다.
	 * 메서드명은 동일하게 하고 인자의 타입 또는 개수, 배치된 순서가 다를 경우 다른 메서드로 인식함
	 */
	public void print(int n) {
		System.out.println("정수 n = " +n);
	}
	
	public void print(double a) {
		System.out.println("실수 a = " +a);
	}
	
	public void print(double n, long a) {
		System.out.println("실수 n = " +n+ ", 정수 a = " +a);
	}
	
	public void print(long a, double n) {
		System.out.println("정수 a = " +a+", 실수 n = " +n);
	}
	
	public static void main(String[] args) {
		OverloadingMain01 ot = new OverloadingMain01();
		ot.print(20);
		ot.print(5.6);
		ot.print(3.7, 1234L);
		ot.print(46L, 5.8);
	}

}
