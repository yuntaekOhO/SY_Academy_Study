package kr.s11.inter;

interface InterOne{
	public abstract void make();//추상메서드
}
//일반클래스에 인터페이스를 구현
class Student implements InterOne{
	//추상메서드 구현
	@Override
	public void make() {
		System.out.println("make 메서드");
	}
	
	public void study() {
		System.out.println("study 메서드");
	}
	
}
public class InterMain04 {

	public static void main(String[] args) {
		Student st = new Student();
		st.make();
		st.study();
		System.out.println("--------------");
		
		InterOne i = st;// 클래스타입 -> 인터페이스타입 형변환
						// 자동적으로 형변환
		i.make();
		//i.study(); 호출 범위를 벗어나서 호출 불가능
		System.out.println("--------------");
		
		Student st2 = (Student) i;// 인터페이스타입 -> 클래스타입 형변환
								  // 명시적으로 형변환
		st2.make();
		st2.study();
	}

}
