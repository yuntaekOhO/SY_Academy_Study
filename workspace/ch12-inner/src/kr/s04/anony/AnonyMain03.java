package kr.s04.anony;

interface InterEx{
	//추상메서드
	public /*abstract*/ void input();
	public void fun();
}

public class AnonyMain03 {
	
	public void make() {
		//익명 내부 클래스
		InterEx i = new InterEx() {
			//추상메서드 구현
			@Override
			public void input() {
				System.out.println("구현된 input 메서드");
			}
			@Override
			public void fun() {
				System.out.println("구현된 fun 메서드");
			}
		};
		i.input();
		i.fun();
	}
	
	public static void main(String[] args) {
		AnonyMain03 am = new AnonyMain03();
		am.make();
	}

}
