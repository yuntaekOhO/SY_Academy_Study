public class VariableTypeCast01 {

	public static void main(String[] args) {
		//묵시적 형변환(자동 형변환)
		//작은 자료형에서 큰 자료형으로 승격, 정보의 손실이 전혀 없음
		
		//byte 표현범위 : -128 ~ 127 (8bit)
		byte b1 = 127;
		byte b2 = 127;
		//32bit(4byte) 미만의 byte형 데이터를 연산하면 32bit로 승격
		int b3 = b1 + b2;
		System.out.println("b3 = " + b3);
		
		//short 표현범위 : -32768 ~ 32767 (16bit)
		short s1 = 32767;
		short s2 = 32767;
		//32bit(4byte) 미만의 short형 데이터를 연산하면 32bit로 승격
		int s3 = s1 + s2;
		System.out.println("s3 = " + s3);
		
		int in1 = 234;
		long lg1 = in1; //작은 자료형 -> 큰 자료형 , 자동 형변환
		System.out.println("lg1 = " + lg1);
		
		int in2 = 1234;
		long lg2 = 5678L;
		//in2의 자료형이 int -> long으로 자동 형변환, 연산은 같은 자료형끼리만 된다
		long result1 = in2 + lg2;
		System.out.println("result1 = " + result1);
		
		int in3 = 23;
		double du1 = 10.5;
		//in3의 자료형이 연산 과정에서 int -> double로 자동 형변환 (23.0) 
		double result2 = in3 + du1;
		System.out.println("result2 = " + result2);
	}

}
