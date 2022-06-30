package kr.s01.field;
public class Student02 {
	//필드(속성)
	String name;
	int age;
	String hobby;
	
	public static void main(String[] args) {
		//객체 선언 및 생성
		Student02 student = new Student02();
		
		//객체의 필드에 값을 저장
		student.name = "홍길동";
		student.age = 20;
		student.hobby = "축구";
		
		//객체의 필드에 저장된 값 읽기
		System.out.println(student.name +", "+ student.age +", "+ student.hobby);
		
		System.out.println("---------------");
		
		Student02 student2 = new Student02();
		student2.name = "박문수";
		student2.age = 45;
		student2.hobby = "야구";
		
		System.out.println(student2.name +", "+ student2.age +", "+ student2.hobby);
	}

}
