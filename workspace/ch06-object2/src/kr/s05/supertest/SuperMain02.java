package kr.s05.supertest;

//부모 클래스
class Parent{
	public void play() {
		System.out.println("Parent의 play 메서드");
	}
}
//자식 클래스
class Child extends Parent{
	//메서드 오버라이딩(재정의)
	
	public Child() {
		//부모 클래스 영역의 play() 메서드 호출
		super.play();
		System.out.println("===============");
	}
	
	@Override
	public void play() {
		System.out.println("Child의 play 메서드");
	}
}


public class SuperMain02 {
	public static void main(String[] args) {
		Child ch = new Child();
		ch.play();
	}
}
