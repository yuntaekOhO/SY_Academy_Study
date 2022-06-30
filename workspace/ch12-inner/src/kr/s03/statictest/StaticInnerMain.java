package kr.s03.statictest;

public class StaticInnerMain {
	
	//static 내부클래스
	//일반적으로 static 내부클래스를 정의하는 경우는
	//static 변수를 내부클래스가 가지고 있는 경우
	//반드시 static로 정의해야함
	public static class StaticInner{
		//인스턴스 변수
		int iv = 100;
		//static 변수
		static int cv = 200;
		//static 메서드
		static void make() {
			System.out.println("make 메서드");
		}
	}
	public static void main(String[] args) {
		//static 내부클래스는 static 내부클래스를 감싸고 있는 클래스를
		//객체 생성하지 않고 바로 static 내부클래스를 객체 생성해서 사용
		StaticInnerMain.StaticInner i = new StaticInnerMain.StaticInner();
		System.out.println(i.iv);
		
		System.out.println(StaticInnerMain.StaticInner.cv);
		System.out.println(StaticInner.cv);
		
		StaticInner.make();
	}

}
