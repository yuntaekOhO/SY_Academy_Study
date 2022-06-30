package kr.s02.method;
public class MethodMain01 {

	//멤버변수
	String msg;
	//멤버메서드
	//반환하는 데이터가 없는 경우
	public void print(String str) {
		System.out.println(str);
	}
	
	//멤버변수에 데이터 전달
	public void setMsg(String m) {
		msg = m;
	}
	
	//멤버변수의 값을 반환
	public String getMsg() {
		return msg;
	}
	
	//반환하는 데이터가 있는 경우
	public int add(int a, int b) {
		return a + b;
	}
	
	public static void main(String[] args) {
		//기본적인 메서드의 이해
		
		//객체 선언 및 생성
		MethodMain01 me = new MethodMain01();
		//멤버메서드 호출
		me.print("봄");

		me.setMsg("서울");
		//멤버변수 호출
		System.out.println("me.msg = "+ me.msg);
		
		String city = me.getMsg();
		System.out.println("city = "+ city);
		System.out.println("me.getMsg() = "+ me.getMsg());
		
		int result = me.add(5, 6);
		System.out.println("result = "+ result);
		
	}
}
