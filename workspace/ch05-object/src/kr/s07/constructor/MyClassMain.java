package kr.s07.constructor;

public class MyClassMain {

	public static void main(String[] args) {
		MyClass mc = new MyClass();
		mc.setName("홍길동");
		mc.setAge(30);
		
		System.out.println("이름 : "+ mc.getName() +", 나이 : "+ mc.getAge());
		System.out.println("-----------------------");
		MyClass mc2 = new MyClass("박문수", 40);
		
		System.out.println("이름 : "+ mc2.getName() +", 나이 : "+ mc2.getAge());
		System.out.println("-----------------------");
		
		MyClass mc3 = new MyClass("장영실");
		mc3.setAge(50);
		System.out.println("이름 : "+ mc3.getName() +", 나이 : "+ mc3.getAge());
	}

}
