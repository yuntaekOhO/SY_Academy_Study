package kr.s07.constructor;

public class AccountMain {
	//멤버변수
	String accountNo; //계좌번호
	String ownerName; //예금주
	int balance; //잔고
	
	//인자가 있는 생성자 정의
	public AccountMain(String a, String o, int b) {
		accountNo = a;
		ownerName = o;
		balance = b;
		System.out.println(ownerName+"님 계좌가 생성되었습니다.");
		printAccount();
	}
	public void deposit(int amount) {
		if(amount <= 0) {
			System.out.println("0보다 크게 입력해야 합니다.");
			//void형 메서드에서 특정 조건일 때 메서드를 빠져나감
			return; // 음수 입력시 메서드 탈출  if-else로 대체될 수 있음
		}
		//누적
		balance += amount;
		System.out.println("입급이 완료되었습니다.");
	}
	public void withdraw(int amount) {
		if(amount <= 0) {
			System.out.println("0보다 크게 입력해야 합니다.");
			return;
		}
		
		if(balance < amount) {
			System.out.println("잔고가 부족합니다.");
		}else {
			balance -= amount;
			System.out.println("출금이 완료되었습니다.");
		}
	}
	public void printAccount() {
		System.out.println("계좌번호 : "+ accountNo);
		System.out.println("예금주 : "+ ownerName);
		System.out.printf("잔고 : %,d원%n", balance);
		System.out.println("------------------------");
	}
	
	public static void main(String[] args) {
		//계좌 생성
		AccountMain am = new AccountMain("100-123","홍길동",10000);
		//예금하기
		//am.deposit(-100);
		am.deposit(20000);
		am.printAccount();
		//출금하기
		//am.withdraw(-10000);
		am.withdraw(15000);
		am.printAccount();
	}
}
