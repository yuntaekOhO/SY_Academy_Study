package kr.s04.anony;

class Inner6{
	public void disp() {
		System.out.println("부모클래스의 disp");
	}
}

public class AnonyMain01 {
	//멤버메서드
	public void make() {
		//로컬내부클래스
		class Inner extends Inner6{
			@Override
			public void disp() {
				System.out.println("자식클래스의 disp");
			}
			public void play() {
				System.out.println("자식클래스의 play");
			}
		}
		//로컬내부클래스 객체 생성
		Inner6 i = new Inner();
		i.disp();
		//호출 범위를 벗어나 호출 불가
		//i.play();
		
	}
	public static void main(String[] args) {
		AnonyMain01 am = new AnonyMain01();
		am.make();
		
	}

}
