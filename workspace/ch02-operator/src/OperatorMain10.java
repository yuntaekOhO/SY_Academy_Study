public class OperatorMain10 {

	public static void main(String[] args) {
		System.out.println("====조건(삼항)연산자====");
		int a = 5, b = 10;
		int max; //최대값을 담는 변수
		int min; //최소값을 담는 변수
		
		max = a > b ? a : b;
		min = a < b ? a : b;
		
		System.out.println("max = " + max);
		System.out.println("min = " + min);
		
	}

}
