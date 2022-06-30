public class WhileMain06 {

	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		int balance = 0; //잔고
		
		while(true) {
			System.out.println("-----------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고확인 | 4.종료");
			System.out.println("-----------------------------------");
			
			System.out.print("메뉴 선택:");
			int num = input.nextInt();
			
			if(num == 1) { // 예금
				System.out.print("예금액>");
				//      누적
				balance += input.nextInt();
			}else if(num == 2) { // 출금
				System.out.print("출금액>");
				//      차감
				balance -= input.nextInt();
			}else if(num == 3) { // 잔고 확인
				System.out.printf("잔고 : %,d원%n", balance);
			}else if(num == 4) { // 종료
				System.out.println("프로그램 종료");
				break; // 반복문을 빠져나감
			}else { // 그 외
				System.out.println("잘못 입력했습니다.");
			}
		}
		
		
		input.close();
	}

}
