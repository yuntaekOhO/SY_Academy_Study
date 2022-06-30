package kr.s11.inter;

interface Inter1{
	//추상메서드
	public abstract int getA();
}

//인터페이스간 - 상속
interface Inter2 extends Inter1{
	//추상메서드
	public int getB(); // abstract 생략 body 없음으로 유추
}

interface Inter3{
	//추상메서드
	public abstract int getC();
}

//일반클래스에 인터페이스 구현
class InterEx implements Inter2, Inter3{
	//추상메서드 구현
	@Override
	public int getA() {
		return 10;
	}
	
	@Override
	public int getB() {
		return 20;
	}
	
	@Override
	public int getC() {
		return 30;
	}
}

public class InterMain03 {

	public static void main(String[] args) {
		InterEx in = new InterEx();
		System.out.println(in.getA());
		System.out.println(in.getB());
		System.out.println(in.getC());
	}
}
