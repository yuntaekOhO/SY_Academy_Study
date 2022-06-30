public class VariableTypeCast02 {

	public static void main(String[] args) {
		//명시적 형변환(강제 형변환)
		//큰 자료형에서 작은 자료형으로 강등, 정보의 손실 가능성이있다
		byte b1 = 127;
		byte b2 = 127;
		//연산의 결과 자료형이 int형으로 자동 형변환 한 것을 다시 byte형으로 강제 형변환함
		byte b3 = (byte)(b1 + b2);
		System.out.println("b3 = " + b3);
		
		short s1 = 32767;
		short s2 = 32767;
		//연산의 결과 자료형이 int형으로 자동 형변환 한 것을 다시 short형으로 강제 형변환함
		short s3 = (short)(s1 + s2);
		System.out.println("s3 = " + s3);
		
		float f1 = 35.13f;
		//큰 자려횽 -> 작은 자료형으로 강제 형변환
		int it = (int)f1;
		System.out.println("it = " + it);
		
		int it2 = 123;
		double du = 100.56;
		//du를 실수(double) -> 정수(int)로 강제 형변환
		int result = it2 + (int)du;
		System.out.println("result = " + result);
	}

}
