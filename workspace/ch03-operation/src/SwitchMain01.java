public class SwitchMain01 {
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		System.out.print("정수형 숫자 입력 :");
		int a = input.nextInt();
		
		//long형 데이터를 제외한 정수형(byte, short, int), char형 데이터 사용
		//보통 숫자인 경우에 switch문이 유용하다
		switch(a) { // 입력한 데이터를 인자값으로 전달
		case 1:
			System.out.println("1 입력");
			break; // switch블럭을 빠져나감
		case 2:
			System.out.println("2 입력");
			break;
		case 3:
			System.out.println("3 입력");
			break;
		default: // default에는 break 없어도 된다
			System.out.println("1,2,3이 아닌 숫자 입력");
		}
		
		input.close();
	}
}
