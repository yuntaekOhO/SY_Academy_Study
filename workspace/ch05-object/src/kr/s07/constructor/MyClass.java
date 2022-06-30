package kr.s07.constructor;

public class MyClass {
	private String name;
	private int age;
	
	//인자가 있는 생성자를 정의했는데 디폴트 생성자를 호출하는 경우
	//디폴트 생성자를 명시해야 한다
	public MyClass() {}
	
	//인자가 있는 생성자 정의
	public MyClass(String n, int a) {
		name = n;
		age = a;
	}
	//생성자 오버로딩(생성자 이름이 같고 인자의 자료형 또는 개수가 다름)
	public MyClass(String n) {
		name = n;
	}
	
	public void setName(String n) {
		name = n;
	}
	public String getName() {
		return name;
	}
	public void setAge(int a) {
		age = a;
	}
	public int getAge() {
		return age;
	}
}
