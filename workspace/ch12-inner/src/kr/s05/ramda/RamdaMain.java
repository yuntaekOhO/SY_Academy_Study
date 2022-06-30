package kr.s05.ramda;

interface MyInterface{
	//추상메서드
	public abstract void make();
}
public class RamdaMain {

	public static void main(String[] args) {
		//익명내부클래스
		MyInterface my = new MyInterface() {
			//추상메서드 구현
			@Override
			public void make() {
				System.out.println("익명 객체");
			}
		};
		my.make();
		
		System.out.println("--------------------------");
		
		/*람다식은 익명함수(anonymous function)을 생성하기 위한 식
		 * 람다식의 형태는 매개 변수를 가진 코드 블럭이지만, 런타임 시에는
		 * 익명 구현 객체를 생성
		 * 람다식은 인터페이스의 익명 구현 객체를 생성
		 * 
		 */
		
		//MyInterface my2 = make() -> { };
		MyInterface my2 = () -> {
			System.out.println("람다식으로 표시");
		};
		
		my2.make();
		
		
	}

}
