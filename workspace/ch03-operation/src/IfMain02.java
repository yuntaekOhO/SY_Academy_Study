public class IfMain02 {
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.print("정수 한 개 입력:");
		int a = input.nextInt();
		
		//if-else
		//조건이 true이면 if블록의 수행문을 실행, 조건이 false이면 else블럭의 수행문을 실행
		if(a % 2 == 1) {
			//true, 홀수
			System.out.println("홀수입니다.");
		} else {
			//false, 짝수
			System.out.println("짝수입니다.");
		}
		
		input.close();
	}
}
