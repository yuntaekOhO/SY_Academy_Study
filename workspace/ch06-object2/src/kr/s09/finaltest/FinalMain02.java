package kr.s09.finaltest;

class Me{
	//메서드에 final 명시하면 해당 메서드를 자식클래스에서 재정의 할 수 없음
	public final void make() {
		System.out.println("부모클래스의 make");
	}
}
public class FinalMain02 extends Me{

	/*
	@Override
	public void make() {
		System.out.println("자식클래스의 make");
	}*/
	
	public static void main(String[] args) {
		FinalMain02 fm = new FinalMain02();
		fm.make();
	}

}
