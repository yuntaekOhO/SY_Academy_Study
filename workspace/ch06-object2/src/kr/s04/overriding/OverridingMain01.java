package kr.s04.overriding;

//부모 클래스
class GrandParent {
	public String getCar() {
		return "구형 자동차";
	}
}

//자식 클래스
class Father extends GrandParent {
	// Method Overriding(메서드 재정의)
	// 상속 관계에서 부모 클래스의 메서드를 재정의하면 객체 생성 후 재정의 된 메서드를
	// 호출하면 부모 클래스의 메서드가 호출되지 않고 자식 클래스의 재정의된 메서드가
	// 호출됨

	// 어노테이션
	// 재정의가 메서드 오버라이딩 문법에 맞게 재정의되었는지를 검증
	@Override
	public String getCar() {
		return "신형 자동차";
	}
}

//자식 클래스
class Oncle extends GrandParent {
//	public String getCar() {
//		return "";
//	}
}

public class OverridingMain01 {

	public static void main(String[] args) {
		Father ft = new Father();
		System.out.println(ft.getCar());

		System.out.println("---------------------");

		Oncle oc = new Oncle();
		System.out.println(oc.getCar());
	}

}
