package kr.s01.thread;

//Runnable 인터페이스를 이용한 쓰레드 사용
public class ThreadMain02 implements Runnable{
	
	//Runnable의 추상메서드 구현
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.printf("쓰레드 이름 : %s, ", 
					          Thread.currentThread().getName());
			System.out.printf("temp value : %d%n", i);
		}
	}
	
	public static void main(String[] args) {
		ThreadMain02 th = new ThreadMain02();
		                  //실행할 run()메서드가 구현된 객체
		Thread t = new Thread(th,"두번째");
		t.start();//-> ThreadMain02의 run()메서드 호출
		
	}
}




