package kr.s03.method;
class Account{
	/*
	 * [실습]
	 * Account -
	 * 1)멤버변수: 계좌번호(account_num),예금주(name),잔고(balance)
	 * 2)멤버메서드: 예금하기(deposite()) : balance 값 누적, (예금 처리 후) "입금이 완료되었습니다." 출력
	 * 			출금하기(withdraw()) : balance 값 차감, (출금 처리 후) "출금이 완료되었습니다." 출력
	 * 			계좌정보(printAccount()) : 계좌번호, 예금주, 잔고 출력
	 * 
	 * BankMain - 
	 * 1)Account 생성
	 * 2)계좌번호, 예금주, 잔고
	 * 3)while(true)형식으로 반복문 안에 메뉴 (1.예금 | 2.출금 | 3.잔고확인 | 4.종료)
	 */
	int account_num;
	String name;
	int balance;
	
	public void deposite(int a) {
		balance += a;
		System.out.println("입금이 완료되었습니다.");
	}
	public void withdraw(int b) {
		balance -= b;
		System.out.println("출금이 완료되었습니다.");
	}
	public void printAccount() {
		System.out.println("계좌번호: "+ account_num);
		System.out.println("예금주: "+ name);
		System.out.printf("잔고: %,d%n", balance);
	}
}
public class BankMain {

	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		Account account = new Account();//계좌 객체 생성
		//계좌 기본 속성 등록
		System.out.print("이름을 입력하세요>");
		account.name = input.next();
		System.out.print("계좌를 입력하세요>");
		account.account_num = input.nextInt();
		System.out.println("계좌 생성이 완료되었습니다.");
		
		
		while(true) {
			System.out.println("-----------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고확인 | 4.종료");
			System.out.println("-----------------------------------");
			System.out.print("메뉴 선택>");
			int num = input.nextInt();
			
			if(num==1) {
				System.out.print("예금액>");
				account.deposite(input.nextInt());
			}else if(num==2) {
				System.out.print("출금액>");
				account.withdraw(input.nextInt());
			}else if(num==3) {
				account.printAccount();
			}else if(num==4) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}else {
				System.out.println("잘못 입력했습니다.");
			}
			
		}
		
		
		input.close();
	}

}
