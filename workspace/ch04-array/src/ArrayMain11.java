public class ArrayMain11 {

	public static void main(String[] args) {
		/*
		 * [실습]
		 * 1)10,20,30,40,50을 초기값으로 갖는 1차원 배열을 test라고 선언, 생성, 초기화
		 * 2)반복문을 이용해서 출력
		 * 3)확장 for문을 이용해서 출력
		 * 4)인덱스3의 데이터를 100으로 변경
		 * 5)마지막 요소의 값을 200으로 변경
		 * 6)반복문을 사용하여 모든 요소의 값을 0으로 초기화
		 * 7)홀수 인덱스에 10, 짝수 인덱스에 20 저장
		 * 8)모든 요소의 총합(sum)과 평균(avg)(총합을 요소의 수로 나눔) 구하고 출력
		 */
		//1)
		int[] test = new int[] {10, 20, 30, 40, 50};
		
		//2)
		for(int i=0;i<test.length;i++) {
			System.out.println(test[i]);
		}
		System.out.println("--------------");
		
		//3)
		for(int num : test) {
			System.out.println(num);
		}
		System.out.println("--------------");
		
		//4)
		test[3] = 100;
		//System.out.println(test[3]);
		//5)
		test[test.length-1] = 200;
		for(int num : test) {
			System.out.println(num);
		}
		System.out.println("--------------");
		
		//6)
		for(int i=0;i<test.length;i++) {
			test[i] = 0;
			System.out.println(test[i]);
		}
		System.out.println("--------------");
		
		//7
		for(int i=0;i<test.length;i++) {
			if(i % 2 == 0) {
				test[i] = 20;
			}else {
				test[i] = 10;
			}
			System.out.println(test[i]);
		}
		System.out.println("--------------");
		//8)
		int sum = 0;
		int avg = 0;
		for(int i=0;i<test.length;i++) {
			sum += test[i];
		}
		avg = sum / test.length;
		
		System.out.printf("sum : %d%n", sum);
		System.out.printf("avg : %d", avg);
	}

}
