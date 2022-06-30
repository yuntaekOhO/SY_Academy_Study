package kr.s09.thistest;

public class AnimalMain {
	/*
	 * [실습]
	 * 1)Animal 객체 생성, 인자가 있는 생성자를 이용해서 날 수 있는 동물을 생성하고
	 *  이름, 나이, 비행여부를 출력하시오
	 * 2)Aniaml 객체 생성, 인자가 없는 생성자를 이용해서 날 수 없는 동물을 생성하고
	 *  이름, 나이, 비행여부를 출력하시오
	 */
	public static void main(String[] args) {
		//1)
		Animal ani1 = new Animal("비둘기",5,true);

		System.out.println(ani1.getName() + "는 " + ani1.getAge() + "살, " + 
													"비행여부 : " + printFly(ani1.isFly()));
		
		//2)
		Animal ani2 = new Animal();
		ani2.setName("호랑이");
		ani2.setAge(11);
		ani2.setFly(false);

		System.out.println(ani2.getName() + "는 " + ani2.getAge() + "살, " + 
													"비행여부 : " + printFly(ani2.isFly()));
	}
	public static String printFly(boolean fly) {
		return fly ? "가능" : "불가능";
	}
}
