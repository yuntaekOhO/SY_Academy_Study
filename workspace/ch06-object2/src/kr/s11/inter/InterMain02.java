package kr.s11.inter;

//인터페이스 : 형식만 있고 내용이 없음 = 뼈대
interface A2{
	//인터페이스에는 일반메서드를 정의할 수 없음
	/*
	public void make() {
		System.out.println("make메서드");
	}
	*/
	
	//추상메서드
	public abstract void play(); // 원형
	void fun();
	
}
class B2 implements A2{
	
	@Override
	public void play() {
		System.out.println("play method");
	}
	
	@Override
	public void fun() {
		System.out.println("fun method");
	}
}

public class InterMain02 {

	public static void main(String[] args) {
		B2 bp = new B2();
		bp.play();
		bp.fun();
	}

}
