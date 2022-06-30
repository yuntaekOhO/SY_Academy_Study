package kr.s04.anony;

class Inner7 {
	public void disp() {
		System.out.println("부모클래스의 disp");
	}
}
public class AnonyMain02 {

	public void make() {
		//익명내부클래스
		Inner7 i = new Inner7() {
			//익명내부클래스에서는 자료형을 부모 클래스타입만 사용 가능하기 때문에
			//메서드를 정의할 때 부모클래스의 메서드만 재정의해서 사용하게 됨
			@Override
			public void disp() {
				System.out.println("자식클래스의 disp");
			}
			public void play() {
				System.out.println("자식클래스의 play");
			}
			
		};
		i.disp();
		//호출 범위를 벗어나 호출 불가능, 재정의한 메서드만 유효
		//i.play();
	}
	
	public static void main(String[] args) {
		AnonyMain02 am = new AnonyMain02();
		am.make();
	}

}
