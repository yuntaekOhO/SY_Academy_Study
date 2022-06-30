package kr.s01.thread;

public class ThreadMain03 implements Runnable{
	//Runnable의 run()메서드 구현
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			
			try {
				Thread.sleep(1000);// ms, 1000ms = 1초
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("쓰레드 이름 : " + Thread.currentThread().getName());
		}
	}
	
	public static void main(String[] args) {
		ThreadMain03 th = new ThreadMain03();
		Thread t = new Thread(th,"첫번째***");
		t.start();
		Thread t2 = new Thread(th,"두번째===");
		t2.start();
		Thread t3 = new Thread(th,"세번째+++");
		t3.start();
	}

}
