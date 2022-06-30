package kr.s02.method;
public class InstanceMain {
	//클래스의 기본 구조
	//필드
	int var1;//멤버변수
	String var2;//멤버변수
	
	public InstanceMain() {}//생성자, 기본적으로 생략
	
	//멤버 메서드
	public int sum(int a, int b) {
		return a + b;
	}
	
	public static void main(String[] args) {
		//me : 참조 변수
		InstanceMain me; //객체 선언
		//        생성자
		me = new InstanceMain();//객체 생성
		
		//객체의 멤버변수에 값을 할당
		me.var1 = 100;
		me.var2 = "서울";
		
		System.out.println("me.var1 = "+ me.var1);
		System.out.println("me.var2 = "+ me.var2);
		
		//객체의 멤버 메서드 호출
		int result = me.sum(10, 20);
		System.out.println("result = "+ result);
	}
}
