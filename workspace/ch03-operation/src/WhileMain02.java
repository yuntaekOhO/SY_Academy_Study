public class WhileMain02 {

	public static void main(String[] args) {
		int sum = 0, su = 1;
		//    조건식
		while(su<=100) {
			//누적
			sum += su; // sum = sum + su
			//증감식
			su++;
		}
		System.out.println("1~100까지의 합 : " + sum);
	}

}
