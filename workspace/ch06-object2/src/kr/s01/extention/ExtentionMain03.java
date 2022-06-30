package kr.s01.extention;
//부모 클래스
class A{
	int x = 100;
	private int y = 200;//은닉화
	
	public int getY() {
		return y;
	}
}
//자식 클래스
class B extends A{
	int z = 300;
}
public class ExtentionMain03 {

	public static void main(String[] args) {
		B b = new B();
		System.out.println(b.x);
		//private 멤버변수는 직접 호출 불가
		//System.out.println(b.y);
		System.out.println(b.getY());
		System.out.println(b.z);
	}

}
