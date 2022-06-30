package kr.s06.capsule;

class Capsule{
	//은닉화
	private int a;
	
	//캡슐화
	public void setA(int n) {
		//데이터 검증
		if(n>=0) {
			a = n;
		}else {
			System.out.println("음수는 허용되지 않습니다.");
		}
	}
	
	public int getA() {
		return a;
	}
}

public class CapsuleMain {
	
	public static void main(String[] args) {
		Capsule cap = new Capsule();
		//변수 a의 접근 지정자(제한자)가 private이기 때문에 같은 클래스내에서는 호출이 가능하지만
		//다른 클래스에서 호출 불가능
		//cap.a = 100;  <- error
		
		cap.setA(-100);
		System.out.println(cap.getA());//데이터 호출
		
		System.out.println("-------------------------");
		
		cap.setA(1000);
		System.out.println(cap.getA());
	}

}
