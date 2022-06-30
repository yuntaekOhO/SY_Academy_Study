package kr.s08.statictest;

class StaticMethod {
	//인스턴스 변수
	String s1 = "인스턴스 변수";
	//static 변수
	static String s2 = "static 변수";
	
	//static 메서드
	public static String getString() {
		return s2;
	}
	
	//인스턴스 메서드
	public String getStr() {
		return s1;
	}
}

public class StaticMain03 {

	public static void main(String[] args) {
		//static 메서드는 클래스명.메서드명의 형태로 호출가능
		//객체 생성없이 호출 가능
		System.out.println(StaticMethod.getString());
		
		//인스턴스 변수, 인스턴스 메서드는 직접 호출 불가능,
		//객체 생성 후 호출
		//System.out.println(getStr());
		StaticMethod sm = new StaticMethod();
		System.out.println(sm.getStr());
	}

}
