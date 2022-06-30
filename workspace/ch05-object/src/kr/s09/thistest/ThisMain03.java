package kr.s09.thistest;

public class ThisMain03 {

	public ThisMain03() {
		//생성자 내부에서 또 다른 생성자를 호출할 때 사용
		//생성자 내부에 반복적인 코드가 있어서 반복적인 코드를 제거하고 코드를 재사용
		//생성자 내에서 또 다른 생성자를 호출하기 전에 수행문이 호출되면 오료발생
		//System.out.println("인자가 없는 생성자 호출");
		this("바람");
		System.out.println("인자가 없는 생성자 호출");
	}
	public ThisMain03(int a) {
//		String s = String.valueOf(a);
//		System.out.println(s.length());
		//int -> String 변환
		this(String.valueOf(a));
	}
	public ThisMain03(float n) {
//		String s = String.valueOf(n);
//		System.out.println(s.length());
		//float -> String
		this(String.valueOf(n));
	}
	public ThisMain03(String s) { //this()가 가르키는 생성자
		System.out.println(s.length());//문자열의 길이
	}
	public static void main(String[] args) {
		ThisMain03 th01 = new ThisMain03();
		ThisMain03 th02 = new ThisMain03(1000);
		ThisMain03 th03 = new ThisMain03(10.3f);
		ThisMain03 th04 = new ThisMain03("제주도");
	}

}
