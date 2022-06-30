public class ArrayMain14 {

	public static void main(String[] args) {
		int[][] score = {
				{98,99,95},
				{99,98,97},
				{88,92,91},
				{99,92,90},
				{80,81,92}
				};
		System.out.println("번호 국어 영어 수학 총점 평균");
		System.out.println("------------------------");
		//                 5
		for(int i=0;i<score.length;i++) {
			int sum = 0;
			System.out.print(" "+(i+1)+" ");
			for(int j=0;j<score[i].length;j++) {
				//총점 구하기(누적)
				sum += score[i][j];
				//과목 점수 출력
				System.out.print(" " +score[i][j]+" ");
			}
			//평균 구하기, 총점과 평균을 출력
			System.out.println(sum + " " + sum/score[i].length);
		}
	}

}
