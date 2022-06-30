public class OperatorMain05 {

	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		System.out.print("국어 :");
		int korean = input.nextInt();
		System.out.print("영어 :");
		int engilsh = input.nextInt();
		System.out.print("수학 :");
		int math = input.nextInt();
		
		//총점 구하기
		int sum = korean + engilsh + math;
		//평균 구하기
		double avg = sum / 3.0;
		
		System.out.printf("국어 : %d%n", korean);
		System.out.printf("영어 : %d%n", engilsh);
		System.out.printf("수학 : %d%n", math);
		System.out.printf("총점 : %d%n", sum);
		System.out.printf("평균 : %.2f%n", avg);
		
		input.close();
	}

}
