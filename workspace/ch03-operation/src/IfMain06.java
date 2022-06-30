public class IfMain06 {
	public static void main(String[] args) {
		/*
		 * [실습]
		 * 정수 하나를 입력하여 짝수면 10을 더하고 홀수면 20을 더하여 결과값을 출력하시오
		 */
		int a, result;
		
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.print("정수 입력:");
		a = input.nextInt();

		if(a % 2 == 1) { // 홀수
			result = a + 20;
		}else { // 짝수
			result = a + 10;
		}
		
		System.out.println("결과 : " + result);
		
		input.close();
	}
}
