package kr.s01.field;
public class StudentMain {

	public static void main(String[] args) {
		//객체 선언 및 생성
		Student03 student = new Student03();
		
		//객체의 필드에 값 저장
		student.name = "홍길동";
		student.korean = 98;
		student.english = 95;
		student.math = 97;
		student.sum = student.korean + student.english + student.math;
		student.average = student.sum / 3.0;
		
		//객체의 필드에 저장된 값 출력
		System.out.println("이름 : " + student.name);
		System.out.println("국어 : " + student.korean);
		System.out.println("영어 : " + student.english);
		System.out.println("수학 : " + student.math);
		System.out.println("총점 : " + student.sum);
		System.out.printf("평균 : %.2f", student.average);
	}

}
