package kr.s04.p1;

//호출하고자 하는 클래스를 등록
import kr.s04.p2.PackTwo;

public class PackMain {

	public static void main(String[] args) {
		//kr.s04.p1.PackOne p1 = new kr.s04.p1.PackOne();
		//같은 패키지의 클래스를 호출해서 객채 생성을 할 때는 패키지 생략 가능
		PackOne p1 = new PackOne();
		
		//다른 패키지의 클래스를 호출할 때는 패키지를 반드시 명시해야 함
		//kr.s04.p2.PackTwo p2 = new kr.s04.p2.PackTwo();
		//import문을 이용해서 클래스를 등록하면 패키지를 생략하고 클래스명만 명시 가능
		PackTwo p2 = new PackTwo();
	}

}
