package kr.s07.wrapper;

public class WrapperMain01 {

	public static void main(String[] args) {
		//기본자료형
		boolean b = true;
		System.out.println(b);
		//Wrapper클래스 객체 생성
		Boolean wrap_b = new Boolean(false); // deprecated
		Boolean wrap_b2 = false;
		System.out.println(wrap_b2);
		Integer wrap_i = new Integer(100); // deprecated
		Integer wrap_i2 = 100;
		System.out.println(wrap_i2);
		
		
	}

}
