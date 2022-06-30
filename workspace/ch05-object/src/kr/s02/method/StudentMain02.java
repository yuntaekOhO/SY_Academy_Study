package kr.s02.method;
public class StudentMain02 {
	//멤버변수
	String name;
	int korean;
	int math;
	int english;
	
	//멤버메서드
	//총점 구하기
	public int makeSum() {
		return korean + math + english;
	}
	
	//평균 구하기
	public int makeAverage() {
		return makeSum()/3;
	}
	public static void main(String[] args) {
		StudentMain02 student = new StudentMain02();
		
		student.name = "홍길동";
		student.korean = 98;
		student.math = 97;
		student.english = 96;
		
		System.out.println("이름 : " +student.name);
		System.out.println("국어 : " +student.korean);
		System.out.println("수학 : " +student.math);
		System.out.println("영어 : " +student.english);
		System.out.println("총점 : " +student.makeSum());
		System.out.println("평균 : " +student.makeAverage());
	}

}
