public class SwitchMain04 {

	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		int score;
		char grade;
		
		System.out.print("성적 입력:");
		score = input.nextInt();
		
		//성적은 0~100 값만 입력하도록 처리
		if(score<0 || score>100) {
			System.out.println("성적은 0~100만 입력 가능");
			//프로그램 종료
			System.exit(0);
		}
		
		switch(score/10) { // 0~100 -> 0~10
		case 10:
		case 9:
			grade = 'A'; break;
		case 8:
			grade = 'B'; break;
		case 7:
			grade = 'C'; break;
		case 6:
			grade = 'D'; break;
		default:
			grade = 'F';
		}
		
		System.out.println(); // 단순 줄바꿈
		System.out.printf("성적 : %d%n", score);
		System.out.printf("등급 : %c", grade);
		
		input.close();
	}

}
