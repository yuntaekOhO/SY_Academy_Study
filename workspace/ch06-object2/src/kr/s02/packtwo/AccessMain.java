package kr.s02.packtwo;

import kr.s02.packone.People;

public class AccessMain {

	public static void main(String[] args) {
		People p = new People();
		//System.out.println(p.a); private : 같은 클래스가 아님 error
		//System.out.println(p.b); default : 같은 패키지가 아님 error
		//System.out.println(p.c); protected : 상속 관계 or 같은 패키지가 아님 error
		System.out.println(p.d); // public : 접근 제한이 없음, 어디서나 호출 가능
		
	}

}
