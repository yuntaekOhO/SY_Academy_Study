public class VariableMain02 {

	public static void main(String[] args) {
		/*
		 * [실습]
		 * 정수를 담을 수 있는 변수를 세개 지정한다.
		 * 변수명은 각각 a,b,c라고 지정하ㅏ고 원하는 정수로 초기화한다.
		 * a + b 연산 후 출력할 때
		 * "결과 = 50" 형식으로 출력한다.
		 * c에 저장된 데이터를 80으로 변경해서
		 * "c = 80" 형식으로 출력한다.
		 */
		
		//변수 선언 및 초기화
		int a = 10, b = 20, c = 30;
		//연산 후 결과값 출력
		System.out.println("결과 : " + (a+b));
		System.out.printf("결과 : %d%n", a+b);
		//값 변경
		c = 80;
		//값 변경후 결과값 출력
		System.out.println("c = " + c);
		System.out.printf("c = %d", c);
	}

}
