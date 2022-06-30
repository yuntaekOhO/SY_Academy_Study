package kr.s09.thistest;

class ThisTest{
	//은닉화
	//멤버변수
	private int a;
	
	//캡슐화          (지역변수a)
	public void setA(int a) {
	//  멤버변수 = 지역변수
		this.a = a;
	}
	public int getA() {
		return a;
	}
}
public class ThisMain02 {

	public static void main(String[] args) {
		ThisTest th = new ThisTest();
		th.setA(10);
		System.out.println(th.getA());
	}

}
