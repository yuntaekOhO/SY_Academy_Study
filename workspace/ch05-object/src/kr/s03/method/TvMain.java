package kr.s03.method;
class Tv{
	//Tv의 속성(멤버변수)
	boolean power;//전원 상태
	int channel;//채널
	
	//Tv의 동작(멤버메서드)
	public void isPower() {//tv를 켜거나 끄는 기능
		power = !power;
	}
	
	public void channelUp() {//tv채널을 높이는 기능
		++channel;
	}
	public void channelDown() {//tv채널을 줄이는 기능
		--channel;
	}
}


public class TvMain {

	public static void main(String[] args) {
		//객체 생성 및 선언
		Tv t = new Tv();
		t.isPower();
		System.out.println("Tv 실행 여부 : " + t.power);
		System.out.println("현재 채널 : " + t.channel);
		System.out.println("-------------------------------");
		//채널 변경
		t.channel = 7;
		System.out.println("첫번째 변경된 채널 : " + t.channel);
		System.out.println("-------------------------------");
		
		//채널 번경
		t.channelDown();
		System.out.println("두번째 변경된 채널 : " + t.channel);
		System.out.println("-------------------------------");
		
		//Tv 끄기
		t.isPower();
		System.out.println("Tv 실행 여부 : " + t.power);
	}

}
