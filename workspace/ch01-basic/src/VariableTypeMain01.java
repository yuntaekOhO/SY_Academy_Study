public class VariableTypeMain01 {

	public static void main(String[] args) {
		System.out.println("====논리형====");
		// true, false
		boolean b = true;
		System.out.println("b = " + b);
		
		System.out.println("====문자형====");
		//크기 : 2byte, 표현범위 : 0 ~ 65,535
		//다국어 처리를 위한 유니코드(unicode)방식 , ASCII 코드(10진, 영문,특문)는 유니코드에 포함된다
		//영어는 1byte로 표현 가능하지만 다국어의 경우 불가능하기 때문에 2byte 
		char c1 = 'A';
		System.out.println("c1 = " + c1);
		
		//A에 해당되는 아스키코드값 직접 대입, 출력시 A 출력
		char c2 = 65;
		System.out.println("c2 = " + c2);
		
		//A에 해당되는 유니코드값 직접 대입, 출력시 A 출력
		char c3 = '\u0041';
		System.out.println("c3 = " + c3);
		
		char c4 = '자';
		System.out.println("c4 = " + c4);
		
		//'자'에 해당되는 유니코드 값 직접 대입
		char c5 = '\uc790';
		System.out.println("c5 = " + c5);
		
		System.out.println("====정수형====");
		//byte, 크기 : 1byte, 표현범위 : -128 ~ 127
		byte b1 = 127;
		System.out.println("b1 = " + b1);
		
		//short, 크기 : 2byte, 표현범위 : -32,768 ~ 32,767
		short s1 = 32767;
		System.out.println("s1 = " + s1);
		
		//int, 크기 : 4byte, 표현범위 : -2,147,483,648 ~ 2,147,483,647
		int i1 = 214483647;
		System.out.println("i1 = " + i1);
		
		//long, 크기 : 8byte, 표현범위 : -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807
		//int와 겹치는 부분이 생김, 값을 대입하기전 초기에 int로 인식함 그것을 분별하기위해 L 표시
		//은행, 증권사같은 경우에서 사용
		long lg = 100L;
		System.out.println("lg = " + lg);

		System.out.println("====실수형====");
		//float, 크기 : 4byte
		float f1 = 9.1f;
		System.out.println("f1 = " + f1);
		
		//double, 크기 : 8byte, 실수형 기본
		double d1 = 9.8;
		System.out.println("d1 = " + d1);
	
		System.out.println("====문자열 표시====");
		//기본자료형이 아님, 참조자료형
		String str = "Hello World";
		System.out.println("str = " + str);
		
	}

}
