package kr.s07.instanceoftest;

//부모클래스
class Parent{
	//Object의 toString() 메서드 재정의
	@Override
	public String toString() {
		return "Parent 클래스";
	}
}
//자식클래스
class Child extends Parent{
	@Override
	public String toString() {
		return "Child 클래스";
	}
}
public class InstanceofMain {

	public static void main(String[] args) {
		Parent p = new Parent();
		//컴파일시 오류는 없지만 실행시 오류 발생
		//Child ch = (Child) p;
		
		//지정한 객체가 명시한 타입을 사용할 수 있는지 여부 체크 
		//객체            타입
		if(p instanceof Child) {// Parent 객체가 Child 타입을 사용할 수 있음
			Child ch2 = (Child) p;
			System.out.println(ch2);
		} else {// Parent 객체는 Child 타입을 사용할 수 없음
			System.out.println(p);
		}
	}

}
