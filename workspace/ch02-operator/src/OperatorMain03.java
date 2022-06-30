public class OperatorMain03 {

	public static void main(String[] args) {
		/*
		 * [실습]
		 * 변수 korean, english, math를 선언하고 90,95,88로 초기화한다.
		 * 총점 구해서 변수 sum에 저장, 평균을 구해서 avg에 저장
		 * 출력 : 국어, 영어, 수학, 총점, 평균
		 */
		int korean = 90, english = 95, math = 88;
		int sum = korean + english + math;
		int avg = sum / 3;
		
		System.out.println("국어 : " + korean);
		System.out.println("영어 : " + english);
		System.out.println("수학 : " + math);
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + avg);
	}

}
