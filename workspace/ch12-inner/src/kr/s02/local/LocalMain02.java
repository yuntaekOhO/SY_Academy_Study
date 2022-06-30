package kr.s02.local;

public class LocalMain02 {
	//멤버변수
	int x = 300;
	//멤버메서드
	public void innerTest(int a) {
		int b = 200;
		//로컬 내부 클래스
		class Inner{
			//멤버메서드
			public void getData() {
				//JDK8.0부터는 로컬내부클래스를 감싸고 있는 메서드의
				//지역변수를 로컬내부클래스에서 호출하면 상수화:변경 불가능
				//변경불가능
				//a = 500;
				//b = 900;
				x = 800;//LocalMain02의 멤버변수는 변경 가능
				System.out.println("x : " + x);//LocalMain02의 멤버변수
				System.out.println("a : " + a);//지역변수가 상수화됨
				System.out.println("b : " + b);//지역변수가 상수화됨
			}
		}
		//로컬내부클래스 객체 생성
		Inner i = new Inner();
		i.getData();
	}
	
	public static void main(String[] args) {
		LocalMain02 inner = new LocalMain02();
		inner.innerTest(100);
		
	}

}
