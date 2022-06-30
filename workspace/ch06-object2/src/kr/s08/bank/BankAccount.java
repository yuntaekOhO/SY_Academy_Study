package kr.s08.bank;

public class BankAccount {
/*
 * [실습]
 * 멤버변수 : protected String 계좌번호(number), String 예금주(name), int 잔고(balance)
 * 생성자 : number, name, balance를 전달받아서 멤버변서 초기화
 * 		  출력 - "홍길동님 계좌가 개설되었습니다."
 * 멤버메서드 : 예금하기(deposit) : "2,000원이 입금되었습니다."
 * 			출금하기(withdraw) : 잔고보다 출금액이 많으면 "잔액이 부족합니다."
 * 							   잔고가 출금액 이상이면 "1,000원이 출금되었습니다."
 * 			계좌정보 출력(printAccount) : (일반) 계좌번호 : 100-1234
 * 									  예금주 : 홍길동
 * 									  계좌잔액 : 20,000원 
 */
	protected String number;
	protected String name;
	protected int balance;
	
	public BankAccount(String number, String name, int balance) {
		this.number = number;
		this.name = name;
		this.balance = balance;
		System.out.println(name + "님 계좌가 개설되었습니다.");
		System.out.println("----------------------------");
	}
	
	public void deposit(int money) {
		balance += money;
		System.out.printf("%,d원이 입금되었습니다.%n", money);
		System.out.println("----------------------------");
	}
	
	public void withdraw(int money) {
		if(balance < money) {
			System.out.println("잔액이 부족합니다.");
			return;
		}
		balance -= money;
		System.out.printf("%,d원이 출금되었습니다.%n",money);
		System.out.println("----------------------------");
	}
	
	public void printAccount() {
		System.out.println("(일반)계좌번호 : " + number);
		System.out.println("예금주 : " + name);
		System.out.printf("계좌잔액 : %,d원%n", balance);
		System.out.println("----------------------------");
	}
}
