public class ArrayMain12 {

	public static void main(String[] args) {
		/*
		 * [실습]
		 * 단을 입력받아서 1~9까지 곱해서 값을 구하고 배열에 그 값을 저장한 후
		 * 배열에 저장된 값을 읽어서
		 * 구구단 출력 형식 (2*1=2)으로 출력하시오
		 */
		java.util.Scanner input = new java.util.Scanner(System.in);
		int[] array = new int[9];
		int dan;
		
		System.out.print("단 입력:");
		dan = input.nextInt();
		
		for(int i=0;i<array.length;i++) {
			array[i] = dan * (i+1);
			System.out.printf("%d * %d = %d%n", dan, i+1, array[i]);
		}

		input.close();
		
	}

}
