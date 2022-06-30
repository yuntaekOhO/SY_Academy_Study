package kr.s10.abstractex;

abstract class AbsEx1{
	int a = 100;
	public String getStr() {
		return "봄";
	}
	//추상메서드
	public abstract int getA();
	public abstract void make();
}

abstract class AbsEx2 extends AbsEx1{
	//AbsEx1의 추상메서드를 구현
	@Override
	public int getA() {
		return a;
	}
	//추상메서드
	public abstract void play();
}

//일반클래스에 추상클래스 상속
public class AbstractMain04 extends AbsEx2 {

	//추상메서드 구현
	@Override
	public void play() {
		System.out.println("play 메서드");
	}

	@Override
	public void make() {
		System.out.println("make 메서드");
	}
	
	public static void main(String[] args) {
		AbstractMain04 ab = new AbstractMain04();
		ab.make();
		ab.play();
	}

}
