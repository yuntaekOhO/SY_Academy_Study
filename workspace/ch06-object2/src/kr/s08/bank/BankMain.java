package kr.s08.bank;

public class BankMain {
	public static void main(String[] args) {
		//계좌 생성
		BankAccount ba = new BankAccount("111-1234","홍길동",300000);
		//계좌정보 출력
		ba.printAccount();
		//입금하기
		ba.deposit(50000);
		//계좌정보 출력
		ba.printAccount();
		//출금하기
		ba.withdraw(200000);
		//계좌정보 출력
		ba.printAccount();
		//잔고보다 많은 출금액을 입력해서 출금하기
		ba.withdraw(1000000);
		System.out.println("===========================");
		
		//마이너스 계좌 생성
		MinusAccount ma = new MinusAccount("222-9874","이순신",100000,300000);
		//계좌정보 출력
		ma.printAccount();
		//입금하기
		ma.deposit(50000);
		//계좌정보 출력
		ma.printAccount();
		//출금하기
		ma.withdraw(200000);
		//계좌정보 출력
		ma.printAccount();
		//잔금+한도(출금 가능 금액)보다 더 많은 출금하기
		ma.withdraw(330000);
		//계좌정보 출력
		ma.printAccount();
	}
}
