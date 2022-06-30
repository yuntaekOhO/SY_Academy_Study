public class ForMain03 {

	public static void main(String[] args) {
		//변수 선언 및 초기화
		int sum = 0;
		for(int i=1;i<=100;i++) {
			//누적
			sum += i; // sum = sum + i
		}
		System.out.println("1~100 합 : " + sum);
	}

}
