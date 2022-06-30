package kr.s09.thistest;

public class Animal {
/*
 * [실습]
 * 멤버변수: private 이름(name), 나이(age), 비행여부(boolean fly)
 * 멤버메서드: public 이름,나이,비행여부 - get/set 메서드
 * 생성자: 인자가 없는 생성자, 인자가 있는 생성자(이름,나이,비행여부)
 */
	private String name;
	private int age;
	private boolean fly;
	
	public Animal() {}
	
	public Animal(String name, int age, boolean fly) {
		this.name = name;
		this.age = age;
		this.fly = fly;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isFly() {
		return fly;
	}

	public void setFly(boolean fly) {
		this.fly = fly;
	}
	
}
