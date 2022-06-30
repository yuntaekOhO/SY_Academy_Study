public class OperatorMain06 {

	public static void main(String[] args) {
		System.out.println("====비교(관계)연산자====");
		//변수 선언
		boolean result;
		//변수 선언 및 초기화
		int a = 10;
		double b = 10.5;
		
		//비교연산자 사용
		result = a < b; //a : int -> double 자동 형변환
		System.out.println("a < b : " + result);
		
		result = a > b;
		System.out.println("a > b : " + result);
		
		result = a >= b;
		System.out.println("a >= b : " + result);
		
		result = a <= b;
		System.out.println("a <= b : " + result);
		
		result = a == b;
		System.out.println("a == b : " + result);
		
		result = a != b;
		System.out.println("a != b : " + result);
	}

}
