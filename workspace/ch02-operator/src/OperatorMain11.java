public class OperatorMain11 {

	public static void main(String[] args) {
		System.out.println("====조건(삼항)연산자====");
		int age = 29;
		
		String str = age >= 10 && age <= 19 ? "10대" : "10대가 아님";
		
		System.out.println(age + " => " + str );
	}

}
