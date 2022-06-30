public class ArrayMain08 {

	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		String[] course = {"국어", "영어", "수학"};
		int[] score = new int[course.length];//0:국어, 1:영어, 2:수학
		int sum = 0;
		float avg = 0.0f;
		
		//반복문을 이용해서 성적(국어,영어,수학) 처리
		for(int i=0;i<course.length;i++) {
			do {
				System.out.print(course[i] + "=");
				score[i] = input.nextInt();
			}while(score[i]<0 || score[i]>100);
			//총점 구하기(누적)
			sum += score[i];
		}
		//평균 구하기
		avg = sum / (float)course.length;
		
		System.out.println();
		
		//과목명 = 성적 출력
		for(int i=0;i<score.length;i++) {
			System.out.printf("%s = %d%n", course[i], score[i]);
		}
		
		System.out.printf("총점 = %d%n", sum);
		System.out.printf("평균 = %.2f", avg);
		
		input.close();
	}

}
