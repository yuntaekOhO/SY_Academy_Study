import java.util.Scanner;

public class OperatorMain12 {

	public static void main(String[] args) {
		/*
		 * [실습]
		 * 자신이 태어난 연도를 입력받아서 현재 나이를 출력하는 프로그램을 작성하시오
		 */
		int thisYear = 2022;
		
		Scanner input = new Scanner(System.in);
		System.out.print("자신이 태어난 연도 입력:");
		int birthYear = input.nextInt();

		int age = thisYear - birthYear;
		
		System.out.printf("당신의 나이는 %d살 입니다.", age);
		
		input.close();
	}

}
