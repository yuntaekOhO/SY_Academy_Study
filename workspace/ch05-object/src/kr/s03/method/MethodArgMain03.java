package kr.s03.method;
public class MethodArgMain03 {
	/*
	 * 가변인자(Variable Arguments)
	 * JDK5.0이상부터 사용 가능
	 * 자료형이 일치할 때 전달하고자 하는 값의 개수를 다르게 지정할 수 있다
	 * 전달되는 데이터는 내부적으로 배열로 인식함
	 *  ...
	 */
	public void argTest(int ... n) {
		for(int i=0;i<n.length;i++) {
			System.out.println("n["+i+"]:"+n[i]);
		}
		System.out.println("--------------------");
	}
	public static void main(String[] args) {
		MethodArgMain03 me = new MethodArgMain03();
		//메서드가 호출되면 배열이 만들어진다
		//인자가 없는 경우는 length가 0
		me.argTest();
		me.argTest(10);
		me.argTest(10,20,30);
	}

}
