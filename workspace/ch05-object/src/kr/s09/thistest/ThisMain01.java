package kr.s09.thistest;

public class ThisMain01 {
	/*
	 * this는 객체 내부에서 객체를 지칭할 때 사용할 수 있고 일종의 참조변수 역할을 함
	 * 객체의 구성원(필드,메서드)를 호출할 때 사용
	 */
	public ThisMain01() {
		System.out.println("객체 생성 : " + this);
	}
	public static void main(String[] args) {
		ThisMain01 tt = new ThisMain01();
		System.out.println("객체 생성 후 : " + tt);
	}

}
