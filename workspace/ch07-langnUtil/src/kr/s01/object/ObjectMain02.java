package kr.s01.object;

class Value{
	int value;
	
	public Value(int value) {
		this.value = value;
	}
}

public class ObjectMain02 {

	public static void main(String[] args) {
		Value v1 = new Value(10);
		Value v2 = new Value(10);
		
		System.out.println(v1);
		System.out.println(v2);
		System.out.println("-----------------------------");
		
		//객체 비교
		if(v1.equals(v2)) {
			System.out.println("v1과 v2는 같습니다");
		}else {
			System.out.println("v1과 v2는 다릅니다");
		}
		System.out.println("-----------------------------");
		
		//객체의 주소를 복사
		Value v3 = v1;
		//객체 비교
		//stack 영역의 reference 복사 - 가르키는 객체가 일치
		if(v1.equals(v3)) {
			System.out.println("v1과 v3는 같습니다");
		}else {
			System.out.println("v1과 v3는 다릅니다");
		}
		System.out.println("-----------------------------");
		
		//객체 비교 v1.equals(v3)와 같은 결과
		if(v1 == v3){
			System.out.println("v1과 v3는 같습니다");
		}else {
			System.out.println("v1과 v3는 다릅니다");
		}
		
		
	}

}
