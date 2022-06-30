package kr.s08.bank;

public class MinusAccount extends BankAccount{
	/*
	 * [실습]
	 * 1. BankAccount 상속
	 * 2. 멤버변수: private 한도(minusLimit)
	 * 3. 출금하는 메서드(withdraw) 
	 * 		잔고 + 한도 (출금 가능 금액)를 이용해서 조건체크
	 * 4. 계좌정보 출력 메서드 재정의 (printAccount) : (마이너스)
	 * \
	 * 	 
	 * */
	private int minusLimit;
	public MinusAccount(String number, String name, int balance, int minusLimit) {
		super(number, name, balance);
		this.minusLimit = minusLimit;
	}
	
	@Override
	public void withdraw(int money) {
		
		if(balance + minusLimit < money) {
			System.out.println("한도 초과로 출금되지 않습니다.");
			return;
		}
		balance -= money;
		System.out.printf("%,d원이 출금되었습니다.%n",money);
		System.out.println("----------------------------");
	}
	
	@Override
	public void printAccount() {
		System.out.println("(마이너스)계좌번호 : " + number);
		System.out.println("예금주 : " + name);
		System.out.printf("계좌잔액 : %,d원%n", balance);
		System.out.printf("마이너스 한도 : %,d원%n", minusLimit);
		System.out.println("----------------------------");
	}

}
