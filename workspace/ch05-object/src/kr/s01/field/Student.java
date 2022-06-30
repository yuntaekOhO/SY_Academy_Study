package kr.s01.field;
public class Student {
	//필드(속성)
	String name;
	int age;
	
	public static void main(String[] args) {
		//객체 선언
		Student student;
		//객체 생성
		student = new Student();
		//필드에 값을 할당
		student.name = "홍길동";
		student.age = 20;
		
		//필드에 저장된 값을 호출해서 출력
		System.out.println(student.name + ", " + student.age);
	}
}
