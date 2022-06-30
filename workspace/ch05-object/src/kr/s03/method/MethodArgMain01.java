package kr.s03.method;
public class MethodArgMain01 {
	//인자 전달 방식 : 값 호출
	//기본 자료형의 값을 인자로 전달하는 방식. 값을 복사하여 전달
	//멤버메서드
	public int increase(int n) {
		++n;
		return n;
	}
	public static void main(String[] args) {
		int var1 = 100;
		MethodArgMain01 me = new MethodArgMain01();
		int var2 = me.increase(var1);
		System.out.println("var1 :"+var1+", var2 :"+var2);
	}

}
