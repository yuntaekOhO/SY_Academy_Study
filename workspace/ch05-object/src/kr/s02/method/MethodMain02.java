package kr.s02.method;
public class MethodMain02 {
	//멤버메서드
	public int add(int a, int b) {
		return a+b;
	}
	public int sub(int a, int b) {
		return a-b;
	}
	public int multi(int a, int b) {
		return a*b;
	}
	public int divide(int a, int b) {
		return a/b;
	}
	
	//main 메서드(객체가 생성되면 객체에 포함되지 않음)
	public static void main(String[] args) {
		//멤버메서드는 main메서드에서 직접 호출이 불가능하고 항상
		//객체를 생성한 후 호출해야함
		
		//객체 선언 및 생성
		MethodMain02 me = new MethodMain02();
		//덧셈
		int result = me.add(5, 8);
		System.out.println("result = "+ result);
		//뺄셈
		int result2 = me.sub(10, 6);
		System.out.println("result2 = "+ result2);
		//덧셈
		System.out.println("me.add(20, 15) = "+ me.add(20, 15));
		//곱셈
		int result3 = me.multi(5, 3);
		System.out.println("result3 = "+ result3);
		//나눗셈
		int result4 = me.divide(20, 3);
		System.out.println("result4 = "+ result4);
	}
}
