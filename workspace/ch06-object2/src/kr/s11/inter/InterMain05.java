package kr.s11.inter;

interface I {
	public abstract void play();
}

//클래스에 인터페이스 구현
class B implements I {
	// 추상메서드 구현
	@Override
	public void play() {
		System.out.println("피아노를 연주하다.");
	}
}

class C implements I {
	// 추상메서드 구현
	@Override
	public void play() {
		System.out.println("첼로를 연주하다.");
	}
}

class Stage {
	public void autoPlay(I i) {// 클래스타입 -> 인터페이스타입 자동 형변환
		i.play();
	}
}

public class InterMain05 {
	public static void main(String[] args) {
		Stage st = new Stage();
		st.autoPlay(new B());// B -> I (클래스타입 -> 인터페이스타입)
		st.autoPlay(new C());// C -> I (클래스타입 -> 인터페이스타입)
	}
}
