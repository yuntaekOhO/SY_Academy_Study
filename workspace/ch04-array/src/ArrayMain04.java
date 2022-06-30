public class ArrayMain04 {

	public static void main(String[] args) {
		//성적을 저장한 배열 생성
		//배열의 선언 및 생성, 초기화
		int[] score = {100,88,88,100,90};
		
		int sum = 0;
		float average = 0.0f;
		
		for(int i=0;i<score.length;i++) {
			//누적, 총점 구하기
			sum += score[i];
		}
		//평균 구하기
		average = sum / (float)score.length;
		
		System.out.printf("총점 : %d%n", sum);
		System.out.printf("평균 : %.2f", average);
		
	}

}
