package kr.s03.method;
class Worker{
	/*
	 * [실습]
	 * Worker -
	 * 1)멤버변수: 직원이름(name), 급여(money), 계좌 잔고(balance)
	 * 2)멤버메서드: work(실행하면 money에 1000원 누적),
	 * 			deposite(실행하면 money의 돈을 balance에 누적 시키고 0으로 처리)
	 * WorkerMain -
	 * 1)객체 생성
	 * 2)직원의 이름 지정
	 * 3)10번 일하는데 번 돈이 3천원일 때마다 계좌에 저축
	 * 4)직원이름, 현재 계좌에 입금되지 않고 남아 있는 급여(money), 계좌잔고(balance)를 출력하시오
	 */
	String name;
	int money;
	int balance;
	
	public void work() {
		money += 1000;
	}
	
	public void deposite() {
		balance += money;
		money = 0;
	}
}

public class WorkerMain {
	
	public static void main(String[] args) {
		Worker worker = new Worker();
		worker.name = "홍길동";
		
		for(int i=1;i<=10;i++) {
			worker.work();
			if(worker.money >= 3000) {
				worker.deposite();
			}
		}
		
		System.out.println("직원 이름 : "+ worker.name);
		System.out.println("현금 : "+ worker.money);
		System.out.println("계좌잔고 : "+ worker.balance);
	}

}
