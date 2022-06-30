package kr.s01.member;

class Outer {
	int x = 100;
	//멤버내부클래스
	class Inner{
		int y = 200;
	}
}

public class MemberMain01 {

	public static void main(String[] args) {
		Outer ot = new Outer();
		System.out.println(ot.x);
		
		//내부클래스 객체 생성
		Outer.Inner oi = ot.new Inner();
		System.out.println(oi.y);
	}

}
