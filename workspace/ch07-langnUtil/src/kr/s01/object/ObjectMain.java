package kr.s01.object;

public class ObjectMain {

	public static void main(String[] args) {
		ObjectMain ob = new ObjectMain();
		
		//상속받은 Object의 메서드를 호출
		
		//클래스 정보 반환
		System.out.println(ob.getClass());
		//클래스명 반환
		System.out.println(ob.getClass().getName());
		//해시코드
		System.out.println(ob.hashCode());
		//해시코드를 16진수로 변환
		System.out.println(Integer.toHexString(ob.hashCode()));
		
		//toString 메서드 호출(toString메서드는 객체의 참조값 반환)
		//객체의 참조변수를 출력한 것과 결과가 같다
		//toString은 getClass().getName() + Integer.toHexString(ob.hashCode())를 사용한 것이다
		System.out.println(ob.toString());
		System.out.println(ob);
		
	}

}
