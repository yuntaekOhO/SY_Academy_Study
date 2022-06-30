package kr.s08.statictest;

public class StaticMain02 {
	//인스턴스 변수
	int a;
	//static 변수
	static String s;
	
	public static void main(String[] args) {
		//인스턴스 변수는 객체 생성 후 호출해야 함
		//System.out.println("a = "+ a);
		
		//StaticMain02.s = "자바의 꿈";
		//static 변수는 객체 생성과 무관하며 호출시 static 영역에 만들어짐
		s = "자바의 꿈";
		System.out.println("s = "+ s);
		
		StaticMain02 sm = new StaticMain02();
		sm.a = 12;
		System.out.println("sm.a = "+sm.a);
	}
}
