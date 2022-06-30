package kr.s05.supertest;

//부모 클래스
class People{
	int a = 100;
	
	public People() {
		//Object의 기본 생성자 호출
		super();
	}
	
}
//자식 클래스
class Student extends People{
	int b = 200;
	
	public Student() {
		//부모 클래스의 (인자가 없는) 기본 생성자 호출 
		super();
	}
	
}

public class SuperMain03 {
	public static void main(String[] args) {
		Student st = new Student();
	}
}
