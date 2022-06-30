package kr.s01.member;

class Outer3{
	//멤버변수
	int value = 10;
	//멤버내부클래스
	class Inner3{
		//멤버변수
		int value = 20;
		public void make() {
			//make()메서드 안에서 this -> Inner3 객체
							 //Outer3.this -> Outer3 객체
			//지역변수
			int value = 30;
			System.out.println("value : "+ value); //make메서드의 value
			//Inner3의 멤버변수 value
			System.out.println("this.value : "+ this.value);
			//Outer3의 멤버변수 value
			System.out.println("Outer3.this.value : " + Outer3.this.value);
		}
	}
}
public class MemberMain03 {

	public static void main(String[] args) {
		Outer3 outer = new Outer3();
		Outer3.Inner3 inner = outer.new Inner3();
		inner.make();
	}

}
