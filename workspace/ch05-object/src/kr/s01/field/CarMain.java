package kr.s01.field;
class Car {
	//필드
	String company = "현대자동차";
	String model = "소나타";
	String color = "검정";
	int maxSpeed;
	int speed;
	
}


public class CarMain {

	public static void main(String[] args) {
		//객체 선언 및 생성
		Car myCar = new Car();
		
		//객체의 필드에 저장된 기본값 출력
		System.out.println("제작회사 :"+ myCar.company);
		System.out.println("모델명 : "+ myCar.model);
		System.out.println("색깔 : "+ myCar.color);
		System.out.println("최고 속도 : "+ myCar.maxSpeed);
		System.out.println("현재 속도 : "+ myCar.speed);
		System.out.println("--------------------");
		
		//객체의 필드에 값 저장
		myCar.maxSpeed = 500;
		myCar.speed = 300;
		
		//객체의 필드에 저장된 값 출력
		System.out.println("제작회사 :"+ myCar.company);
		System.out.println("모델명 : "+ myCar.model);
		System.out.println("색깔 : "+ myCar.color);
		System.out.println("최고 속도 : "+ myCar.maxSpeed);
		System.out.println("현재 속도 : "+ myCar.speed);
	}

}
