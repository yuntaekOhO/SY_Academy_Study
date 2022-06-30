package kr.s01.thread;

//Thread 클래스를 상속해서 쓰레드 구현
public class ThreadMain01 extends Thread{
	
	//쓰레드의 이름을 부여하기 위해서 생성자 정의
	public ThreadMain01(String threadname) {
		super(threadname);
	}
	
	//Thread의 run 메서드 재정의
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			
			try {
				sleep(1000);//지정된 시간만큼 수행을 멈춤
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.printf(
				"쓰레드 이름 : %s,",currentThread().getName());
			System.out.printf("temp value : %d%n",i);
		}
	}
	
	public static void main(String[] args) {
		ThreadMain01 th = new ThreadMain01("첫번째");
		//run()메서드를 직접 호출하게 되면 쓰레드 기능을 사용할 수 없음
		//th.run();
		th.start();// -> run()메서드 호출
	}
	
}


