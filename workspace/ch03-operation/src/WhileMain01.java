public class WhileMain01 {

	public static void main(String[] args) {
		//while문 사용시 주의할 점은 증감식이 없으면 무한루프에 빠진다.
		int i = 1; // 초기값
		while(i<=10) { // 조건식 i가 10인 동안 true
			//출력			  증감식역할  
			System.out.println(i++);
		}
		System.out.println("----------------");
		
		int j = 10; // 초기값
		while(j>=0) {// 조건식
			//출력			  증감식역할
			System.out.println(j--);
		}
	}

}
