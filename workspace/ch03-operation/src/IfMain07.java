public class IfMain07 {

	public static void main(String[] args) {
		/*
		 * [실습]
		 * 생년월일을 입력하고 만 나이를 출력하는 프로그램을 작성하시오.
		 * 만 나이 = (현재 연도 - 태어난 연도) - (생일이 지났으면 0, 생일이 지나지 않았으면 1)
		 * [출력 예시]
		 * 연도 입력:
		 * 월 입력:
		 * 일 입력:
		 * 만 나이는 ~
		 */
		//현재 연월일
		int thisYear = 2022;
		int thisMonth = 4;
		int thisDate = 19;
		
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.print("연도 입력:");
		int birthYear = input.nextInt();
		System.out.print("월 입력:");
		int birthMonth = input.nextInt();
		System.out.print("일 입력:");
		int birthDate = input.nextInt();
		
		int age = thisYear - birthYear;
		
		if(birthMonth >= thisMonth && birthDate >= thisDate) {
			age -= 1 ;
		}
		/*
		 * if(thisMonth < birthMonth) {
		 * 		age--;
		 * } else if(thisMonth == birthMonth && thisDate < birthDate) {
		 * 		age--;
		 * }
		 */
		System.out.println("만 나이는 " + age);
		
		
		
		input.close();
	}

}
